package br.com.jguedes.teste.dbservice.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="relatorio_mensal")
public class RelatorioMensal {

	@Id
    @GeneratedValue
	private long id;

	@Column(name="ano")
	private int ano;

	@Column(name="mes")
	private int mes;

	@Column(name="dt_fechamento")
	private LocalDate dtFechamento;
	
	@OneToMany
	private List<Folha> folhasEntrada;

	@OneToMany
	private List<Folha> folhasSaida;

}
