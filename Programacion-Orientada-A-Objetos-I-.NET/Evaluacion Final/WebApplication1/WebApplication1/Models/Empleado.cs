using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Globalization;

namespace WebApplication1.Models
{
    public class Empleado
    {
        public int Id { get; set; }

        [Required(ErrorMessage = "El DNI es obligatorio")]
        public string DNI {  get; set; }

        [Required(ErrorMessage = "El apellido es obligatorio")]
        public String Apellidos {  get; set; }
        public string Nombres { get; set; }

        [DisplayName("Estado Civil")]
        [Required(ErrorMessage = "El Estado Civil es obligatorio")]
        public string EstadoCivil {  get; set; }

        [Required(ErrorMessage = "El sexo es obligatorio")]
        public string Sexo { get; set; }

        [DisplayName("Fecha de Ingreso")]
        public DateTime FechaIngreso { get; set; }

        public enum EnumEstadoCivil
        {
            Viudo,
            Casado,
            Divorciado, 
            Soltero
        }

        public enum EnumSexo
        {
            Masculino,
            Femenino
        }

        public int CalcularAñosEnEmpresa()
        {
                DateTime FechaActual = DateTime.Now.Date; //solo fecha 
                int AñosIntervalo = FechaActual.Year - FechaIngreso.Year;

                //10/03/2024  <   02/03/2024
                if (FechaIngreso.AddYears(AñosIntervalo) < FechaActual)
                {
                    AñosIntervalo--;
                }
                return AñosIntervalo;

        }

    }

}
