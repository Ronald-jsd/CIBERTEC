/*
 Manejo de Clases y Objetos

La empresa Tapicería “FAST” nos pide realizar un programa que permita registrar la venta de
muebles que la empresa ofrece a los clientes.

En este proceso debemos ingresar el número de la boleta, la fecha, el nombre del cliente, la
descripción del mueble, y su precio. La empresa aplica el siguiente descuento: si el precio es
mayor a 500 se aplica un descuento que representa al 10% del precio, sino el descuento es el
2% del precio. El precio de venta neto es la diferencia del precio y su descuento.

Se pide realizar las siguientes actividades:
 Crear un proyecto ASP.NET en Visual C#.
 Diseño de la clase, sus atributos, propiedades y métodos.
 Diseñar una vista definiendo sus controles.
 Programe el formulario instanciando la clase, ingrese sus datos y visualice los resultados.
 */


// nombreDelProyecto.Models 
namespace WebApplication1.Models
{
    
    public class Venta
    {
        //atributos de la clase
        //prop  + tab
        public string NroBoleta { get; set; }
        public DateTime Fecha { get; set; }
        public string Nombre { get; set; }
        public string Mueble { get; set; }
        public double precio { get; set; }


        //constructor para inicializar los atributos
        public Venta()
        {
            NroBoleta = "";
           // Fecha = DateTime.Now;// devuelve fecha y hora
            Fecha = DateTime.Today; // devuelve solo la fecha 
            Nombre = "";
            Mueble = "";
            precio = 0;  

        }

        //Metodos de la clase
            //Metodo calcular el valor del descuento
        public double Descuento()
        {
            if(precio == 0)
            {
                return 0;
            }   else if (precio > 500)
            {
                return precio * 0.1;
            }   else
            {
                return precio * 0.02;
            }
        }

            //Metodo calcular el precio neto de venta
            public double Neto()
        {
            return precio - Descuento();
        }



    }
}
