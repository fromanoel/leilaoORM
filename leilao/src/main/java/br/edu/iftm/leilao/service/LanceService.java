package br.edu.iftm.leilao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilao.model.ItemDeLeilao;
import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.model.Participante;
import br.edu.iftm.leilao.repository.LanceRepository;

@Service
public class LanceService {


	@Autowired
	private LanceRepository lanceRepository;

	@Autowired
	private ParticipanteService participanteService;

	public Lance atualiza(Lance lance, Long id) {
		lance.setId(id);
		return lanceRepository.save(lance);
	}

	public void deletarPorId(Long id) {
		lanceRepository.deleteByParticipanteId(id);
	}


	public List<Lance> buscaLance(Long id){
		return lanceRepository.findByParticipanteId(id);
	}

	public List<Lance> buscaLances(){
		return (List<Lance>) lanceRepository.findAll();
	}


}
