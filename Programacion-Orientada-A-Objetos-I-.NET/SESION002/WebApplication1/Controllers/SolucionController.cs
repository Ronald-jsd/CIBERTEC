using Microsoft.AspNetCore.Mvc;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class SolucionController : Controller
    {
        // Método para mostrar el formulario general
        public IActionResult IndexGeneral()
        {
            return View();
        }

        [HttpPost]
        public IActionResult IndexGeneral(string empresa, string nombreDestinatario, string direccionDestino, double cantidadTM)
        {
            Transporte transport;

            if (empresa == "Ivovic")
            {
                transport = new Ivovic(nombreDestinatario, direccionDestino, cantidadTM);
            }
            else if (empresa == "Leonidas")
            {
                transport = new Leonidas(nombreDestinatario, direccionDestino, cantidadTM);
            }
            else
            {
                ViewBag.Error = "Debe seleccionar una empresa válida.";
                return View();
            }

            // Establece la tarifa antes de realizar los cálculos
            transport.Tarifador();

            // Calcular y asignar resultados a ViewBag
            ViewBag.tarifa = transport.Tarifador().ToString("#,###.#0");
            ViewBag.flete = transport.CalcularFlete().ToString("#,###.#0");
            ViewBag.seguro = transport.CalcularSeguro().ToString("#,###.#0");
            ViewBag.monto = transport.CalcularMontoTotal().ToString("#,###.#0");

            ViewBag.Empresa = empresa;

            return View(transport); //PARA QUE LOS RESULTADOS SE MUESTREN EN EL MISMO INDEX
        }
    }
}

