

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Order;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String aviso ="";

		try {
		String nombre="";
		double precioUnitario = 0;
		int cantidad = 0;
		double total=0;
		 nombre = request.getParameter("nameProduct");
		 precioUnitario = Double.parseDouble( request.getParameter("price") );
		 cantidad =Integer.parseInt( request.getParameter("quantity") );
		
		 
		String cantidadMsg = cantidad<=1 ? cantidad + " unidad":cantidad + " unidades";
		cantidad = cantidad<0?0:cantidad;
		precioUnitario = precioUnitario<0?0:precioUnitario;
		
		
		Order order = new Order(nombre, cantidad,precioUnitario, total );
		total = calcularPrecioTotal(order.getCantidad(), order.getPrecioProducto());
		//total = calcularPrecioTotal(cantidad,precioUnitario );
		aviso=total<=0? "No se aceptan números negativos":"";

		
		
		request.setAttribute("nombre", nombre);
		request.setAttribute("precioUnitario", precioUnitario);
		request.setAttribute("cantidadMsg", cantidadMsg);
		request.setAttribute("total", total);
		request.setAttribute("aviso", aviso);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("sumary.jsp");
		dispatcher.forward(request, response);
		
		
		}catch (Exception e) {
			aviso = "No se cargaron los datos";
		}
		
	}
	
	
	public double calcularPrecioTotal(int cantidad, double preUnitario) {
		return cantidad * preUnitario;
	}
	
	 
	
	

}
