package com.Tienda.Online.Service;

import com.Tienda.Online.Modelo.Clientes;
import com.Tienda.Online.dto.ClienteDto;

//Se crea la interfaz LoginService con los metodos registro y login
public interface LoginService {

	public void registro(ClienteDto cliente);
	public Clientes login(ClienteDto cliente);
}
