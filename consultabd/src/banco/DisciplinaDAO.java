package banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

import java.sql.Connection;


public class DisciplinaDAO {
	
	public static void main(String[] args) throws SQLException
	{
		Scanner nro = new Scanner(System.in);
        int num = 0;
        while(num<=0||num>=3)
        {
        	System.out.println("##### - SISTEMA DISCIPLINAS - #####");
			System.out.println("Escolha uma das opções abaixo");
			System.out.println("1 - Exibir nome das disciplinas");
			System.out.println("2 - Sair");
			System.out.print("DIGITE A OPÇÃO: ");
            num = nro.nextInt();
        
        if(num==1)
        	listagem();     		
        else if(num==2)
            System.exit(0);
        else
        	System.out.println("Você digitou uma opção inválida");
        }
		
	}

	
	
	public static void listagem() throws SQLException {
		  Connection conexao = FabricaDeConexao.getConnection();
		  String sql = "select * from disciplina";
		  PreparedStatement stmt = conexao.prepareStatement(sql);
		  ResultSet resultado = stmt.executeQuery();
		  while (resultado.next()) {
			  System.out.println("Id: "+resultado.getString("id"));
			  System.out.println("Disciplina: "+resultado.getString("nome1"));
			  
		  }
		  resultado.close();
		  stmt.close();
		  conexao.close();
		}

}
