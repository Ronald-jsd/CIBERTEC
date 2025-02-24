namespace WebDropDownDescendente.Models
{
    public class DropDownsVM
    {
        // Lista de provincias para llenar el dropdown de provincias
        public List<Provincia> Provincias { get; set; }

        // Constructor para inicializar las listas y evitar errores de referencia nula
        public DropDownsVM()
        {
            Provincias = new List<Provincia>();
        }
    }
}
