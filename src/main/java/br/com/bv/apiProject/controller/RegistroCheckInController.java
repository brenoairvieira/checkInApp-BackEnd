package br.com.bv.apiProject.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bv.apiProject.model.HospedeDTO;
import br.com.bv.apiProject.model.RegistroCheckIn;
import br.com.bv.apiProject.service.IRegistroCheckInService;

@RestController
public class RegistroCheckInController {
	
	@Autowired
	private IRegistroCheckInService registroCheckInService;

	@RequestMapping("/checkIn/listar")
	public List<RegistroCheckIn> getRegistros(){
		return registroCheckInService.findAll();
	}
	
	@RequestMapping("/chekcIn/{id}")
	public RegistroCheckIn getRegistro(@PathVariable Integer id){
		return registroCheckInService.findByCodigo(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/checkIn")
	public void addRegistro(@RequestBody RegistroCheckIn registro){
		registroCheckInService.save(registro);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/checkIn/{id}")
	public void updateRegistro(@RequestBody RegistroCheckIn registro, @PathVariable Integer id){
		registroCheckInService.updateRegistroCheckIn(registro, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/chekcIn/{id}")
	public void deleteHospede(@PathVariable Integer id){
		registroCheckInService.deleteRegistroCheckIn(id);
	}

	@RequestMapping("/checkIn/consultarHospedesNaoAlocados")
	public List<HospedeDTO> consultarHospedesNaoAlocados(){
		return registroCheckInService.consultarHospedesNaoAlocados();

	}
	
	@RequestMapping("/checkIn/consultarHospedesAlocados")
	public List<HospedeDTO> consultarHospedesAlocados(){
		return registroCheckInService.consultarHospedesAlocados();
	}
	
	
}
