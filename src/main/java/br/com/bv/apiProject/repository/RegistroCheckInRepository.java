package br.com.bv.apiProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.bv.apiProject.model.RegistroCheckIn;
import br.com.bv.apiProject.projection.HospedeProjection;
import br.com.bv.apiProject.projection.ValorGastoProjection;

public interface RegistroCheckInRepository extends JpaRepository<RegistroCheckIn, Integer> {

	
	@Query(
			value=
					"	SELECT HOSPEDE.CODIGO,	" + 
					"	HOSPEDE.NOME, " + 
					"	HOSPEDE.DOCUMENTO, " + 
					"	HOSPEDE.TELEFONE " + 
					"		FROM tbregistrocheckin registro  " + 
					"		inner join tbhospede hospede on registro.hospede = hospede.codigo " + 
					"		where registro.data_saida < now()                                      ",
					nativeQuery = true
			)
	public List<HospedeProjection> consultarHospedesNaoAlocados();
	
	
	@Query(
			value=
					"	SELECT HOSPEDE.CODIGO,	" + 
					"	HOSPEDE.NOME, " + 
					"	HOSPEDE.DOCUMENTO, " + 
					"	HOSPEDE.TELEFONE " + 
					"		FROM tbregistrocheckin registro  " + 
					"		inner join tbhospede hospede on registro.hospede = hospede.codigo " + 
					"		where registro.data_saida > now()                                      ",
					nativeQuery = true
			)
	public List<HospedeProjection> consultarHospedesAlocados();
	
	@Query(
			value=
					"	select valor_estadia as valorGastoUltimaEstadia from tbregistrocheckin "  + 
					"	where codigo = (select max(codigo) from tbregistrocheckin"  + 
					"		where hospede = :codigoHospede)"  + 
					"		and hospede = :codigoHospede                             ",
					nativeQuery = true
			)
	public ValorGastoProjection consultarValoreGastoUltimaEstdiaPorHospede(@Param("codigoHospede")Integer codigoHospede);
	
	
	@Query(
			value=
					"	select sum(valor_estadia) as valorGastoTotal from tbregistrocheckin " + 
					"	where hospede = :codigoHospede                          ",
					nativeQuery = true
			)
	public ValorGastoProjection consultarTotalValorGastoPorHospede(@Param("codigoHospede")Integer codigoHospede);
	
}
