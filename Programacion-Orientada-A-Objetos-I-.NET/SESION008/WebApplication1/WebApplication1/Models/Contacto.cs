using System.ComponentModel; 
using System.ComponentModel.DataAnnotations; 

namespace WebApplication1.Models
{
    public class Contacto
    {
        public int Id { get; set; } // Actúa como primaria

        [Required(ErrorMessage = "El DNI es obligatorio")] // Muestra mensaje si no se ingresa un valor
        public string DNI { get; set; }

        [Required(ErrorMessage = "El Nombre es obligatorio")] // Muestra mensaje si no se ingresa un valor
        public string Nombre { get; set; }

        [DisplayName("Dirección")] // Cambia el nombre que se muestra en la vista
        public string Direccion { get; set; }

        public string Celular { get; set; } // Número de celular

        public string Email { get; set; } // Dirección de correo electrónico

        [DisplayName("Fecha de creación")] // Cambia el nombre que se muestra en la vista
        public string FechaCreacion { get; set; }
    }
}
