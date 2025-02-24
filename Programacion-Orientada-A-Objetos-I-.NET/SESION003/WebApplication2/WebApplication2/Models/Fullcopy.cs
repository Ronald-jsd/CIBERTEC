namespace WebApplication2.Models
{
    //hereda de clase FOTOCOPIA
    public class Fullcopy:Fotocopia
    {

        public string Tamaño { get; set; }

        public double Tarifario()
        {
            switch (Tamaño) {
                case "A4": Tarifa = 0.2; break;
                case "A3": Tarifa = 0.8; break;
                case "Carta": Tarifa = 0.3;break;
                default: Tarifa = 0.1; break;
            }
            return Tarifa;        
        }

        //sobrescribiendo el metodo heredaro (override)
        public override double Importe()
        {
            return Tarifario() * Cantidad;
        }

        //La lista de los distintos tamaños de papel para Lista desplegable
        public enum ListaTamanos
        {
            A4,
            A3,
            Carta
        }
    }
}
