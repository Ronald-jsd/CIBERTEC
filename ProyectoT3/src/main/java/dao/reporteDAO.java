package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaceDAO.IReporteDAO;
import model.Reporte;
import utils.DBConection;

public class reporteDAO implements IReporteDAO {

	/*--------------------------LISTAR  REPORTE -----------------------------*/

	public List<Reporte> listarReporte() throws SQLException {
		List<Reporte> lReporte = new ArrayList<>();
		// preparar consulta
		String sqlQuery = "call cliente_reporte()";

		// abrir conexion y preparar consulta
		try (Connection conexion = DBConection.getConnection(); 
				CallableStatement cs = conexion.prepareCall(sqlQuery)) {
			// ejecuto la connsulta
			ResultSet rs = cs.executeQuery();

			// apoblar
			while (rs.next()) {
				// objeto para almacenar //e ir creando varios objetos
				Reporte reporte = new Reporte();

				reporte.setIdReporte(rs.getInt("ID"));
				reporte.setFecha(rs.getDate("Fecha"));
				reporte.setCodigoLinea(rs.getString("CodLinea"));
				reporte.setMaquina(rs.getString("Maquina"));
				reporte.setProduccion(rs.getDouble("Produccion"));
				reporte.setReproceso(rs.getDouble("Reproceso"));
				reporte.setTurno(rs.getString("Turno"));
				reporte.setOperador(rs.getString("Operador"));

				lReporte.add(reporte); // agregando a la lista los objetos
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR EN DAO AL LISTAR" + e.getMessage());
		}

		return lReporte;
	}

	/*--------------------------ELIMINAR  REPORTE -----------------------------*/

	public void eliminarReporte(int id) {
		String sqlQuery = "CALL Eliminar_Reporte_Parada(?)";

		try (Connection conexion = DBConection.getConnection();
				PreparedStatement ps = conexion.prepareStatement(sqlQuery)) {
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR EN DAO AL REALIZAR LA ACTUALIZACION" + e.getMessage());
			
		}

	}

	/*--------------------------CREAR NUEVO REPORTE -----------------------------*/

	public void crearReporte(Reporte reporte) {
		// call Agregar_Reporte('2024-12-19', 'L002', 950045, 550 ,'Turno A' , 'Operador 2');*/
		String sqlQuery = "CALL Agregar_Reporte( ?, ?, ?, ?, ?, ?)";
		try (Connection conexion = DBConection.getConnection(); CallableStatement cs = conexion.prepareCall(sqlQuery)) {

			cs.setDate(1, new Date(reporte.getFecha().getTime()));

			cs.setString(2, reporte.getCodigoLinea());
			cs.setDouble(3, reporte.getProduccion());
			cs.setDouble(4, reporte.getReproceso());
			cs.setString(5, reporte.getTurno());
			cs.setString(6, reporte.getOperador());

			cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR AL INSERTAR REGISTRO EN DAO" + e.getMessage());
		}
	}
}
