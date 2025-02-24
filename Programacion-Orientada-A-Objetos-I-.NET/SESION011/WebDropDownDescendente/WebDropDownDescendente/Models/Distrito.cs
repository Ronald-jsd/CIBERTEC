using System.ComponentModel.DataAnnotations;

namespace WebDropDownDescendente.Models
{
    public class Distrito
    {
        // Clave primaria
        public int Id { get; set; }

        // Nombre del distrito (campo obligatorio)
        [Required(ErrorMessage = "El nombre del distrito es obligatorio.")]
        public string Nombre { get; set; }

        // Clave foránea -> Relación con la clase Provincia
        public int ProvinciaId { get; set; }

        // Propiedad de navegación -> Relación de muchos a uno con Provincia
        public Provincia Provincia { get; set; }

        // Relación de uno a muchos -> Un distrito puede tener varias personas
        public ICollection<Personal> Personal { get; set; }

        // Constructor para inicializar la colección
        public Distrito()
        {
            Personal = new List<Personal>();
        }
    }
}
