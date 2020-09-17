package br.com.bv.apiProject.service;

import java.util.List;

import br.com.bv.apiProject.model.Hospede;

public interface IHospedeService {

	List<Hospede> findAll();

	void deleteHospede(Integer id);

	void updateHospede(Hospede hospede, Integer id);

	Hospede findByCodigo(Integer id);

	void save(Hospede hospede);

	Hospede findByName(String name);

	Hospede findByDocumento(String name);

	Hospede findByTelefone(String telefone);


}
