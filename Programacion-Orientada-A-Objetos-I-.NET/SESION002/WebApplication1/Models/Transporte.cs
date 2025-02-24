namespace WebApplication1.Models
{
    public class Transporte
    {
        //Atributos o propiedades
    // Atributos
    public string NombreDestinatario { get; set; }
    public string DireccionDestino { get; set; }
    public double CantidadTM { get; set; }
    public double Tarifa { get; set; } = 150; // Tarifa estándar


        //Constructor para inicializar
        public Transporte(string nombreDestinatario, string direccionDestino, double cantidadTM)
        {
            NombreDestinatario = nombreDestinatario;
            DireccionDestino = direccionDestino;
            CantidadTM = cantidadTM;
            Tarifa = 150; // Tarifa estándar
        }

        //Metodos generales
        // Método virtual para sobrescribir
        public virtual double Tarifador()
        {
            return Tarifa; // Tarifa estándar para las empresas que no sobrescriben
        }

        public virtual double CalcularFlete()
        {
            return Tarifa * CantidadTM;
        }

        public virtual double CalcularSeguro()
        {
            return 0; // Por defecto, sin seguro para la clase base
        }

        public double CalcularMontoTotal()
        {
            return CalcularFlete() + CalcularSeguro();
        }

    }//final class
}//final namespace
