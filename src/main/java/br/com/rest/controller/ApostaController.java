package br.com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.model.Aposta;
import br.com.rest.model.Usuario;
import br.com.rest.repository.UsuarioRepository;

@RestController
public class ApostaController {

	@Autowired
	private UsuarioRepository usRep;

	@PostMapping("/apostas")
	public Usuario novaAposta(@RequestBody String email) {

		Usuario user = usRep.findById(email).orElse(null);

		if (user != null) {
			Aposta aposta = new Aposta();
			aposta.geraAposta();
			aposta.setUsuario(user);
			user.getApostas().add(aposta);

			return usRep.save(user);
		} else {
			return null;
		}

	}

	@GetMapping("/apostas/")
	public Usuario listarAposta(@RequestBody String email) {

		Usuario user = usRep.findById(email).orElse(null);

			if (user.getApostas().size() > 0) {
				return user;
			} else {
				return null;
			}
		

	}

}
