package br.com.bv.apiProject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.bv.apiProject.model.Hospede;
import br.com.bv.apiProject.repository.HospedeRepository;
import br.com.bv.apiProject.service.IHospedeService;

@Service
public class HospedeService implements IHospedeService {

	@Autowired
	private HospedeRepository hospedeRepository;

	@Override
	public List<Hospede> findAll() {

		List<Hospede> list = new ArrayList<Hospede>();

		hospedeRepository.findAll().forEach(list::add);

		return list;
	}

	@Override
	public void save(Hospede hospede) {
		hospedeRepository.save(hospede);
	}

	@Override
	public Hospede findByCodigo(Integer id) {
		return hospedeRepository.findById(id).orElse(null);
	}
	
	@Override
	public Hospede findByName(String name) {
		return hospedeRepository.findByNome(name);
	}
	
	@Override
	public Hospede findByDocumento(String name) {
		return hospedeRepository.findByDocumento(name);
	}
	
	@Override
	public Hospede findByTelefone(String telefone) {
		return hospedeRepository.findByTelefone(telefone);
	}
	

	@Override
	public void updateHospede(Hospede hospede, Integer id) {
		Hospede hospedeDB = hospedeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		hospedeDB.setNome(hospede.getNome());
		hospedeDB.setDocumento(hospede.getDocumento());
		hospedeDB.setTelefone(hospede.getTelefone());
		hospedeRepository.save(hospedeDB);
	}


	@Override
	public void deleteHospede(Integer id) {
		hospedeRepository.deleteById(id);
	}

}
