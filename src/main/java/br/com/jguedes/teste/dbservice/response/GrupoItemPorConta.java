package br.com.jguedes.teste.dbservice.response;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class GrupoItemPorConta implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long conta_id;
	private Set<Long> idItens;

	public GrupoItemPorConta(final Long conta_id, final Long item_id) {
		this.conta_id = conta_id;
		if(idItens == null) {
			idItens = new HashSet<>();
		}
		this.idItens.add(item_id);
	}

	public Long getConta_id() {
		return conta_id;
	}

	public void setConta_id(Long conta_id) {
		this.conta_id = conta_id;
	}

	public Set<Long> getIdItens() {
		return idItens;
	}

	public void setIdItens(Set<Long> idItens) {
		this.idItens = idItens;
	}

	@Override
	public boolean equals(Object obj) {
		Long aux = (Long) obj;
		return aux.equals(this.getConta_id());
	}

}
