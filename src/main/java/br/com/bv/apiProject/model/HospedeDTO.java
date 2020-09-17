package br.com.bv.apiProject.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class HospedeDTO implements Serializable {

	private static final long serialVersionUID = -4670616447185887146L;

	private Integer codigo;
	private String nome;
	private String documento;
	private String telefone;
	private BigDecimal valorUltimaEstadia;
	private BigDecimal valorTotalGasto;
	
	
	public HospedeDTO() {
		super();
	}


	public HospedeDTO(Integer codigo, String nome, String documento, String telefone, BigDecimal valorUltimaEstadia,
			BigDecimal valorTotalGasto) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.documento = documento;
		this.telefone = telefone;
		this.valorUltimaEstadia = valorUltimaEstadia;
		this.valorTotalGasto = valorTotalGasto;
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



	public BigDecimal getValorUltimaEstadia() {
		return valorUltimaEstadia;
	}



	public void setValorUltimaEstadia(BigDecimal valorUltimaEstadia) {
		this.valorUltimaEstadia = valorUltimaEstadia;
	}



	public BigDecimal getValorTotalGasto() {
		return valorTotalGasto;
	}



	public void setValorTotalGasto(BigDecimal valorTotalGasto) {
		this.valorTotalGasto = valorTotalGasto;
	}


}
