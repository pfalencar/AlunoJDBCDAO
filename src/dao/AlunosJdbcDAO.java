package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunosJdbcDAO {

	private Connection conn;
	
	public AlunosJdbcDAO (Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Aluno c) throws SQLException {
		String sql = "insert into aluno (nome, endereco, bairro) values ('" +
				c.getNome() + "','" + c.getEndereco() + "','" + 
				c.getBairro() + "');";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar(Aluno c) {
		//String sql = "update aluno set nome = '" + c.getNome() + "',endereco='" + c.getEndereco() + "', bairro = '" + c.getBairro()+"' where id = 2;";
		String sql = "update aluno set bairro = '" + c.getBairro()+"' where id = 2;" ;
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterarPorId(Aluno c, int id) {
		String sql = "update aluno set nome = '" + c.getNome() + "', bairro = '" + c.getBairro()+"' where id = " + id + ";" ;
		//String sql = "update aluno set bairro = '" + c.getBairro()+"' where id = " + id + ";" ;
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir (int id) {
		String sql = "delete from aluno where id=" + id + ";";
		System.out.println(sql);
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Aluno> listar(){
		String sql = "select * from aluno";
		System.out.println(sql);
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String bairro = rs.getString("bairro");
				Aluno a = new Aluno();
				a.setId(id);
				a.setNome(nome);
				a.setEndereco(endereco);
				a.setBairro(bairro);
				alunos.add(a);
			}
			prepareStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Aluno a: alunos) {
			System.out.println("\n" + a.getId() + " - " + a.getNome() + ", " + a.getEndereco() + ", " + a.getBairro());
		}
		return alunos;
	}
	
	
}









