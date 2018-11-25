package br.com.jguedes.teste.dbservice.response;

import java.io.Serializable;
import java.time.LocalDate;

import br.com.jguedes.teste.dbservice.entity.Item;

public class ItemResponseConta implements Serializable {

	private static final long serialVersionUID = 1L;
	private Item item;

	public ItemResponseConta(final Item item) {
		this.item = item;
	}

	public long getId() {
		return item.getId();
	}
	
	public long getFolha_id() {
		return item.getFolha_id();
	}

	public int getSeq() {
		return item.getSeq();
	}

	public String getDiscr() {
		return item.getDiscr();
	}

	public Double getValor() {
		return item.getValor();
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
