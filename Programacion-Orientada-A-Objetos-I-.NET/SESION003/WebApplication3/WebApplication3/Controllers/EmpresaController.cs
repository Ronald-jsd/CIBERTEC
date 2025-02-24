using Microsoft.AspNetCore.Mvc;
using WebApplication3.Models;

namespace WebApplication3.Controllers
{
    public class EmpresaController : Controller
    {
        public IActionResult Index()
        {
            return View(new Practicante());
        }

        [HttpPost]
        public IActionResult Index(Practicante Pr)
        {

            ViewBag.generarId = Pr.GenerarID();

            return View(Pr);
        }

    }
}
