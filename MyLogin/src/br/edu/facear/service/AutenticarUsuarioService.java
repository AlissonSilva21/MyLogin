package br.edu.facear.service;

import java.sql.SQLException;

import br.edu.facear.dao.ClienteDAO;
import br.edu.facear.model.Cliente;

public class AutenticarUsuarioService {
	
	public static Cliente autenticar(String usuario,String senha) throws ClassNotFoundException, SQLException {
		ClienteDAO dao = new ClienteDAO();
		
		return dao.autenticar(usuario, senha);
		
		 
	}

}
