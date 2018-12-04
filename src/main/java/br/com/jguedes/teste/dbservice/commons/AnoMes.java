package br.com.jguedes.teste.dbservice.commons;

public class AnoMes {

	private Integer ano;
	private Integer mes;

	public AnoMes(Integer ano, Integer mes) {
		this.ano = ano;
		this.mes = mes;
	}

	public AnoMes getAnoMesAnterior() {
		if (mes == 1) {
			return new AnoMes(ano - 1, 12);
		}
		return new AnoMes(ano, mes - 1);
	}

	public Integer getAno() {
		return ano;
	}

	public Integer getMes() {
		return mes;
	}

}