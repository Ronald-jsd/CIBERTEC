using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;
using WebDropDownDescendente.Datos;
using WebDropDownDescendente.Models;

namespace WebDropDownDescendente.Controllers
{
    public class HomeController : Controller
    {
        // Inyección de dependencias para el registro de logs
        private readonly ILogger<HomeController> _logger;

        // Inyección del contexto de la base de datos
        private readonly AplicacionDbContext _context;

        // Constructor que recibe el logger y el contexto de la base de datos
        public HomeController(ILogger<HomeController> logger, AplicacionDbContext contexto)
        {
            _logger = logger;
            _context = contexto;
        }

        // Método principal que carga la vista inicial
        public IActionResult Index()
        {
            // Trae todas las provincias desde la base de datos
            var pvs = _context.Provincia.ToList();

            // Crea un ViewModel con la lista de provincias
            var vm = new DropDownsVM { Provincias = pvs };

            // Devuelve la vista con el ViewModel cargado
            return View(vm);
        }

        // Vista de privacidad (plantilla por defecto)
        public IActionResult Privacy()
        {
            return View();
        }

        // Manejador de errores con cache deshabilitado
        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }

        // ---------------------------------------------------------------
        // Acción que devuelve los distritos según la provincia seleccionada
        [HttpGet]
        public JsonResult obtenerDistritos(int proviID)
        {
            // Filtra los distritos por el ID de la provincia
            var distritos = _context.Distrito.Where(d => d.ProvinciaId == proviID).ToList();

            // Devolver solo los datos necesarios (opcional para mejorar el rendimiento)
            // var resultado = distritos.Select(d => new {
            //     id = d.Id,
            //     nombre = d.Nombre
            // }).ToList();

            // Devuelve los distritos en formato JSON
            return Json(distritos);
        }
    }
}
