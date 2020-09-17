package br.com.bv.apiProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bv.apiProject.model.Hospede;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Integer> {
	
	Hospede findByNome(String nome);
	Hospede findByDocumento(String documento);
	Hospede findByTelefone(String telefone);
}
