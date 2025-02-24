using Microsoft.AspNetCore.Mvc;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class OrdenesController : Controller
    {
        public IActionResult Index()
        {
            return View(new Servicio());
        }


        [HttpPost]
        public IActionResult Index(Servicio  serv)
        {
            string mensaje = "";

            try
            {
                if (serv.Fecha > DateTime.Today)
                    throw new Exception();
                mensaje = "Fecha correcta";

                if (serv.Costo <= 0) throw new Exception();
                mensaje = "EL costo debe ser un valor positivo";
            }
            catch(FormatException) 
            {
                mensaje = "El costo del servicio debe ser un valor positivo ";
            }
            catch (Exception e)
            {
              mensaje =  "La fecha es mayor a la fecha actual";
            }
            ViewBag.mensaje = mensaje;
            return View(new Servicio());
        }


    }
}
