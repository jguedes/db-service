package br.com.jguedes.teste.dbservice.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "folha")
public class Folha implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "relatorio_mensal_id")
	private long relatorio_mensal_id;

	@Column(name = "tipo")
	private char tipo;

	@Column(name = "num")
	private int num;

	@Column(name = "assinatura1")
	private String assinatura1;

	@Column(name = "assinatura2")
	private String assinatura2;

	@Column(name = "dt_fechamento")
	private LocalDate dtFechamento;

	@OneToMany()
	@JoinColumn(name = "folha_id")
	private List<Item> itens;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRelatorio_mensal_id() {
		return relatorio_mensal_id;
	}

	public void setRelatorio_mensal_id(long relatorio_mensal_id) {
		this.relatorio_mensal_id = relatorio_mensal_id;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAssinatura1() {
		return assinatura1;
	}

	public void setAssinatura1(String assinatura1) {
		this.assinatura1 = assinatura1;
	}

	public String getAssinatura2() {
		return assinatura2;
	}

	public void setAssinatura2(String assinatura2) {
		this.assinatura2 = assinatura2;
	}

	public LocalDate getDtFechamento() {
		return dtFechamento;
	}

	public void setDtFechamento(LocalDate dtFechamento) {
		this.dtFechamento = dtFechamento;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
