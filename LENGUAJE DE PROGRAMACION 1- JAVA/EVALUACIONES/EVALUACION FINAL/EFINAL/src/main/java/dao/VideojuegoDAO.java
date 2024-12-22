package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.MysqlConnection;

import models.Desarrolladora;
import models.Videojuego;
import utils.MySqlConnection;

public class VideojuegoDAO {

	public static List<Videojuego> listarVideojuegos() {
		String sqlQuery = "call  listar_Tabla_Videojuegos_Desarrolladora()";
		List<Videojuego> listaVidejuegos = new ArrayList<Videojuego>();

		try (Connection conexion = MySqlConnection.getConnection();
				CallableStatement cs = conexion.prepareCall(sqlQuery)) {

			ResultSet rs = cs.executeQuery();

			while (rs.next()) {
				Videojuego nuevoVideojuego = new Videojuego(rs.getInt("id_videojuego"),
						rs.getString("videojuego_nombre"), rs.getString("version"), rs.getDouble("costo"),

						new Desarrolladora(rs.getString("desarrolladora_nombre")));

				listaVidejuegos.add(nuevoVideojuego);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return listaVidejuegos;
	}

	public void registrarVideojuego(Videojuego videojuego) {
		// call crear_Nuevo_Videojuego(1001, 'Roblox', '2.0',60, 5);

		String sqlQuery = "call crear_Nuevo_Videojuego(?, ?, ?, ?, ?)";
		try (Connection conexion = MySqlConnection.getConnection();
				CallableStatement cs = conexion.prepareCall(sqlQuery)) {

			cs.setInt(1, videojuego.getCodigo());

			cs.setString(2, videojuego.getNombre());
			cs.setString(3, videojuego.getVersion());
			cs.setDouble(4, videojuego.getCosto());
			cs.setInt(5, videojuego.getDesarrolladora().getIdDesarrolladora());

			cs.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("NO SE PUDO INSERTAR EN BD");
			e.printStackTrace();
		}

	}

	public static void borrarVideojuego(int codigo) {
		String sqlQuery = "call eliminar_videojuego(?)";

		try (Connection conexion = MySqlConnection.getConnection();
				CallableStatement cs = conexion.prepareCall(sqlQuery)) {

			cs.setInt(1, codigo);

			cs.executeUpdate();

		} catch (SQLException e) {
			System.out.println("ERROR AL ELIMINAR");
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public void actualizarVideojuego(Videojuego videojuego) {
		String sqlQuery = "CALL actualizar_Videojuego(?, ?, ?, ?, ?)";

		try (Connection conexion = MySqlConnection.getConnection();
				CallableStatement cs = conexion.prepareCall(sqlQuery)) {

			cs.setInt(1, videojuego.getCodigo());
			cs.setString(2, videojuego.getNombre());
			cs.setString(3, videojuego.getVersion());
			cs.setDouble(4, videojuego.getCosto());
			cs.setInt(5, videojuego.getDesarrolladora().getIdDesarrolladora());

			cs.executeUpdate();

		} catch (SQLException e) {
			System.out.println("NO SE PUDO ACTUALIZAR EN BD");
			e.printStackTrace();
		}
	}

}
