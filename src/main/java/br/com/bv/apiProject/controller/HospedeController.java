package br.com.bv.apiProject.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bv.apiProject.model.Hospede;
import br.com.bv.apiProject.service.IHospedeService;

@RestController
public class HospedeController {
	
	@Autowired
	private IHospedeService hospedeService;

	@RequestMapping("/hospedes")
	public List<Hospede> getHospedes(){
		return hospedeService.findAll();
	}
	
	@RequestMapping("/hospedes/{id}")
	public Hospede getHospede(@PathVariable Integer id){
		return hospedeService.findByCodigo(id);
	}
	
	@RequestMapping("/hospedes/findByName/{name}")
	public Hospede findByName(@PathVariable String name){
		return hospedeService.findByName(name);
	}
	
	@RequestMapping("/hospedes/findByDocumento/{documento}")
	public Hospede findByDocumento(@PathVariable String documento){
		return hospedeService.findByDocumento(documento);
	}
	
	@RequestMapping("/hospedes/findByTelefone/{telefone}")
	public Hospede findByTelefone(@PathVariable String telefone){
		return hospedeService.findByTelefone(telefone);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/hospedes")
	public void addHospede(@RequestBody Hospede hopede){
		hospedeService.save(hopede);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/hospedes/{id}")
	public void updateHospede(@RequestBody Hospede hopede, @PathVariable Integer id){
		hospedeService.updateHospede(hopede, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/hospedes/{id}")
	public void deleteHospede(@PathVariable Integer id){
		hospedeService.deleteHospede(id);
	}
	
	
}
