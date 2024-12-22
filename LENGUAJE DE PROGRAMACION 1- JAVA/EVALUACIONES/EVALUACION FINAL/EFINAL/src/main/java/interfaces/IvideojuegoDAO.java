package interfaces;
import java.util.List;

import models.Videojuego;

public interface IvideojuegoDAO {
	// Registrar un nuevo videojuego
    void registrarVideojuego(Videojuego videojuego);

    // Actualizar un videojuego existente
    void actualizarVideojuego(Videojuego videojuego);

    // Borrar un videojuego por su código
    void borrarVideojuego(int codigo);

    // Listar todos los videojuegos
    List<Videojuego> listarVideojuegos();
}
