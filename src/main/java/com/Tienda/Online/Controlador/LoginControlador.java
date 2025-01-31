package com.Tienda.Online.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tienda.Online.Modelo.Clientes;
import com.Tienda.Online.Service.LoginService;
import com.Tienda.Online.dto.ClienteDto;
// Controlador donde se registran los clientes y se loguean
@RestController 
@RequestMapping("/api/v1/login")
public class LoginControlador {
	
	@Autowired
	private LoginService loginService;
	// Metodo para registrar un cliente
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/registro")
	public void registro(@RequestBody  ClienteDto cliente) {
		this.loginService.registro(cliente);
	}
	// Metodo para loguear un cliente
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public Clientes login(@RequestBody  ClienteDto cliente) {
        return this.loginService.login(cliente);
    }
}
