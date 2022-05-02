package it.fabrick.testFabrick.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.fabrick.testFabrick.model.DBTransaction;

public interface TransactionRepository extends JpaRepository<DBTransaction, Long>{

}
