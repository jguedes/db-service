package br.com.jguedes.teste.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jguedes.teste.dbservice.entity.Folha;

public interface FolhaRepository extends JpaRepository<Folha, Long> {

}
