	package dao;
	
	import java.sql.CallableStatement;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import interfaz.IUserDao;
	import model.User;

		public class UserDao implements IUserDao {
	    private Connection connection; 
	// Constructor que recibe una conexión como parámetro
	    public UserDao(Connection connection) {
	        this.connection = connection; 
	    }
	    
	// método para registrar un usuario
	    @Override
	    public boolean registerUser(User user) {
	        String sql = "INSERT INTO userclub (nombre, liga, puntaje, victorias, derrotas) VALUES (?,?,?,?,?)"; 
	        try {
	            PreparedStatement ps = connection.prepareStatement(sql); 
	            ps.setString(1, user.getName()); 
	            ps.setString(2, user.getLiga()); 
	            ps.setInt(3, user.getPuntos()); 
	            ps.setInt(4, user.getVictorias());
	            ps.setInt(5, user.getDerrotas()); 
	            return ps.executeUpdate() > 0; // Ejecuta la consulta y verifica si se registró
	        } catch (Exception e) {
	            e.printStackTrace(); 
	            return false; 
	        }
	    }
	// Implementación del método para listar clubes
	    @Override
	    public List<User> listarClub() {
	        List<User> equipos = new ArrayList<>(); 
	        String sql = "{call listarEquipos()}"; 
	        try (CallableStatement cs = connection.prepareCall(sql); ResultSet rs = cs.executeQuery()) {
	            while (rs.next()) { // Itera sobre los resultados
	                String nombre = rs.getString("nombre");
	                String liga = rs.getString("liga");
	                int puntos = rs.getInt("puntaje");
	                int victorias = rs.getInt("victorias");
	                int derrotas = rs.getInt("derrotas");
	                equipos.add(new User(nombre, liga, puntos, victorias, derrotas)); 
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return equipos; // Retorna la lista de clubes
	    }

		@Override
		public boolean deleteUser(String name) {
			// TODO Auto-generated method stub
			String sql = "DELETE FROM userclub WHERE nombre=? ";
			  try {
		            PreparedStatement ps = connection.prepareStatement(sql); 
		            ps.setString(1, name);
		            int filasAfectadas = ps.executeUpdate();
		            return filasAfectadas > 0; // Ejecuta la consulta y verifica si se registró
		        } catch (SQLException e) {
		            e.printStackTrace(); 
		        }
			return false;
		}
		
		
		
	}