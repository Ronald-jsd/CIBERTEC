package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class DesarrolladoraServlet
 */
@WebServlet("/DesarrolladoraServlet")
public class DesarrolladoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DesarrolladoraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("accion");
		if(action.equalsIgnoreCase("listarDesarrolladoras")) {
		
		DesarrolladoraDAO desarrolladoraDAO = new DesarrolladoraDAO();
		
		List<Desarrolladora> listaDesarrolladoras = desarrolladoraDAO.listarDesarrolladoras();
		
		System.out.println("Lista de desarrolladoras: " + listaDesarrolladoras);

		request.setAttribute("listaDesarrolladoras", listaDesarrolladoras);
        VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
        List<Videojuego> listaVideojuegos = videojuegoDAO.listarVideojuegos();

        request.setAttribute("listaVideojuegos", listaVideojuegos);

        
        
        
        
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("/videojuegos.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}

}
