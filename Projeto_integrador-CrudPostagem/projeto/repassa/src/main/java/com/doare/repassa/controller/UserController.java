package com.doare.repassa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doare.repassa.model.User;
import com.doare.repassa.model.UserLogin;
import com.doare.repassa.repository.UserRepository;
import com.doare.repassa.service.UserService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> email) {
		return userService.Logar(email).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<User> Post(@RequestBody User email) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.CadastrarUsuario(email));
	}
	
	@Autowired
    private UserRepository repository;

	@GetMapping("/{id}")
    public ResponseEntity<User> GetById(@PathVariable long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

	@PutMapping("/cadastrar")
	public ResponseEntity<User> put(@RequestBody User email) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.atualizarUsuario(email));
	}

}
