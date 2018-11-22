package br.com.jguedes.teste.dbservice.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="conta")
public class Conta {

	@Id
    @GeneratedValue
	private long id;

	@Column(name="tipo")
	private char tipo;

	@Column(name="titulo")
	private String titulo;

	@OneToMany
	private List<Item> itens;

}
