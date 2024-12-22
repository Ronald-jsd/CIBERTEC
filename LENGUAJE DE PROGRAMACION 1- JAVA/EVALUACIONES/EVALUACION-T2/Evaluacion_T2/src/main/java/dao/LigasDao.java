package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import models.LigaModel;

public class LigasDao {
	/*LISTAR LAS LIGAS */
    public static List<LigaModel> listarLigas() {
        List<LigaModel> ligas = new ArrayList<>();
        String sqlQuery = """
        		select * from ligas;  
        		""";
        
        try(Connection con = DBConnection.getConnection();
        		PreparedStatement ps = con.prepareStatement(sqlQuery)){
        		ResultSet rs = ps.executeQuery();
        		
        		while(rs.next()) {
        	        LigaModel liga = new LigaModel();

        			liga.setId_liga(rs.getInt("id_liga"));
        			liga.setNombre_liga(rs.getString("nombre"));
        			
        			ligas.add(liga);
        		}	        	
        }catch(SQLException e) {
        	System.err.println("Error al obtener la lista");
        	e.printStackTrace();
        	e.getMessage();
        }
    
        return ligas;
    }//fin 
}
