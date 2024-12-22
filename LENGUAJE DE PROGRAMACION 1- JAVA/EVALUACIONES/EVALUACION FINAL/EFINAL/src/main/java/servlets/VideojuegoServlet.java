package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DesarrolladoraDAO;
import dao.VideojuegoDAO;
import models.Desarrolladora;
import models.Videojuego;

/**
 * Servlet implementation class VideojuegoServlet
 */
@WebServlet("/VideojuegoServlet")
public class VideojuegoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VideojuegoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("accion");

		switch (action != null ? action : "") {
		case "listarVideojuego":
			listarVideojuegos(request, response);
			break;
		default:
			response.sendRedirect("menu.jsp");
			break;
		}
	}

	protected void listarVideojuegos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener la lista de videojuegos y desarrolladoras desde los DAOs
		List<Videojuego> listVideojuego = VideojuegoDAO.listarVideojuegos();
		List<Desarrolladora> listaDesarrolladoras = DesarrolladoraDAO.listarDesarrolladoras();

		if (listaDesarrolladoras.isEmpty()) {
			request.setAttribute("mensajeError", "No hay desarrolladoras disponibles.");
		}

		request.setAttribute("listaDesarrolladoras", listaDesarrolladoras);
		request.setAttribute("listVideojuego", listVideojuego);

		request.getRequestDispatcher("videojuegos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	VideojuegoDAO videojuegoDAO = new VideojuegoDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("accion");

		switch (action != null ? action : "") {
		case "guardarRegistro":
			guardarRegistro(request, response);
			break;
		case "eliminar":
			eliminarVideojuego(request, response);
			break;

		case "actualizar":
			actualizarJuego(request, response);
		default:
			response.sendRedirect("error.jsp");
			break;
		}
	}

	private void guardarRegistro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nombre = request.getParameter("nombre");
		String version = request.getParameter("version");
		double costo = Double.parseDouble(request.getParameter("costo"));
		int idDesarrolladora = Integer.parseInt(request.getParameter("desarrolladora"));

		Desarrolladora newDesarrolladora = new Desarrolladora(idDesarrolladora);
		Videojuego newVideojuego = new Videojuego(codigo, nombre, version, costo, newDesarrolladora);

		videojuegoDAO.registrarVideojuego(newVideojuego);

		String mensajeRegistro = "Videojuego registrado exitosamente.";
		request.setAttribute("mensajeRegistro", mensajeRegistro);

		response.sendRedirect("VideojuegoServlet?accion=listarVideojuego");
	}

	protected void eliminarVideojuego(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		VideojuegoDAO.borrarVideojuego(id);
		response.sendRedirect("VideojuegoServlet?accion=listarVideojuego");
	}

	protected void actualizarJuego(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nombre = request.getParameter("nombre");
		String version = request.getParameter("version");
		double costo = Double.parseDouble(request.getParameter("costo"));
		int idDesarrolladora = Integer.parseInt(request.getParameter("desarrolladora"));

		Desarrolladora newDesarrolladora = new Desarrolladora(idDesarrolladora);
		Videojuego newVideojuego = new Videojuego(codigo, nombre, version, costo, newDesarrolladora);

		videojuegoDAO.actualizarVideojuego(newVideojuego);

		String mensajeActualizacion = "Actualizado exitosamente.";
		request.setAttribute("mensajeActualizacion", mensajeActualizacion);
		

		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

}
