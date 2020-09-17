package br.com.bv.apiProject.service.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.bv.apiProject.model.HospedeDTO;
import br.com.bv.apiProject.model.RegistroCheckIn;
import br.com.bv.apiProject.projection.HospedeProjection;
import br.com.bv.apiProject.projection.ValorGastoProjection;
import br.com.bv.apiProject.repository.RegistroCheckInRepository;
import br.com.bv.apiProject.service.IRegistroCheckInService;


@Service
public class RegistroChekcInService implements IRegistroCheckInService {

	private static final BigDecimal VALOR_DIA_UTIL = new BigDecimal(120);
	private static final BigDecimal VALOR_FIM_SEMANA = new BigDecimal(150);
	private static final BigDecimal VALOR_GARAGEM_DIA_UTIL = new BigDecimal(15);
	private static final BigDecimal VALOR_GARAGEM_FIM_DE_SEMANA = new BigDecimal(20);

	
	@Autowired
	private RegistroCheckInRepository repository;

	@Override
	public List<RegistroCheckIn> findAll() {

		List<RegistroCheckIn> list = new ArrayList<RegistroCheckIn>();

		repository.findAll().forEach(list::add);

		return list;
	}

	@Override
	public void save(RegistroCheckIn registroCheckIn) {
		resolverPreDependencias(registroCheckIn); 
		repository.save(registroCheckIn);
	}
	
	private void resolverPreDependencias(RegistroCheckIn registroCheckIn) {
		LocalDate data = registroCheckIn.getDataEntrada();
		
		BigDecimal totalEstadia = BigDecimal.ZERO;
		
		while (data.compareTo(registroCheckIn.getDataSaida()) <= 0) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(Date.valueOf(data));
			
			if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY 
					|| calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				totalEstadia = registroCheckIn.getAdicionalVeiculo() ?
							totalEstadia.add(VALOR_FIM_SEMANA).add(VALOR_GARAGEM_FIM_DE_SEMANA) : totalEstadia.add(VALOR_FIM_SEMANA);
			} else {
				totalEstadia = registroCheckIn.getAdicionalVeiculo() ?
						totalEstadia.add(VALOR_DIA_UTIL).add(VALOR_GARAGEM_DIA_UTIL) : totalEstadia.add(VALOR_DIA_UTIL);
			}
			data = data.plusDays(1);
		}
		
		registroCheckIn.setValorEstadia(totalEstadia);
	}

	@Override
	public RegistroCheckIn findByCodigo(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void updateRegistroCheckIn(RegistroCheckIn registroCheckIn, Integer id) {

		RegistroCheckIn registroCheckInDB = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	
		registroCheckInDB.setAdicionalVeiculo(registroCheckIn.getAdicionalVeiculo());
		registroCheckInDB.setDataEntrada(registroCheckIn.getDataEntrada());
		registroCheckInDB.setDataSaida(registroCheckIn.getDataSaida());
		registroCheckInDB.setHospede(registroCheckIn.getHospede());

		repository.save(registroCheckInDB);
	}


	@Override
	public void deleteRegistroCheckIn(Integer id) {
		repository.deleteById(id);
	}
	
	@Override
	public List<HospedeDTO> consultarHospedesNaoAlocados() {
		List<HospedeProjection> projections = repository.consultarHospedesNaoAlocados();
		List<HospedeDTO> lista = montarListaFromProjection(projections);
		
		return lista;
	}
	
	@Override
	public List<HospedeDTO> consultarHospedesAlocados() {
		List<HospedeProjection> projections = repository.consultarHospedesAlocados();
		List<HospedeDTO> lista = montarListaFromProjection(projections);
		
		return lista;
	}

	private List<HospedeDTO> montarListaFromProjection(List<HospedeProjection> projections) {
		List<HospedeDTO> lista = new ArrayList<HospedeDTO>();
		
		for (HospedeProjection projection : projections) {
			HospedeDTO hospede = new HospedeDTO();
			hospede.setCodigo(projection.getCodigo());
			hospede.setNome(projection.getNome());
			hospede.setDocumento(projection.getDocumento());
			hospede.setTelefone(projection.getTelefone());
			
			ValorGastoProjection valorGastoProjection = repository.consultarValoreGastoUltimaEstdiaPorHospede(hospede.getCodigo());
			
			if (valorGastoProjection != null && valorGastoProjection.getValorGastoUltimaEstadia() != null){ 
				hospede.setValorUltimaEstadia(valorGastoProjection.getValorGastoUltimaEstadia());
			}
			
			ValorGastoProjection valorGastoTotalProjection = repository.consultarTotalValorGastoPorHospede(hospede.getCodigo());
		
			if (valorGastoTotalProjection != null && valorGastoTotalProjection.getValorGastoTotal() != null){ 
				hospede.setValorTotalGasto(valorGastoTotalProjection.getValorGastoTotal());

			}
		lista.add(hospede);
		}
		return lista;
	}
	
}
