package br.com.jguedes.teste.dbservice.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jguedes.teste.dbservice.entity.RelatorioMensal;

public interface RelatorioMensalRepository  extends JpaRepository<RelatorioMensal,Long>{

	@Query(value = "SELECT " + 
			"IFNULL((SELECT sum(i.valor) " + 
			"FROM item AS i " + 
			"INNER JOIN folha AS f ON i.folha_id = f.id  " + 
			"INNER JOIN relatorio_mensal AS r ON f.relatorio_mensal_id = r.id  " + 
			"WHERE " + 
			"((r.ano * 100) + r.mes) <= ((?1 * 100) + ?2) and f.tipo = 'e'), 0) " + 
			"- " + 
			"IFNULL((SELECT sum(i.valor) " + 
			"FROM item AS i " + 
			"INNER JOIN folha AS f ON i.folha_id = f.id  " + 
			"INNER JOIN relatorio_mensal AS r ON f.relatorio_mensal_id = r.id  " + 
			"WHERE " + 
			"((r.ano * 100) + r.mes) <= ((?1 * 100) + ?2) and f.tipo = 's'), 0) " + 
			"FROM DUAL", nativeQuery = true)
	public BigDecimal getSaldoRelatorioMensal(Integer ano, Integer mes);

	public Optional<RelatorioMensal> findByAnoAndMes(Integer ano, Integer mes);

	public List<RelatorioMensal> findByAno(int ano);

}
