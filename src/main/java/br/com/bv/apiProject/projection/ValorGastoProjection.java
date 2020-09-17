package br.com.bv.apiProject.projection;

import java.math.BigDecimal;

public interface ValorGastoProjection {
	
	BigDecimal getValorGastoUltimaEstadia();
	BigDecimal getValorGastoTotal();
	
	BigDecimal setValorGastoUltimaEstadia();
	BigDecimal setValorGastoTotal();
	
}
