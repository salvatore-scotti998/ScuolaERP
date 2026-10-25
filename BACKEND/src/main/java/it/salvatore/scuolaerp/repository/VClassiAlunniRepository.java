package it.salvatore.scuolaerp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.salvatore.scuolaerp.model.VClassiAlunni;


@Repository
public interface VClassiAlunniRepository extends JpaRepository<VClassiAlunni, Long> {

}
