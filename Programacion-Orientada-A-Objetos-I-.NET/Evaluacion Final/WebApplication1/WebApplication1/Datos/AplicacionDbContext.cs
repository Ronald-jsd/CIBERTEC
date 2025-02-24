
using Microsoft.EntityFrameworkCore;
using System.Diagnostics.Contracts;
using WebApplication1.Models; //importar libreria para DbContext

namespace WebApplication1.Datos
{
    
    /*DbContext , permite vincullar las propiedades de su modelo, a su base de datos con una cade de conexion*/

    /*Para que nuestra clase Contacto ,y sus atributos se vinculen con lo que luego sera la tabla contacto sql server, 
     * se encargara los metodos que implemete la clase DbContext
     */

    public class AplicacionDbContext : DbContext //heredamos de DbContext
    {
        //CREAR CONSTRUCTOR
        //ponemos el tipos de dato que manejara la clase
        public AplicacionDbContext(DbContextOptions<AplicacionDbContext> options) : base(options) { }

        /* LUEGO DEBAJO AGREGAMOS LOS MODELOS DE LAS CLASES DE MODELS PARA LA BASE DE DATOS */
        public DbSet<Empleado> Empleado { get; set; }

    }
}

