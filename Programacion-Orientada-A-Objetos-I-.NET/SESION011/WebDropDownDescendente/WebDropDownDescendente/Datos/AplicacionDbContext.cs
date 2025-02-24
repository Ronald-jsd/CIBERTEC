using Microsoft.EntityFrameworkCore;
using WebDropDownDescendente.Models;

namespace WebDropDownDescendente.Datos
{
    public class AplicacionDbContext : DbContext
    {
        // Constructor de la clase AplicacionDbContext
        // Se encarga de recibir las opciones de configuración para el contexto
        public AplicacionDbContext(DbContextOptions<AplicacionDbContext> options) : base(options) { }

        // Definición de las tablas en la base de datos a partir de los modelos
        public DbSet<Provincia> Provincias { get; set; }  // Tabla de Provincias
        public DbSet<Distrito> Distritos { get; set; }    // Tabla de Distritos
        public DbSet<Personal> Personales { get; set; }   // Tabla de Personales
    }
}
