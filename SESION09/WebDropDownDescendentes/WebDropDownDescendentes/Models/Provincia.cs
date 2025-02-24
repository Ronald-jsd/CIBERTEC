namespace WebDropDownDescendentes.Models
{
    public class Provincia
    {
        public int Id { get; set; } 
        public string Nombre { get; set; }

        //Establenciendo cardinalidad uno a muchos con Distrito
        public ICollection<Distrito> Distrito { get; set; }
    }
}
