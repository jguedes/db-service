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
	
	@Column(name="assintura1")
	private String assinatura1;

	@Column(name="assintura2")
	private String assinatura2;
	
	@Column(name="dt_fechamento")
	private LocalDate dtFechamento;
	
	@OneToMany
	private List<Item> itens;
	
}
