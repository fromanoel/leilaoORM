package br.edu.iftm.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.service.LanceService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/lance")
public class LanceController {

	private final LanceService lanceService;
	@Autowired
	public LanceController(LanceService lanceService){
		this.lanceService = lanceService;
	}


	@DeleteMapping({"/{id}"})
	public void delete(@PathVariable Long id){
		lanceService.deletarPorId(id);
	}


	@GetMapping({"/{id}"})
	public List <Lance> lance(@PathVariable Long id){
		return lanceService.buscaLance(id);
	}

	@PutMapping({"/{id}"})
	public Lance atualiza(@PathVariable Long id, @RequestBody Lance lance){
		return lanceService.atualiza(lance, id);
	}

	@GetMapping
	public List<Lance> lances(){
		return lanceService.buscaLances();
	}

}
