package br.com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rest.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{


}