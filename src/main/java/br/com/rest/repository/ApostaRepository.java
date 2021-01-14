package br.com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rest.model.Aposta;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, Integer>{

}
