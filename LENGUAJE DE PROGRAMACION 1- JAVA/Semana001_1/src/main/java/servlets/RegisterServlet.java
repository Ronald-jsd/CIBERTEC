package servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		///response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
}