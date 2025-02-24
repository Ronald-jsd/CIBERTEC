namespace WebApplication1.Models
{
    public class Leonidas : Transporte
    {
        public Leonidas(string nombreDestinatario, string direccionDestino, double cantidadTM)
            : base(nombreDestinatario, direccionDestino, cantidadTM)
        {
        }

        public override double Tarifador()
        {
            switch (DireccionDestino.ToLower())
            {
                case "arequipa":
                case "ilo":
                case "tacna":
                    Tarifa = 200;
                    break;
                case "piura":
                case "tumbes":
                case "cajamarca":
                    Tarifa = 220;
                    break;
                default:
                    Tarifa = 150;
                    break;
            }
            return Tarifa;
        }
        public enum ListaDestinos
        {
            Arequipa,
            Ilo,
            Tacna,
            Piura,
            Tumbes,
            Cajamarca,
            //Agregando extras 
            Ica,
            Moquegua,
            Libertad,
            Lambayeque
        }



        public override double CalcularFlete()
        {
            return Tarifa * CantidadTM;
        }

        public override double CalcularSeguro()
        {
            return CalcularFlete() * 0.005; // 0.5% del flete
        }



    }



}
