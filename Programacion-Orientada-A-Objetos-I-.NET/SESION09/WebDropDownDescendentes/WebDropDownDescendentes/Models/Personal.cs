namespace WebDropDownDescendentes.Models
{
    public class Personal
    {
        public int Id { get; set; }
        public string Nombre { get; set; }
        public string DNI { get; set; }

        //clave foranea
        public int DistritoId { get; set; }

        //propiedad de navegacion
        //clase personal se esta relacionando con distrito
        public Distrito Distrito { get; set; }


    }
}
