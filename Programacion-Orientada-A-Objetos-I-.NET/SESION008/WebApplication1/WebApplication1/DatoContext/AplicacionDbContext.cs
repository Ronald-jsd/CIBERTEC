using Microsoft.EntityFrameworkCore;
using WebApplication1.Models;// importar

namespace WebApplication1.DatoContext
{
    public class AplicacionDbContext : DbContext
    {
        public AplicacionDbContext(DbContextOptions<AplicacionDbContext> options) : base(options) { }
        
        //Agregamos los modelos(clases) de la BD
        public DbSet<Contacto> Contacto { get; set; }

    }
}
