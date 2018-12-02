package br.com.jguedes.teste.dbservice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.jguedes.teste.dbservice.constantes.TipoMovimentacao;
import br.com.jguedes.teste.dbservice.response.relatorio.Valuable;

@Entity
@Table(name = "relatorio_mensal")
public class RelatorioMensal implements Valuable, Serializable {

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

	@OneToMany()
	@JoinColumn(name = "relatorio_mensal_id")
	private List<Folha> folhas;
	
	@Transient
	private BigDecimal saldoMesAnterior;

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
	
	@Transient
	public List<Folha> getFolhasEntrada(){
		return folhas.stream().filter(f -> f.getTipo() == TipoMovimentacao.ENTRADA).collect(Collectors.toList());
	}
	
	@Transient
	public List<Folha> getFolhasSaida(){
		return folhas.stream().filter(f -> f.getTipo() == TipoMovimentacao.SAIDA).collect(Collectors.toList());
	}
	
	@Transient
	public BigDecimal getEntradaMes() {
		return getFolhasEntrada().stream().map(Valuable::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	@Transient
	public BigDecimal getSaidaMes() {
		return getFolhasSaida().stream().map(Valuable::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	@Transient
	public BigDecimal getSaldoMes() {
		return getEntradaMes().subtract(getSaidaMes());
	}

	@Transient
	public BigDecimal getSaldoMesAnterior() {
		return saldoMesAnterior;
	}

	@Transient
	public void setSaldoMesAnterior(BigDecimal saldoMesAnterior) {
		this.saldoMesAnterior = saldoMesAnterior;
	}
	
	@Transient
	public BigDecimal getSaldoEmCaixa() {
		return getSaldoMes().add(getSaldoMesAnterior());
	}

	@Transient
	@Override
	public BigDecimal getValor() {
		return getSaldoMes();
	}

}
