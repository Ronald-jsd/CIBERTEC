using System.ComponentModel;
using System.ComponentModel.DataAnnotations; // Importar para usar Data Annotations

namespace WebApplication1.Models
{
    public class Contacto
    {
        // La propiedad 'Id' es reconocida automáticamente como clave primaria 
        // y se genera en secuencia de uno en uno
        public int Id { get; set; }

        // Data Annotation: Campo obligatorio con mensaje de error personalizado
        [Required(ErrorMessage = "El DNI es obligatorio")]
        public string DNI { get; set; }

        // Campo obligatorio con mensaje de error personalizado
        [Required(ErrorMessage = "El Nombre es obligatorio")]
        public string Nombre { get; set; }

        // Permite mostrar un nombre personalizado en la vista (permite caracteres especiales)
        [DisplayName("Dirección")]
        public string Direccion { get; set; }

        // Campo para almacenar el número de celular
        public string Celular { get; set; }

        // Valida el formato del email y muestra un mensaje si es incorrecto
        [EmailAddress(ErrorMessage = "El email es incorrecto")]
        public string Email { get; set; }

        // Fecha de creación del contacto
        public DateTime FechaCreacion { get; set; }
    }
}
