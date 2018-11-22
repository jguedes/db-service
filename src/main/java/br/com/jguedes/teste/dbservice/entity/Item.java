package br.com.jguedes.teste.dbservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="item")
public class Item {

	@Id
    @GeneratedValue
	private long id;
	
	@ManyToOne
	private Folha folha;

	@Column(name="seq")
	private int seq;

	@ManyToOne
	private Conta conta;

	@Column(name="desc")
	private String descr;

	@Column(name="valor")
	private Double valor;

	@Column(name="comp")
	private String comp;

	@Column(name="obser")
	private String obser;
	
	@Column(name="dt_cadastro")
	private LocalDate dtCadastro;

}
