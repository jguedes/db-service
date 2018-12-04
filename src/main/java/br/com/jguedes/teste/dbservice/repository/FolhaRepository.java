package br.com.jguedes.teste.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jguedes.teste.dbservice.entity.Folha;

public interface FolhaRepository extends JpaRepository<Folha, Long> {

	@Query(value = "SELECT f.* FROM folha AS f INNER JOIN relatorio_mensal AS rm ON f.relatorio_mensal_id = rm.id  WHERE rm.ano = ?1", nativeQuery = true)
	List<Folha> findByAno(Integer ano);

	@Query(value = "SELECT f.* FROM folha AS f INNER JOIN relatorio_mensal AS rm ON f.relatorio_mensal_id = rm.id  WHERE rm.ano = ?1 and rm.mes = ?2", nativeQuery = true)
	List<Folha> findByAnoAndMes(Integer ano, Integer mes);

	@Query(value = "SELECT f.* FROM folha AS f INNER JOIN relatorio_mensal AS rm ON f.relatorio_mensal_id = rm.id  WHERE rm.ano = ?1 and rm.mes = ?2 and f.tipo = ?3", nativeQuery = true)
	List<Folha> getFolhasByAnoAndMesAndTipo(Integer ano, Integer mes, char tipo);

	@Query(value = "SELECT f.* FROM folha AS f INNER JOIN relatorio_mensal AS rm ON f.relatorio_mensal_id = rm.id  WHERE rm.ano = ?1 and rm.mes = ?2 and f.tipo = ?3 and f.num = ?4", nativeQuery = true)
	Folha getFolhaByAnoAndMesAndTipoAndNum(Integer ano, Integer mes, char entrada, Integer num);

}
