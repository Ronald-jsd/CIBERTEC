namespace WebApplication1.Models
{
    public class Alumno
    {
        public int idAlumno {  get; set; }
        public string DNI { get; set; }
        public string Apellidos { get; set; }
        public string Nombres { get; set; }
        public string TipoEstudiante {  get; set; } 
        public string Sexo {  get; set; }
        public DateTime FechaDeNacimiento { get; set; }


        public int calcularEdad()
        {
            DateTime FechaActual = DateTime.Now.Date; //solo fecha 
            int EdadIntervalo = FechaActual.Year - FechaDeNacimiento.Year;


            //10/03/2024 >   02/03/2024
            if (FechaDeNacimiento.AddYears(EdadIntervalo) < FechaActual)
            {
                EdadIntervalo--;
            }

            return EdadIntervalo; 

        }


        public enum EnumTipoEstudiante
        {
            Regular,
            Becado,
            Extraordinario
        }

        public enum EnumSexo
        {
            Masculino,
            Femenino
        }

    }
}
