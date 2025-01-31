package com.Tienda.Online.Service;

import com.Tienda.Online.Modelo.Clientes;
import com.Tienda.Online.dto.ClienteDto;

public interface LoginService {

	public void registro(ClienteDto cliente);
	public Clientes login(ClienteDto cliente);
}
