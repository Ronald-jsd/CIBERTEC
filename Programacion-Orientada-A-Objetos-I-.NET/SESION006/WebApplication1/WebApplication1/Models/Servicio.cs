using Microsoft.AspNetCore.SignalR;
using System.Reflection.Metadata.Ecma335;

namespace WebApplication1.Models
{
    public class Servicio
    {
        public string NroServicio { get; set; }
        public DateTime Fecha {  get; set; }
        public string Cliente { get; set; }
        public string Descripcion { get; set; }
        public double Costo { get; set; }
        public double IGV { get
            {
                return 0.18 * Costo;
            }
        }
        public double Monto { get
            {
                return Costo + IGV;
            }
        }


    }
}
