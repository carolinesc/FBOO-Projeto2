package viagens.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import viagens.controller.Conexao;
import viagens.model.Passagens;

public class CrudDAO {

	//crud C- Create R- Read U- Update D- Delete
	
	//Create (inserir DADOS)
	public void create(Passagens passagem) {
		String sql = "INSERT INTO passagens (localIda, dataIda, dataVolta, valor) VALUES (?,?,?,?)";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = 	Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql); //cast
			p.setString(1, passagem.getLocalIda());
			p.setString(2, passagem.getDataIda());
			p.setString(3, passagem.getDataVolta());
			p.setInt(4, passagem.getValor());
			p.execute();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir dados! \nERRO: " + e);
			
		} finally {
			try {
				if(p != null);
				p.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}//fim CREATE
	
	//metodo U - update
	public void update(Passagens passagem) {
		String sql = "UPDATE alunos SET localIda = ?, dataIda = ?, dataVolta = ? WHERE valor = ?";
		Connection conn = null;
		PreparedStatement p = null; //link do barco
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql); //cast
			p.setString(1, passagem.getLocalIda());
			p.setString(2, passagem.getDataIda());
			p.setString(3, passagem.getDataVolta());
			p.setInt(4, passagem.getValor());
			p.execute();//executa inst para gravar dados no banco
			JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
			System.out.println("dados atualizados com sucesso!");
			
			
			
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir dados! \nERRO: " + e);
				
			}finally {
				try {
					if(p != null);
					p.close();
				}catch (Exception e ) {
					e.printStackTrace();
				}
			}
	}//fim update
	
	//R - read
	public List<Passagens> read(){
		String sql = "SELECT * FROM passagens";
		List<Passagens> passagem = new ArrayList<Passagens>();
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet resultado = null;
		
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);
			resultado = p.executeQuery(); //mostra os dados da cuonsulta aql
			while(resultado.next()) {
				Passagens ver_passagem = new Passagens();
				//recuperar data ida
				ver_passagem.setDataIda(resultado.getString("dataIda"));
				//recuperar o nome
				ver_passagem.setLocalIda(resultado.getString("LocalIda"));
				//recuperar data volta
				ver_passagem.setDataVolta(resultado.getString("dataVolta"));
				//recuperar valor
				ver_passagem.setValor(resultado.getInt("valor"));
				//adicionar na lista
				passagem.add(ver_passagem);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		
		}finally {
			try {
				if(p != null);
				p.close();
			}catch (Exception e ) {
				e.printStackTrace();
			}
		}
		return passagem;
	}//fim read
	
	//D - Delete
	public boolean delete(int valor) {
		String sql = "DELETE FROM passagens WHERE valor = ?";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);
			p.setInt(1, valor);
			p.execute();
			JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");
			System.out.println("dados excluidos com sucesso!");
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(p != null);
				p.close();
			}catch (Exception e ) {
				e.printStackTrace();
			}
		}
		return false;
		}//fim delete
	
	
	
	
	
}//fim classe
