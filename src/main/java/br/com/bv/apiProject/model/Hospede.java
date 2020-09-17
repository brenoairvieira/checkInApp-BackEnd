package br.com.bv.apiProject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "tbhospede") 
public class Hospede implements Serializable {

	private static final long serialVersionUID = -4670616447185887146L;

	@Id
    @SequenceGenerator(name="tbhospede_codigo_seq", sequenceName="tbhospede_codigo_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tbhospede_codigo_seq")
	@Column(name = "codigo", unique = true, nullable = false)
	private Integer codigo;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "documento", nullable = false)
	private String documento;
	
	@Column(name = "telefone", nullable = false)
	private String telefone;
	
	public Hospede() {
		super();
	}

	public Hospede(Integer codigo, String nome, String documento, String telefone) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.documento = documento;
		this.telefone = telefone;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
