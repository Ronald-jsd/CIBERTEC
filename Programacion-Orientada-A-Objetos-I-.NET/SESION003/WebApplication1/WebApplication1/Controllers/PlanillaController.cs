using Microsoft.AspNetCore.Mvc;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class PlanillaController : Controller
    {
        public IActionResult Index()
        {
            return View(new Empleado());
        }


        //Para Mostrar los resultados
        [HttpPost]
        public IActionResult Index(Empleado E)
        {
            ViewBag.bonificacion = E.Bonificacion().ToString("#,###.#0");
            ViewBag.escolaridad = E.Escolaridad().ToString("#,###.#0");
            ViewBag.movilidad = E.Movilidad().ToString("#,###.#0");
            ViewBag.retencion5ta = E.Retencion5ta().ToString("#,###.#0");
            ViewBag.seguro = E.Seguro().ToString("#,###.#0");
            ViewBag.neto = E.Neto().ToString("#,###.#0");

            return View(E);
        }



    }
}
