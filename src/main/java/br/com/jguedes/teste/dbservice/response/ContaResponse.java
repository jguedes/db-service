package br.com.jguedes.teste.dbservice.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.jguedes.teste.dbservice.entity.Conta;
import br.com.jguedes.teste.dbservice.entity.Item;

public class ContaResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Conta conta;

	private List<ItemResponseConta> itens;

	private BigDecimal totalConta;

	public ContaResponse(final Conta conta) {
		this.conta = conta;
		carregarItensAndTotais();
	}

	public long getId() {
		return conta.getId();
	}

	public char getTipo() {
		return conta.getTipo();
	}

	public String getTitulo() {
		return conta.getTitulo();
	}

	public String getDescricao() {
		return conta.getDescricao();
	}

	public int getOrdem() {
		return conta.getOrdem();
	}

	public List<ItemResponseConta> getItens() {
		return itens;
	}

	public BigDecimal getTotalConta() {
		return totalConta;
	}
	
	private void carregarItensAndTotais() {
		itens = new ArrayList<>();
		if (Optional.ofNullable(conta).isPresent() && Optional.ofNullable(conta.getItens()).isPresent()) {
			for (Item item : conta.getItens()) {
				this.itens.add(new ItemResponseConta(item));
			}
			totalConta = itens.stream().map(ItemResponseConta::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
		}
	}

}
