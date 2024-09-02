package br.edu.iftm.leilao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.repository.LanceRepository;

@Service
public class LanceService {


	private final LanceRepository lanceRepository;

    @Autowired
    public LanceService(LanceRepository lanceRepository) {
        this.lanceRepository = lanceRepository;
    }

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
