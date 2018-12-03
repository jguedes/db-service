package br.com.jguedes.teste.dbservice.response.item;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.jguedes.teste.dbservice.commons.Valuable;
import br.com.jguedes.teste.dbservice.entity.Item;

public abstract class BasicItemResponse  implements Valuable, Serializable {

	private static final long serialVersionUID = 1L;
	protected Item item;

	public BasicItemResponse(Item item) {
		this.item= item;
	}

	public long getId() {
		return item.getId();
	}

	public int getSeq() {
		return item.getSeq();
	}

	public String getDiscr() {
		return item.getDiscr();
	}

	public BigDecimal getValor() {
		return item.getValor();
	}

	public String getObser() {
		return item.getObser();
	}

	public LocalDate getDtCadastro() {
		return item.getDtCadastro();
	}

}
