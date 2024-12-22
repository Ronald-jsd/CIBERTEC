	package servlets;
	
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import dao.LigasDao;
import dao.UserDao;
	import models.ClubModel;
	import models.LigaModel;
	
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
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			//OBTENER ACCION
			String accion = request.getParameter("accion");
			System.out.println("Acción recibida: " + accion);
			
			//Evaluo la accion
			if(accion == null  || accion.isEmpty()) {
				accion = "listarLigas";
			}
			
			//Enviar al metodo segun la accion
			switch (accion) {
		    	case "listarLigas" -> listarLigas(request, response);
			    case "listarClubsDeLigas" -> listarClubesPorIDLiga(request, response);
			    default -> System.out.println("Acción no reconocida");
			}
		}//FIN
	
		/*METODO PARA LISTAR LAS LIGAS PARA EL COMBOBOX*/
		private void listarLigas(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException{
	
			try{
				//Obtengio la lista de ligas de la bd
				List <LigaModel> listaLigas = 	LigasDao.listarLigas();  
				//Establezco esta liga a la pagina como atibuto
				request.setAttribute("listaLigas", listaLigas);
				//Redireccion
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}catch (Exception e) {
				System.out.println("No se obtuvo la lista");
			}
		
		}//FIN
		
		//METODO LISTAR LOS CLUBES SEGUN LA LIGA ESCOGIDA
		private void listarClubesPorIDLiga(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
			// TODO Auto-generated method stub
			try {	
				
				//OBTENGO EL PARAMETRO DE LA VISTA
				String listarClubsODetalles = request.getParameter("listarClubODetalles");
		        
				
		        System.out.println("Nombre del club encontrado = " + listarClubsODetalles);

		        /*LISTAR CLUBES*/
		        //Evaluo  el parametro 
		        if(listarClubsODetalles.equalsIgnoreCase("listarClubs"))  {
			        //obtengo la id
		        	int id_liga = Integer.parseInt(request.getParameter("id_liga"));
			        //obtengo la lista de clubes segun el id liga
		        	List<ClubModel> listClubes = UserDao.listarClubesPorIDLiga(id_liga);	
			        request.setAttribute("listClubes", listClubes);
			        
			        request.getRequestDispatcher("listadoClubes.jsp").forward(request, response);  		        	
		         
		       	}else {
		       		
		       			/*LISTAR DETALLES DE ESE CLUB SELECCIONADO*/
		       			//obtengo id 
		       			int id_club =  Integer.parseInt(request.getParameter("id_liga"));
		        		System.out.println("id_club" + id_club);
			        	ClubModel clubSeleccionado = UserDao.obtenerDetallesPorClub(id_club);
			        	request.setAttribute("clubSeleccionado", clubSeleccionado);
				        request.getRequestDispatcher("detalles.jsp").forward(request, response);    
		       		}	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}//FIN
	
		
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//doGet(request, response);
		}
	
	}
