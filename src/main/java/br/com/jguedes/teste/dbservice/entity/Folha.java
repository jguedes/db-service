package br.com.jguedes.teste.dbservice.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "folha")
public class Folha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private RelatorioMensal relatorio;

	@Column(name = "assintura1")
	private String assinatura1;

	@Column(name = "assintura2")
	private String assinatura2;

	@Column(name = "dt_fechamento")
	private LocalDate dtFechamento;

	@OneToMany
	private List<Item> itens;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RelatorioMensal getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(RelatorioMensal relatorio) {
		this.relatorio = relatorio;
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
