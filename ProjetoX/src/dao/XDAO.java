package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.X;

public class XDAO extends DAO {
	
	public XDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	public boolean insert(X x) {
	    boolean status = false;
	    try {
	        Statement st = conexao.createStatement();
	        String sql = "INSERT INTO x (numero, id) "
	                   + "VALUES (" + x.getNumero() + ", " + x.getId() + ");";
	        System.out.println(sql);
	        st.executeUpdate(sql);
	        st.close();
	        status = true;
	    } catch (SQLException u) {
	        throw new RuntimeException(u);
	    }
	    return status;
	}

	
	public X get(int id) {
		X x1 = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM x WHERE id=" + id;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 x1 = new X(rs.getInt("numero"), rs.getInt("id"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return x1;
	}
	
	
	public List<X> get() {
		
		List<X> xLista = new ArrayList<X>();
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM numero";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				X x = new X(rs.getInt("numero"), rs.getInt("id"));
				xLista.add(x);
			}
			st.close();
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		return xLista;
	}

	
	
	public boolean update(X x) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE x SET numero = '" + x.getNumero()  + "'"
					   + " WHERE id = " + x.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM x WHERE id = " + id;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
		
}
