package br.com.jguedes.teste.dbservice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.jguedes.teste.dbservice.response.relatorio.Valuable;

@Entity
@Table(name = "item")
public class Item implements Valuable, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "folha_id")
	private long folha_id;

	@Column(name = "seq")
	private int seq;

	@Column(name = "conta_id")
	private long conta_id;

	@Column(name = "discr")
	private String discr;

	@Column(name = "valor")
	private BigDecimal valor;

	@Column(name = "comp")
	private String comp;

	@Column(name = "obser")
	private String obser;

	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "dt_cadastro")
	private LocalDate dtCadastro = LocalDate.now();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFolha_id() {
		return folha_id;
	}

	public void setFolha_id(long folha_id) {
		this.folha_id = folha_id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public long getConta_id() {
		return conta_id;
	}

	public void setConta_id(long conta_id) {
		this.conta_id = conta_id;
	}

	public String getDiscr() {
		return discr;
	}

	public void setDiscr(String discr) {
		this.discr = discr;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
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
