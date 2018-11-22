package br.com.jguedes.teste.dbservice.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="folha")
public class Folha {

	@Id
    @GeneratedValue
	private long id;
	
	@ManyToOne
	private RelatorioMensal relatorio;
	
	@Column
	private String assinatura1;

	@Column
	private String assinatura2;
	
	@Column
	private LocalDate dtFechamento;
	
	@OneToMany
	private List<Item> itens;
	
}
