package br.edu.iftm.leilao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilao.model.Participante;
import br.edu.iftm.leilao.repository.ParticipanteRepository;

@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository participanteRepository;

	public Participante novo(Participante participante) {
		return participanteRepository.save(participante);
	}

	 public Participante atualiza(Participante participante, Long id) {
		participante.setId(id);
		return participanteRepository.save(participante);
	}

	public Participante buscarPorId(Long id) {
		return participanteRepository.findById(id).get();
	}

	public void deletarPorId(Long id){
		participanteRepository.deleteById(id);
	}

	public List<Participante> listarTodos(){
		return participanteRepository.findAll();
	}
}
