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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "relatorio_mensal")
public class RelatorioMensal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ano")
	private int ano;

	@Column(name = "mes")
	private int mes;

	@Column(name = "dt_fechamento")
	private LocalDate dtFechamento;

	@JsonIgnore
	@OneToMany()
	@JoinColumn(name = "relatorio_mensal_id")
	private List<Folha> folhas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public LocalDate getDtFechamento() {
		return dtFechamento;
	}

	public void setDtFechamento(LocalDate dtFechamento) {
		this.dtFechamento = dtFechamento;
	}

	public List<Folha> getFolhas() {
		return folhas;
	}

	public void setFolhas(List<Folha> folhas) {
		this.folhas = folhas;
	}

}
