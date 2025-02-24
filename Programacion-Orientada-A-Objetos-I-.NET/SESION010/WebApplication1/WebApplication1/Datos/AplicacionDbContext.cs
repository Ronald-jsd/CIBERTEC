using Microsoft.EntityFrameworkCore;
using WebApplication1.Models; // Importar la librería para DbContext y los modelos

namespace WebApplication1.Datos
{
    // La clase AplicacionDbContext hereda de DbContext
    // Permite vincular las propiedades de los modelos con las tablas de la base de datos mediante una cadena de conexión
    public class AplicacionDbContext : DbContext
    {
        // Constructor que recibe las opciones de configuración del contexto
        // Estas opciones incluyen la cadena de conexión y otras configuraciones de EF Core
        public AplicacionDbContext(DbContextOptions<AplicacionDbContext> options) : base(options) { }

        // Definición de la tabla Contacto en la base de datos
        // La clase Contacto se mapeará como una tabla en SQL Server
        public DbSet<Contacto> Contacto { get; set; }
    }
}
