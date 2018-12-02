package br.com.jguedes.teste.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jguedes.teste.dbservice.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query(value = "SELECT i.* " + 
			"FROM item AS i " + 
			"INNER JOIN folha AS f ON i.folha_id = f.id " + 
			"WHERE " + 
			"i.conta_id = ?2 AND f.relatorio_mensal_id = ?1", nativeQuery = true)
	public List<Item> getItensByRelatorioIdAndContaId(long relatorioId, long contaId);
	
}
