package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LineaDAO;
import dao.reporteDAO;
import model.Linea;
import model.Reporte;

/**
 * Servlet implementation class Reporte
 */
@WebServlet("/ReporteServlet")
public class ReporteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReporteServlet() {
		super();
	}
	LineaDAO lineaDAO = new LineaDAO();
	reporteDAO reporteDAO = new reporteDAO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("accion");

		try {
			switch (action) {
			case "listarReporte":
				listarReporte(request, response);
				break;
			case "eliminarReporte":
				eliminarReporte(request, response);
				break;
			case "listarLinea":
				listarLinea(request, response);
				break;
			default:
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no reconocida");
				break;
			}
		} catch (ServletException | IOException | SQLException e) {
			System.out.println("ERROR EN LA OPERACION doGET");
		}
	}

	protected void listarReporte(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		List<Reporte> listReporte = reporteDAO.listarReporte();
		//System.out.println("Lista repo: " + listReporte);
		request.setAttribute("listReporte", listReporte);
		request.getRequestDispatcher("indexReporte.jsp").forward(request, response);

	}

	protected void eliminarReporte(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("idReporte"));
		reporteDAO.eliminarReporte(id);
		response.sendRedirect("ReporteServlet?accion=listarReporte");
	}

	protected void listarLinea(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		try {
			List<Linea> listLinea = lineaDAO.listarLinea();
			request.setAttribute("listLinea", listLinea);
			request.getRequestDispatcher("createReporte.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("No se obvtuvo la lista");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    // Obtener la acción
	    String accion = request.getParameter("accion");

	    try {
	        if ("crearReporte".equalsIgnoreCase(accion)) {
	            crearReporte(request, response);
	        } else {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no reconocida.");
	        }
	    } catch (Exception e) {
	        System.out.println("ERROR EN LA ACCIÓN ESCOGIDA: " + e.getMessage());
	    }
	}


	private void crearReporte(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {

		String fechaValor = (request.getParameter("date"));//"18-12-2024"
		// definiendo formato
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		// almmacenar la fecha parseada
		Date fecha = formatoFecha.parse(fechaValor);//"2024-12-18"

		/* ALMACENO VALORES ENTRANTES */
		String turno = request.getParameter("turno");
		String codLinea = request.getParameter("codigoLinea");
		double produccion = Double.parseDouble(request.getParameter("produccion"));
		double reproceso = Double.parseDouble(request.getParameter("reproceso"));
		String operador = request.getParameter("operador");

		/* LOS ALMACENO EN UN OBJETO NUEVO ESOS ATRIBUTOS */
		Reporte newReporte = new Reporte();
		newReporte.setFecha(fecha);
		newReporte.setTurno(turno);
		newReporte.setCodigoLinea(codLinea);
		newReporte.setProduccion(produccion);
		newReporte.setReproceso(reproceso);
		newReporte.setOperador(operador);

		/* USO EL METODO PARA CREAR REPORTE DAO EN LA BASE DE DATOS, 
		  LE ENVIO EL NUEVO USUARIO */
		reporteDAO.crearReporte(newReporte);
		request.setAttribute("mensaje", "Registro exitoso");
		request.getRequestDispatcher("createReporte.jsp").forward(request, response);
	}
}
