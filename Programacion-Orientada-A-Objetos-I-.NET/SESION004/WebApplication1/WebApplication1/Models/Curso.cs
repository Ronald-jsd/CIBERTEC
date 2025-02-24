using System.ComponentModel.DataAnnotations;//importamos para usar Key

namespace WebApplication1.Models
{
    public class Curso
    {
        [Key] public int IDCurso { get; set; }  //podemos agregar un DataAnnotations // Nos indica que es una clave primaria
        public string Descripcion {  get; set; }
        public int Creditos {  get; set; }

        public DateTime fechaNacimiento {  get; set; }

        public int calculaEdad()
        {
            DateTime fechaActual = DateTime.Today;
            int edad = fechaActual.Year - fechaNacimiento.Year;

            // Verificar si el cumpleaños ya pasó este año
            if (fechaActual.Month < fechaNacimiento.Month ||
                (fechaActual.Month == fechaNacimiento.Month && fechaActual.Day < fechaNacimiento.Day))
            {
                edad--;
            }

            return edad;
        }
    }
}
