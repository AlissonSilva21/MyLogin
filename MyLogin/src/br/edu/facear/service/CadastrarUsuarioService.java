package br.edu.facear.service;

import java.sql.SQLException;

import br.edu.facear.dao.ClienteDAO;
import br.edu.facear.model.Cliente;

public class CadastrarUsuarioService {
	
	public static boolean cadastrar(Cliente cliente) throws ClassNotFoundException, SQLException {
		
		
		ClienteDAO dao = new ClienteDAO();
		
		return dao.cadastrar(cliente);
		
		 
	}

}
