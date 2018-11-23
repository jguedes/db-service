package br.com.jguedes.teste.dbservice.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(cascade=CascadeType.ALL)   
	@JoinColumn(name="folha_id", referencedColumnName="id",nullable=false)
	private Folha folha;

	@Column(name = "seq")
	private int seq;

	@ManyToOne(cascade=CascadeType.ALL)   
	@JoinColumn(name="conta_id", referencedColumnName="id",nullable=false)
	private Conta conta;

	@Column(name = "desc")
	private String descr;

	@Column(name = "valor")
	private Double valor;

	@Column(name = "comp")
	private String comp;

	@Column(name = "obser")
	private String obser;

	@Column(name = "dt_cadastro")
	private LocalDate dtCadastro;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Folha getFolha() {
		return folha;
	}

	public void setFolha(Folha folha) {
		this.folha = folha;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public String getObser() {
		return obser;
	}

	public void setObser(String obser) {
		this.obser = obser;
	}

	public LocalDate getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(LocalDate dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

}
