package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import model.Admin;
import utils.DBConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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

		try (Connection conn = DBConnection.getConnection()) {
			// Obtener parámetros del formulario
			String correo = request.getParameter("correo");
			String password = request.getParameter("password");

			// Lógica de login
			AdminDao adminDAO = new AdminDao(conn);
			Admin admin = adminDAO.login(correo, password);

			if (admin != null) {
				// Usuario autenticado: crear sesión
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);

				// Redirigir al dashboard
				response.sendRedirect("register.jsp");
			} else {
				// Usuario no autenticado: volver al login con mensaje de error
				request.setAttribute("errorMessage", "Credenciales incorrectas");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
