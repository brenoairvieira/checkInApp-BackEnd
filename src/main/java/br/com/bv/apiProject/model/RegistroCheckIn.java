package br.com.bv.apiProject.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "tbregistrocheckin") 
public class RegistroCheckIn implements Serializable {

	private static final long serialVersionUID = -4670616447185887146L;

	@Id
    @SequenceGenerator(name="tbregistrocheckin_codigo_seq", sequenceName="tbregistrocheckin_codigo_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tbregistrocheckin_codigo_seq")
	@Column(name = "codigo", unique = true, nullable = false)
	private Integer codigo;

	@Column(name = "data_entrada", nullable = false)
	private LocalDate dataEntrada;

	@Column(name = "data_saida", nullable = false)
	private LocalDate dataSaida;
	
	@Column(name = "adicional_veiculo", nullable = false)
	private Boolean adicionalVeiculo;
	
	@ManyToOne
	@JoinColumn(name = "hospede", referencedColumnName = "codigo")
	private Hospede hospede;
	
	@Column(name = "valor_estadia", nullable = false)
	private BigDecimal valorEstadia;
	
	
	public RegistroCheckIn() {
		super();
	}

	public RegistroCheckIn(Integer codigo, LocalDate dataEntrada, LocalDate dataSaida, Boolean adicionalVeiculo,
			Hospede hospede) {
		super();
		this.codigo = codigo;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.adicionalVeiculo = adicionalVeiculo;
		this.hospede = hospede;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public LocalDate getDataEntrada() {
		return dataEntrada;
	}


	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}


	public LocalDate getDataSaida() {
		return dataSaida;
	}


	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}


	public Boolean getAdicionalVeiculo() {
		return adicionalVeiculo;
	}


	public void setAdicionalVeiculo(Boolean adicionalVeiculo) {
		this.adicionalVeiculo = adicionalVeiculo;
	}


	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public BigDecimal getValorEstadia() {
		return valorEstadia;
	}

	public void setValorEstadia(BigDecimal valorEstadia) {
		this.valorEstadia = valorEstadia;
	}

}
