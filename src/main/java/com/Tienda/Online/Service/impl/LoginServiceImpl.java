package com.Tienda.Online.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Tienda.Online.Modelo.Clientes;
import com.Tienda.Online.Repositorio.ClienteRepositorio;
import com.Tienda.Online.Service.LoginService;
import com.Tienda.Online.dto.ClienteDto;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	@Override
	public void registro(ClienteDto cliente) {
		Clientes clienteNuevo = new Clientes();
		if(cliente.getId()!= null) {
			clienteNuevo.setId(cliente.getId());
		}
		clienteNuevo.setNombre(cliente.getNombre());
		clienteNuevo.setApellido(cliente.getApellido());
		clienteNuevo.setEmail(cliente.getEmail());
		clienteNuevo.setPassword(cliente.getPassword());
		clienteRepositorio.save(clienteNuevo);
	}
	@Override
	public Clientes login(ClienteDto cliente) {
		Clientes clientebd = clienteRepositorio.findByEmail(cliente.getEmail(), cliente.getPassword());
		if (clientebd != null) {
            return clientebd;
        } else {
            return null;	
		}
	}

	
}
