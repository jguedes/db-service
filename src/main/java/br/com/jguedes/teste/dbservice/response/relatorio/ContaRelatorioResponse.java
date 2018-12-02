package br.com.jguedes.teste.dbservice.response.relatorio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import br.com.jguedes.teste.dbservice.entity.Conta;
import br.com.jguedes.teste.dbservice.response.ItemResponseConta;

public class ContaRelatorioResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Conta conta;

	private List<ItemResponseConta> itens;

	private BigDecimal totalConta;

	public ContaRelatorioResponse(final Conta conta) {
		this.conta = conta;
	}

	public long getId() {
		return conta.getId();
	}

	public String getTitulo() {
		return conta.getTitulo();
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
