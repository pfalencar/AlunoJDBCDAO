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
			aluno.setBairro("Ch�cara Sto Ant�nio");
			
				
			//o m�todo getConnection() do tipo JdbcUtil � est�tico. 
			//Portanto, para acess�-lo n�o � necess�rio instanciar a classe JdbcUtil, ele pode ser acessado de um maneira est�tica
			
			//JdbcUtil jdbcUtil = new JdbcUtil();
			//Connection connection = jdbcUtil.getConnection();
			
			//esta � a maneira est�tica de acess�-lo. 
			//usa direto o nome da classe para acessar o m�todo est�tico getConnection()
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
