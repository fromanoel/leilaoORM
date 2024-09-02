package br.edu.iftm.leilao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.iftm.leilao.model.ItemDeLeilao;
import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.model.Participante;
import br.edu.iftm.leilao.repository.ItemDeLeilaoRepository;
import br.edu.iftm.leilao.repository.LanceRepository;
import br.edu.iftm.leilao.repository.ParticipanteRepository;

@SpringBootApplication
public class LeilaoApplication implements CommandLineRunner {

	
	private final ParticipanteRepository participante;

	private final ItemDeLeilaoRepository itemDeLeilaoRepository;

	private final LanceRepository lanceRepository;

	public LeilaoApplication(ParticipanteRepository participante, ItemDeLeilaoRepository itemDeLeilaoRepository, LanceRepository lanceRepository){
		this.participante = participante;
		this.itemDeLeilaoRepository = itemDeLeilaoRepository;
		this.lanceRepository = lanceRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LeilaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ItemDeLeilao bicicleta = new ItemDeLeilao("Bicicleta", 100.0, true);
		Participante joao = new Participante("João", "12345");
		Lance lance = new Lance(300.0, joao);
		bicicleta.adicionarLance(lance);

		participante.save(joao);
		lanceRepository.save(lance);
		itemDeLeilaoRepository.save(bicicleta);

		itemDeLeilaoRepository.findAll().forEach(item -> {
			for (Lance l : item.getLancesRecebidos()) {
				System.out.println("Item: " + item.getNome() + " - Lance: " + l.getValor() + " - Participante: "
						+ l.getParticipante().getNome());

			}
		});
	}

}
