package br.com.jguedes.teste.dbservice.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.jguedes.teste.dbservice.entity.Item;

public class ItemResponseFolha implements Serializable {

	private static final long serialVersionUID = 1L;
	private Item item;

	public ItemResponseFolha(final Item item) {
		this.item = item;
	}

	public long getId() {
		return item.getId();
	}

	public int getSeq() {
		return item.getSeq();
	}

	public long getConta_id() {
		return item.getConta_id();
	}

	public String getDiscr() {
		return item.getDiscr();
	}

	public BigDecimal getValor() {
		BigDecimal b = BigDecimal.valueOf(item.getValor()); 
		return b;
	}

	public String getComp() {
		return item.getComp();
	}

	public String getObser() {
		return item.getObser();
	}

	public LocalDate getDtCadastro() {
		return item.getDtCadastro();
	}
	
}
