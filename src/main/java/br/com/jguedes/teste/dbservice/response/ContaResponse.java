package br.com.jguedes.teste.dbservice.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import br.com.jguedes.teste.dbservice.entity.Conta;

public class ContaResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Conta conta;

	private List<ItemResponseConta> itens;

	private BigDecimal totalConta;

	public ContaResponse(final Conta conta) {
		this.conta = conta;
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
	
	private void carregarValorTotal() {
		totalConta = itens.stream().map(ItemResponseConta::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public void setItens(List<ItemResponseConta> itens) {
		this.itens = itens;
		carregarValorTotal();
	}

}
