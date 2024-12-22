package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaceDAO.ILineaDAO;
import model.Linea;
import utils.DBConection;

public class LineaDAO implements ILineaDAO {
	/*-----------------------------COMBOBOX-----------------------------*/
	/*------------------OBTENER LISTA DE LINEA -----------------------------*/	
	
	public  List<Linea> listarLinea() {
		String sqlQuery = "CALL cliente_linea()";
		List<Linea> listaLinea = new ArrayList<>();

		try (Connection conexion = DBConection.getConnection(); 
				CallableStatement cs = conexion.prepareCall(sqlQuery)) {

			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				Linea newLinea = new Linea();
				newLinea.setCodLinea(rs.getString("CodLinea"));
				newLinea.setLineaNombre(rs.getString("LineaNombre"));
				newLinea.setMaquina(rs.getString("Maquina"));
				newLinea.setCapacidadNominal(rs.getDouble("CapacidadNominal"));

				listaLinea.add(newLinea);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaLinea;
	}
}
