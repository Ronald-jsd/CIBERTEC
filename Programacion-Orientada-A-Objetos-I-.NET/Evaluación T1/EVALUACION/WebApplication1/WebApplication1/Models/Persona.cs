namespace WebApplication1.Models
{
    public class Persona
    {
        public string DNI { get; set; }
        public string ApellidoPaterno {  get; set; }
        public string ApellidoMaterno {  get; set; }
        public string Nombres { get; set; }
        public DateTime FechaNac {  get; set; } 

        public string GenerarCorreo() {

            string Correo =           Nombres.Substring(0, 1) 
                                    + ApellidoPaterno 
                                    + ApellidoMaterno.Substring(0,1)
                                    +"@cibertec.edu.pe";
            return Correo;

        }
        public int CalcularEdad()
        {
            DateTime fechaActual = DateTime.Today;  
            int edad = fechaActual.Year - FechaNac.Year;  

            if (fechaActual < FechaNac.AddYears(edad))  // d / m /a  
            {
                edad--;
            }

            return edad;
        }


    }
}
