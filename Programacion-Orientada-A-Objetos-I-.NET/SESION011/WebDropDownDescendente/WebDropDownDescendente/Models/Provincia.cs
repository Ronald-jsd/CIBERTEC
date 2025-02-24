using System.ComponentModel.DataAnnotations;

namespace WebDropDownDescendente.Models
{
    public class Provincia
    {
        public int Id { get; set; }

        // Validación para asegurarse de que el nombre sea obligatorio
        [Required(ErrorMessage = "El nombre de la provincia es obligatorio.")]
        public string Nombre { get; set; }

        // Relación uno a muchos con Distrito (una provincia puede tener varios distritos)
        public ICollection<Distrito> Distritos { get; set; }

        // Constructor para inicializar la colección y evitar errores de referencia nula
        public Provincia()
        {
            Distritos = new List<Distrito>();
        }
    }
}
