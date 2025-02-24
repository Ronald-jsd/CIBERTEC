namespace WebDropDownDescendentes.Models
{
    public class Distrito
    {
        public int Id { get; set; }
        public string Nombre { get; set; } 

        //clave foranea
        public int ProvinciaId { get; set; }

        //PROPIEDAD DE NAVEGACION
        //Distrito es con provincia
        public Provincia Provincia { get; set; }
        //establecer la relacion
        //estableecr  cardinalidad 1 a muchos con Personal
        public ICollection<Personal> Personal { get; set; }   

    }
}
