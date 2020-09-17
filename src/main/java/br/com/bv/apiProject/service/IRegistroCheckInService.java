package br.com.bv.apiProject.service;

import java.util.List;

import br.com.bv.apiProject.model.HospedeDTO;
import br.com.bv.apiProject.model.Hospede;
import br.com.bv.apiProject.model.RegistroCheckIn;

public interface IRegistroCheckInService {

	List<RegistroCheckIn> findAll();

	RegistroCheckIn findByCodigo(Integer id);

	void deleteRegistroCheckIn(Integer id);

	void updateRegistroCheckIn(RegistroCheckIn registroCheckIn, Integer id);

	void save(RegistroCheckIn registroCheckIn);

	List<HospedeDTO> consultarHospedesNaoAlocados();

	List<HospedeDTO> consultarHospedesAlocados();



}
