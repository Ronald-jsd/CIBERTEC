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
public class RegisterServlet extends HttpServlet {
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
		case "borrar" -> borrar(request, response);
		case "actualizar" -> actualizar(request, response);
		case "prepareUpdate" -> preActualizar(request, response);
		default -> System.out.println("Número desconocido");

		}

	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = DBConnection.getConnection()) {
			// Crear instancia del DAO
			UserDao usuarioDao = new UserDao(connection);

			// Tomar id del request
			String userName = request.getParameter("nombre");
			// Tomar id del request
			String mail = request.getParameter("correo");

			// Create an instance
			User user = new User(userName, mail);

			// Validar eliminación
			boolean actualizado = usuarioDao.actualizarUser(user);

			if (actualizado) {
				request.setAttribute("mensaje", "Usuario actualzado con éxito");
			} else {
				request.setAttribute("mensaje", "Error al actualizar el usuario");
			}
			request.getRequestDispatcher("reply.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void borrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (Connection connection = DBConnection.getConnection()) {
			// Crear instancia del DAO
			UserDao usuarioDao = new UserDao(connection);

			// Tomar id del request
			String userName = request.getParameter("name");

			// Validar eliminación
			boolean usuarioEliminado = usuarioDao.borrarUser(userName);

			if (usuarioEliminado)
				response.sendRedirect("ListarServlet");

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
		try (Connection connection = DBConnection.getConnection()) {
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

	private void preActualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (Connection connection = DBConnection.getConnection()) {
			// Crear instancia del DAO
			UserDao usuarioDao = new UserDao(connection);

			// Tomar id del request
			String userName = request.getParameter("name");
			// Tomar id del request
			String mail = request.getParameter("mail");

			// Create an instance
			User user = new User(userName, mail);

			// Prepare Attribute
			request.setAttribute("preUser", user);

			request.getRequestDispatcher("register.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
