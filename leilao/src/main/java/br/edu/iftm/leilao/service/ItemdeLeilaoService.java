package br.edu.iftm.leilao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.leilao.model.ItemDeLeilao;
import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.repository.ItemDeLeilaoRepository;
import br.edu.iftm.leilao.service.exceptions.LeilaoException;

@Service
public class ItemdeLeilaoService {
//

	private final ItemDeLeilaoRepository itemDeLeilaoRepository;

	@Autowired
	public ItemdeLeilaoService(ItemDeLeilaoRepository itemDeLeilaoRepository){
		this.itemDeLeilaoRepository = itemDeLeilaoRepository;
	}
//{DELETE [/itemdeleilao/{id}]}: delete(Long)
// {GET [/itemdeleilao/{id}]}: item(Long)
// {PUT [/itemdeleilao/{id}]}: atualiza(Long,ItemDeLeilao)
// {POST [/itemdeleilao]}: novo(ItemDeLeilao)
// {GET [/itemdeleilao]}: itens()

	public ItemDeLeilao novo(ItemDeLeilao item) {
		return itemDeLeilaoRepository.save(item);
	}

	public ItemDeLeilao buscarPorId(Long id) {
		return itemDeLeilaoRepository.findById(id).get();
	}

	public void deletarPorId(Long id) {
		itemDeLeilaoRepository.deleteById(id);
	}

	public ItemDeLeilao atualiza(ItemDeLeilao item, Long id) {
		item.setId(id);
		return itemDeLeilaoRepository.save(item);
	}

	public List<ItemDeLeilao> buscarTodos() {
		List<ItemDeLeilao> itens = new ArrayList<>();
		itemDeLeilaoRepository.findAll().forEach(itens::add);
		return itens;
	}
	
		public Lance finaliza(long id) { // retorna o lance vencedor e fecha o leilao
			Optional<ItemDeLeilao> optionalItem = itemDeLeilaoRepository.findById(id);
			if (!optionalItem.isPresent()) {
				throw new LeilaoException("Item de leilão não encontrado");
			}
	
			ItemDeLeilao item = optionalItem.get();
	
			// Inicializa o lance vencedor com o primeiro lance ou null
			Lance lanceVencedor = item.getLancesRecebidos().isEmpty() ? null : item.getLancesRecebidos().get(0);
	
			for (Lance lance : item.getLancesRecebidos()) {
				if (lanceVencedor == null || lance.getValor() > lanceVencedor.getValor()) {
					lanceVencedor = lance;
				}
			}
	
			if (item.isLeilaoAberto()) {
				item.setLanceVencedor(lanceVencedor);
				item.setLeilaoAberto(false);
				itemDeLeilaoRepository.save(item);
				return lanceVencedor;
			} else {
				throw new LeilaoException("Leilão já finalizado.");
			}
		}
	

}
