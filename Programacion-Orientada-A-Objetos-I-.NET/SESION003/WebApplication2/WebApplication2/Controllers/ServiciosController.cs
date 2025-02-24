using Microsoft.AspNetCore.Mvc;
using WebApplication2.Models;

namespace WebApplication2.Controllers
{
    public class ServiciosController : Controller
    {
        public IActionResult Index()
        {
            return View(new Fullcopy());
        }

        [HttpPost]
        public IActionResult Index( Fullcopy Fc)
        {
            ViewBag.tarifa = Fc.Tarifario();
            ViewBag.importe = Fc.Importe().ToString("#,###.#0");
            return View(Fc);
        }

    }
}
