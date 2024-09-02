package br.edu.iftm.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.leilao.model.Participante;
import br.edu.iftm.leilao.service.ParticipanteService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/participante")
public class ParticipanteController {

	private final ParticipanteService participanteService;

	@Autowired
	public ParticipanteController(ParticipanteService participanteService){
		this.participanteService = participanteService;
	}

	@PostMapping
	public Participante create(@RequestBody Participante participante) {
		return participanteService.novo(participante);

	}

	@DeleteMapping({"/{id}"})
	public void delete(@PathVariable Long id) {
		participanteService.deletarPorId(id);
	}

	@GetMapping({"/{id}"})
	public Participante participante(@PathVariable Long id) {
		return participanteService.buscarPorId(id);
	}

	@GetMapping
	public List<Participante> participantes() {
		return participanteService.listarTodos();
	}

	@PutMapping({"/{id}"})
	public Participante atualiza(@RequestBody Participante participante, @PathVariable Long id) {
		return participanteService.atualiza(participante, id);
	}

	
}
