namespace WebApplication1.Models
{
    public class Empleado:IRemuneracion, IDescuento
    {
        
        //Debo implementar los metodos obligatorios de las interfases QUE ESTA HEREDANDO 
        //Al implementar de 2 Interfases --> Es herencia Multiple
        public  string DNI { get;set; }
        public  string Nombre { get;set; }   
        public  string Cargo{get;set; }
        public double Basico {  get;set; }


        //interfaz IRemuneracion
        public double Bonificacion()
        {
            return Basico * 0.2; 
        }

        public double Escolaridad()
        {
            return 95;
        }

        public double Movilidad()
        {
            return Basico * 0.1;
        }


        //interfaz IDescuento
        public double Retencion5ta()
        {
            return 0.15 * (Basico + Bonificacion());
        }

        public double Seguro()
        {
            return 0.11 * (Basico + Bonificacion() + Escolaridad() + Movilidad() );
        }

        //METODO PROPIOS
        public double Neto()
        {
            return (Basico + Bonificacion() + Escolaridad() + Movilidad()) - (Retencion5ta() + Seguro());
        }

    }
}
