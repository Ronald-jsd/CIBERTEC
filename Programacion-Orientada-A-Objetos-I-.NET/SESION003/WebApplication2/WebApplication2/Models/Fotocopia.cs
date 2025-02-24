namespace WebApplication2.Models
{
    public class Fotocopia
    {
        //definiendo atributos
        public string NRecibo { get; set; }
        public string Cliente { get; set; }
        public string Descripcion { get; set; }
        public int Cantidad { get; set; }
        public double Tarifa { get; set; }


        //Inicalizamos en el constructor
        public Fotocopia()
                {
                    Tarifa = 0.1;
                    Cantidad = 0;
                }

        //METODOS 
        //que va ser impportado (virtual)
        public virtual double Importe()
        {
            return Tarifa * Cantidad;
        }
    
    
    
    
    }
}
