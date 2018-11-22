package br.com.jguedes.teste.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jguedes.teste.dbservice.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
