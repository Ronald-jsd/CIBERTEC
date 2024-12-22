package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import dao.UserDao;
import utils.DBConnection;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet implements list {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = request.getParameter("accion");

		switch (value) {
		case "registrar" -> register(request, response);
		case "listar" -> list(request, response);
		case "listarSP" -> listSP(request, response);
		default -> System.out.println("Número desconocido");

		}

	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (Connection connection = DBConnection.getConnection()) {
			// Crear instancia del DAO
			UserDao usuarioDao = new UserDao(connection);

			// Obtener la lista de usuarios
			List<User> listaUsuarios = usuarioDao.listarUser();

			// Guardar la lista en el objeto request
			request.setAttribute("usuarios", listaUsuarios);

			// Redirigir a la JSP
			request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Obtener parámetros del formulario
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");

		// Crear objeto Usuario
		User usuario = new User(nombre, correo);

		// Crear conexión y DAO
		try (Connection connection = DBConnection.getConnection()) { // Implementa la conexión en ConexionBD
			UserDao usuarioDAO = new UserDao(connection);

			boolean registrado = usuarioDAO.registerUser(usuario);

			if (registrado) {
				request.setAttribute("mensaje", "Usuario registrado con éxito");
			} else {
				request.setAttribute("mensaje", "Error al registrar el usuario");
			}
			request.getRequestDispatcher("reply.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en el servidor");
		}
	}

	private void listSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (Connection connection = DBConnection.getConnection()) {
			// Crear instancia del DAO
			UserDao usuarioDao = new UserDao(connection);

			// Obtener la lista de usuarios
			List<User> listaUsuarios = usuarioDao.listarUserSP();

			// Guardar la lista en el objeto request
			request.setAttribute("usuarios", listaUsuarios);

			// Redirigir a la JSP
			request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
