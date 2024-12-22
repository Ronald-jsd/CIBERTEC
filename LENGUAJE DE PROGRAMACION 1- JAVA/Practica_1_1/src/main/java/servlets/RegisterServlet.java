package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import db_utils.DBConnection;
import model.User;

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
    	response.getWriter().append("Served at:").append(request.getContextPath());
    }
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String value = request.getParameter("accion");
		
		switch(value) {
		case "registrar" -> register(request,response); 
		case "listar" -> listSP(request,response);
		case "borrar" -> delete(request,response);

        default -> response.sendError(HttpServletResponse.SC_NOT_FOUND);

		
		
		}
	}

	private void listSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(Connection connection= DBConnection.getConnection()){
			UserDao usuarioDao = new UserDao(connection);
			List<User> listaEquipos = usuarioDao.listarClub();
			
			request.setAttribute("listaEquipos", listaEquipos);
			request.getRequestDispatcher("listarPage.jsp").forward(request, response);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
	//REGISTRAR
	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//obtener datos del formularios
		String nombre = request.getParameter("nameClub");
		String liga = request.getParameter("liga");
		int puntos = Integer.parseInt(request.getParameter("puntos"));
		int victorias =Integer.parseInt( request.getParameter("victorias" ));
		int derrotas = Integer.parseInt( request.getParameter("derrotas") );

		User usuario = new User(nombre, liga, puntos, victorias, derrotas);
		try(Connection conexion = DBConnection.getConnection()){
			UserDao usuarioDAO = new UserDao(conexion);
			boolean registrado = usuarioDAO.registerUser(usuario);
			//establece mensaje segun resultado del registro
			if(registrado) {
				request.setAttribute("mensaje", "Usuario Registrado con exito");
			}else {
				request.setAttribute("mensaje", "Error al registrar usuario");
			}
			request.getRequestDispatcher("pageAviso.jsp").forward(request, response);
		} catch(Exception e){
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en el servidor");
		}
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//obtener datos del formularios

		try(Connection conexion = DBConnection.getConnection()){
			UserDao usuarioDAO = new UserDao(conexion);
			String nombre = request.getParameter("nameClub");

			boolean userEliminado = usuarioDAO.deleteUser(nombre);
			//establece mensaje segun resultado del registro
			
			if(userEliminado) {
				listSP(request, response);
				request.getRequestDispatcher("pageAviso2.jsp").forward(request, response);

			}
			
		} catch(Exception e){
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en el servidor");
		}
	}
}
