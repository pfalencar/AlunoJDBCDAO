package controller;

import java.sql.Connection;

import dao.AlunosJdbcDAO;
import dao.JdbcUtil;
import model.Aluno;

public class AlunosExec {

	public static void main (String []args) {
		Aluno aluno = new Aluno();
		
		try {
			aluno.setNome("Dona Maria");
			aluno.setEndereco("Av. dos Autonomistas, 260");
			aluno.setBairro("Chácara Sto Antônio");
			
				
			//o método getConnection() do tipo JdbcUtil é estático. 
			//Portanto, para acessá-lo não é necessário instanciar a classe JdbcUtil, ele pode ser acessado de um maneira estática
			
			//JdbcUtil jdbcUtil = new JdbcUtil();
			//Connection connection = jdbcUtil.getConnection();
			
			//esta é a maneira estática de acessá-lo. 
			//usa direto o nome da classe para acessar o método estático getConnection()
			Connection connection = JdbcUtil.getConnection();
			
			
			AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
			
			alunosJdbcDao.salvar(aluno);
			
			//alunosJdbcDao.alterar(aluno);
			//alunosJdbcDao.alterarPorId(aluno,3);
			
			//alunosJdbcDao.excluir(2);
			alunosJdbcDao.listar();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
