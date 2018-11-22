package br.com.jguedes.teste.dbservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
    @GeneratedValue
	private long id;
	
	@ManyToOne
	private Folha folha;

	@Column
	private int seq;

	@ManyToOne
	private Conta conta;

	@Column
	private String descr;

	@Column
	private Double valor;

	@Column
	private String comp;

	@Column
	private String obser;
	
	@Column
	private LocalDate dtCadastro;

}
