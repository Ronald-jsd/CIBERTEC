namespace WebApplication2.Models
{
    public class Producto
    {

       public int IDProducto {  get; set; }
        public string Descripcion { get; set; }
        public string UnidadMedida { get; set; }
        public double Precio {  get; set; }
        public int Stock { get; set; }


        public enum Medidas
        {
            Unidad,
            Docena,
            Metro,
            Kilo,
            Ciento,
            Libra
        }

    }
}
