package servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Register;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    Register usuario;

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
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nombre = request.getParameter("name");
	     String correo = request.getParameter("email");
		usuario=  new Register(nombre, correo);
		
		request.setAttribute("nombre",nombre);
		request.setAttribute("correo", correo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("register2.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
;
		String contrasena = request.getParameter("contrasena");
		usuario = new Register(contrasena);

	    
		
		request.setAttribute("nombre",usuario.getNombre());
		request.setAttribute("correo", usuario.getCorreo());
	   
		RequestDispatcher dispatcher = request.getRequestDispatcher("confirmacion.jsp");
		dispatcher.forward(request, response);
		
		
		
		
		
		
		
	}

}
