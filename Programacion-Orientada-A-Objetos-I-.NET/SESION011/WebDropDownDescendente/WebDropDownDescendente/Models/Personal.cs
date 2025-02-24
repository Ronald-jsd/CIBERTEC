using System.ComponentModel.DataAnnotations;

namespace WebDropDownDescendente.Models
{
    public class Personal
    {
        public int Id { get; set; }

        // Validación para que el nombre sea obligatorio
        [Required(ErrorMessage = "El nombre es obligatorio.")]
        public string Nombre { get; set; }

        // Validación del formato de DNI
        [Required(ErrorMessage = "El DNI es obligatorio.")]
        [StringLength(8, MinimumLength = 8, ErrorMessage = "El DNI debe tener 8 dígitos.")]
        public string DNI { get; set; }

        // Clave foránea que establece relación con Distrito
        [Required(ErrorMessage = "Debe seleccionar un distrito.")]
        public int DistritoId { get; set; }

        // Propiedad de navegación para establecer relación con la clase Distrito
        public Distrito Distrito { get; set; }
    }
}
