package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.Desarrolladora;
import utils.MySqlConnection;

public class DesarrolladoraDAO {

	public static List<Desarrolladora> listarDesarrolladoras() {
		List<Desarrolladora> listaDesarrolladoras = new ArrayList<>();

		String sqlQuery = "CALL listar_Solo_Desarrolladoras()";
		try (Connection conexion = MySqlConnection.getConnection();
				CallableStatement cs = conexion.prepareCall(sqlQuery);) {

			ResultSet rs = cs.executeQuery();

			while (rs.next()) {
				Desarrolladora nuevaDesarrolladora = new Desarrolladora(rs.getInt("id_desarrolladora"),
						rs.getString("NOMBRE"));
				listaDesarrolladoras.add(nuevaDesarrolladora);
			}

		} catch (Exception e) {
			System.out.println("ERROR AL LISTAR DESARROLLADORAS " + e.getMessage());
			e.printStackTrace();
		}

		return listaDesarrolladoras;

	}

}// FIN CLASS
