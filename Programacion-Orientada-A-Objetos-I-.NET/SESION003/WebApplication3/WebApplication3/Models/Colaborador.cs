using System.ComponentModel.DataAnnotations;

namespace WebApplication3.Models
{
    public class Colaborador
    {
        //atributos
        public string DNI { get; set; }
        public string ApellidoPaterno { get; set; }
        public string ApellidoMaterno { get; set; }
        public string Sexo { get; set; }

        public DateTime FechaNacimiento { get; set; }

        //metodo para generar ID
        public virtual  string GenerarID()
        {
           string codigoID = "C"  + ApellidoPaterno 
                        + ApellidoMaterno.Substring(0,1) 
                        + FechaNacimiento.Year 
                        + DNI.Substring(DNI.Length - 3);

            return codigoID.ToUpper();
        }


        public Colaborador()
        {
            FechaNacimiento = DateTime.Today;
        }
    }
}
