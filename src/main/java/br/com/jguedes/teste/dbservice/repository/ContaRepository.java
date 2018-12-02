package br.com.jguedes.teste.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jguedes.teste.dbservice.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	@Query(value = "SELECT DISTINCT c.* " + 
			"FROM conta AS c " + 
			"INNER JOIN item AS i ON c.id = i.conta_id " + 
			"INNER JOIN folha AS f ON i.folha_id = f.id " + 
			"WHERE c.tipo = ?2 AND f.relatorio_mensal_id = ?1",nativeQuery = true)
	public List<Conta> getContasByRelatorioMensalId(Long retorioId,char tipo);

}
