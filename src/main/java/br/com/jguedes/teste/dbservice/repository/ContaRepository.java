package br.com.jguedes.teste.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jguedes.teste.dbservice.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
