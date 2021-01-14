package br.com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.model.Usuario;
import br.com.rest.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usRep;
	
	@GetMapping
	public List<Usuario> listar() {
		return usRep.findAll();
	}
	
	@PostMapping
	public Usuario alteraUsuario(@RequestBody Usuario user) {
		return usRep.save(user);
	}
	
}
