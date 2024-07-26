package br.edu.iftm.leilao.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"lancesRecebidos","lanceVencedor"})
@EqualsAndHashCode(of = {"nome", "valorMinimo"})
@Entity
public class ItemDeLeilao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double valorMinimo;
	private boolean leilaoAberto;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Lance> lancesRecebidos = new ArrayList<Lance>();

	@OneToOne
	private Lance lanceVencedor;

	public ItemDeLeilao(String nome, Double valorMinimo, boolean leilaoAberto) {
		super();
		this.nome = nome;
		this.valorMinimo = valorMinimo;
		this.leilaoAberto = leilaoAberto;
	}

	public void adicionarLance(Lance lance) {
		if (lance.getValor() >= this.valorMinimo) {
			this.lancesRecebidos.add(lance);
		}
	}

	public List<Lance> getLancesRecebidos() {
        return lancesRecebidos;
    }

}
