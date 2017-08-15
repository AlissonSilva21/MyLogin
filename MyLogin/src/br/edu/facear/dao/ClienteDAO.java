package br.edu.facear.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.edu.facear.model.Cliente;

public class ClienteDAO extends GenericDAO{
	private PreparedStatement ps;
	private String LOGIN_SQL = "SELECT * FROM TBCLIENTE WHERE EMAIL = ? AND SENHA = ?";
	private String INSERT = "INSERT INTO tbcliente (nome, cpf, email, senha) VALUES (?, ?, ?, ?);";
	private String UPDATE = "UPDATE tbcliente SET nome = ?,cpf = ?,email=?, senha = ? WHERE id = ?";
	private String SELECT = "SELECT * FROM tbcliente WHERE id = ?";
	private String DELETE = "DELETE FROM tbcliente WHERE id = ?";
	
	public Cliente autenticar(String usuario,String senha) throws ClassNotFoundException, SQLException {
		Cliente cliente = null;
		openConnection();
		
		
		ps = connect.prepareStatement(LOGIN_SQL);
		ps.setString(1, usuario);
		ps.setString(2, senha);
		ResultSet rs = ps.executeQuery();
		
		if(rs.first()) {
		cliente = new Cliente(Integer.parseInt(rs.getString("id")),rs.getString("nome"), rs.getString("cpf"), usuario, senha);
		}
		closeConnection();
		return cliente;
	}
	
	

	public boolean cadastrar(Cliente cliente) {
		boolean exito = false;
		
		try {
			openConnection();
		
		
		
		ps = connect.prepareStatement(INSERT);
		ps.setString(1, cliente.getNome());
		ps.setString(2, cliente.getCpf());
		ps.setString(3, cliente.getUsuario());
		ps.setString(4, cliente.getSenha());
		
		if(ps.executeUpdate()>0) {
			exito = true;
		}
			
		
		
		closeConnection();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return exito;
	}
	
			
			

}
