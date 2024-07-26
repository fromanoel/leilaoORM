package br.edu.iftm.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.leilao.model.ItemDeLeilao;
import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.service.ItemdeLeilaoService;


@RestController
@RequestMapping("/itemdeleilao")
public class ItemLeilaoController {

	@Autowired
	private ItemdeLeilaoService itemdeLeilaoService;

	@DeleteMapping({"/{id}"})
	public void delete (@PathVariable Long id) {
		itemdeLeilaoService.deletarPorId(id);
	}

	@PostMapping
	public ItemDeLeilao novo(@RequestBody ItemDeLeilao item) {
		return itemdeLeilaoService.novo(item);
	}

	@GetMapping({"/{id}"})
	public ItemDeLeilao item(@PathVariable Long id){
		return itemdeLeilaoService.buscarPorId(id);
	}

	@GetMapping
	public List<ItemDeLeilao> itens() {
		return itemdeLeilaoService.buscarTodos();
	}

	@PutMapping({"/{id}"})
	public ItemDeLeilao atualiza(@RequestBody ItemDeLeilao item, @PathVariable Long id) {
		return itemdeLeilaoService.atualiza(item, id);
	}

	@PatchMapping({"/{id}"})
	public Lance finaliza(@PathVariable Long id) {
    return itemdeLeilaoService.finaliza(id);
}

}
