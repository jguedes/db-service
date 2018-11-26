package br.com.jguedes.teste.dbservice.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import br.com.jguedes.teste.dbservice.entity.Folha;
import br.com.jguedes.teste.dbservice.entity.Item;

public class FolhaResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Folha folha;
	private List<ItemResponseFolha> itens;
	private BigDecimal totalFolha;
	private Map<Long, Set<Long>> itensPorConta;

	public FolhaResponse(final Folha folha) {
		this.folha = folha;
		carregarItensAndTotais();
	}

	public long getId() {
		return folha.getId();
	}

	public char getTipo() {
		return folha.getTipo();
	}

	public int getNum() {
		return folha.getNum();
	}

	public String getAssinatura1() {
		return folha.getAssinatura1();
	}

	public String getAssinatura2() {
		return folha.getAssinatura2();
	}

	public LocalDate getDtFechamento() {
		return folha.getDtFechamento();
	}

	public List<ItemResponseFolha> getItens() {
		return itens;
	}

	public BigDecimal getTotalFolha() {
		return totalFolha;
	}

	public Map<Long, Set<Long>> getItensPorConta() {
		return itensPorConta;
	}

	private void carregarItensAndTotais() {
		itens = new ArrayList<>();
		itensPorConta = new HashMap<Long, Set<Long>>();
		if (Optional.ofNullable(folha).isPresent() && Optional.ofNullable(folha.getItens()).isPresent()) {
			for (Item item : folha.getItens()) {
				this.itens.add(new ItemResponseFolha(item));
			}
			for (ItemResponseFolha item : itens) {
				if (!itensPorConta.containsKey(item.getConta_id())) {
					Set<Long> idItens = new HashSet<>();
					idItens.add(item.getId());
					itensPorConta.put(item.getConta_id(), idItens);
				} else {
					itensPorConta.get(item.getConta_id()).add(item.getId());
				}
			}
			totalFolha = itens.stream().map(ItemResponseFolha::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
		}
	}

}
