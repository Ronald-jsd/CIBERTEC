namespace WebApplication1.Models
{
    public class Alumno:Persona
    {
        public string Carrera {  get; set; }   
        public double Nota1 {  get; set; }
        public double Nota2 {  get; set; }
        public double Nota3 { get; set; }

        public double Promedio() => (Nota1 + Nota2 + Nota3) / 3;


    }
}
