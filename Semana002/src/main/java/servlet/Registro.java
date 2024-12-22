package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Estudiante;

/**
 * Servlet implementation class Registro
 */
//@WebServlet("/Registro") Hace referencia a: 
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String msg1;
	String msg2;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registro() {
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
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		// RECIBIENDO DATOS DEL FORMULARIO DE LA PAGINA JSP y guardando en variables
		// request.getParameter("name");
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));

		Estudiante estudiante = new Estudiante(name, lastName, email, age);
		// invocando al metodo
		ValidateAge(estudiante.getName(), estudiante.getAge());

		// Preparacion de los datos
		// Enviando
		request.setAttribute("msg1", msg1);
		request.setAttribute("msg2", msg2);

		// Enviamos respuesta
		RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		dispatcher.forward(request, response);
	}

	// Utilizando los datos
	public void ValidateAge(String name, int age) {

		if (age >= 18) {
			msg1 = "Success access";
			msg2 = "Hello " + name + ". You can ACCES to our courses";
		} else {
			msg1 = "Acces Denied";
			msg2 = "Hello " + name + ". You can NOT ACCES to our courses";
		}

	}

}
