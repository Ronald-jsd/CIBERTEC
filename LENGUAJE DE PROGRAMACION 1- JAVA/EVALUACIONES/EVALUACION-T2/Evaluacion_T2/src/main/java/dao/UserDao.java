package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

import com.mysql.cj.xdevapi.Result;

import db.DBConnection;
import models.ClubModel;
import models.LigaModel;

public class UserDao {

	
	/*OBTENER LISTA DE CLUBS */
	public static  List<ClubModel> listarClubesPorIDLiga(int id_liga) {
		List <ClubModel> listaClubs = new ArrayList<>();
		
		  String sqlQuery  = """
                  SELECT *
                  FROM clubes
                  WHERE id_liga = ?;
                 """;
		  
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery)){
			ps.setInt(1, id_liga);	
				
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()) {
				ClubModel club = new ClubModel();
		        club.setIdLiga(rs.getInt("id_liga"));
				club.setIdClub(rs.getInt("id_clubes"));
				club.setNombreClub(rs.getString("nombre_club"));
				club.setCampeonatosNacionales(rs.getInt("campeonatos_nacionales"));
				club.setCopasNacionales(rs.getInt("copas_nacionales"));
				club.setCampeonatosEuropeos(rs.getString("campeonatos_europeos"));
				
				listaClubs.add(club);
			}
			System.out.println("Conexion exitosa");		
		}catch (SQLException e) {
			System.err.println("No se obtuvo datos");
			e.printStackTrace();
		}
		
		return listaClubs;
	}//fin
	
	//OBTENER DETALLES POR CADA CLUB
	public static ClubModel obtenerDetallesPorClub(int idClub) {
		ClubModel club = new ClubModel();
		
		String sqlQuery = """
				select  *
				from clubes
				where id_clubes=?
				""";
		
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery)){
			
			ps.setInt(1, idClub);
		
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
					club.setIdLiga(rs.getInt("id_liga"));
					club.setIdClub(rs.getInt("id_clubes"));
					club.setNombreClub(rs.getString("nombre_club"));
					club.setCampeonatosNacionales(rs.getInt("campeonatos_nacionales"));
					club.setCopasNacionales(rs.getInt("copas_nacionales"));
					club.setCampeonatosEuropeos(rs.getString("campeonatos_europeos"));
			}
			
		}catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		return club;
	}//fin

	

	
	
	
	
	
	
}
