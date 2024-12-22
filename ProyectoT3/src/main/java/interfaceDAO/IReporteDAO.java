package interfaceDAO;

import java.sql.SQLException;
import java.util.List;

import model.Reporte;

public interface IReporteDAO {

	public  List<Reporte> listarReporte() throws SQLException ;
	public void eliminarReporte(int id);
	public void crearReporte(Reporte reporte);


}
