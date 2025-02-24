using Microsoft.AspNetCore.Mvc;
using WebApplication1.Models; //Importamos la carpeta de nuestro modelo(Donde estan los atributos y metodos)****

namespace WebApplication1.Controllers
{
    /*
     * La clase VentasController hereda de la clase Controller.
     * En ASP.NET Core, un controlador maneja solicitudes HTTP, interactúa con el modelo, 
     * y devuelve una respuesta (vista HTML, JSON, etc.).
     */
    public class VentasController : Controller
    {
        /*
         * Este método maneja solicitudes GET. Cuando un usuario accede a la URL correspondiente,
         * devuelve la vista Index.cshtml y pasa un nuevo objeto Venta a la vista.
         *
         * - public: El método es accesible desde cualquier parte de la aplicación.
         * - IActionResult: Indica que el método puede devolver diferentes tipos de respuestas (View, Json, etc.).
         * - return View(new Venta()): Devuelve la vista Index con un nuevo objeto Venta.
         */
        public IActionResult Index()
        {
            return View(new Venta());
        }

        /*
         * Este método maneja solicitudes POST. Se utiliza para procesar datos enviados desde la vista (por ejemplo, un formulario).
         * - [HttpPost]: Indica que este método responde a solicitudes HTTP POST.
         * - IActionResult Index(Venta v): Recibe el objeto Venta que contiene los datos del formulario.
         */
        //Agregamos lo siguiente para calcular
        [HttpPost]
        public IActionResult Index(Venta v)
        {
            // Utilizamos ViewBag para pasar los valores calculados a la vista.
            ViewBag.descuento = v.Descuento().ToString("####.#0");
            ViewBag.neto = v.Neto().ToString("####.#0");

            // Devolvemos la vista Index.cshtml con el objeto Venta y los valores calculados.
            return View(v);
        }
    }
}
