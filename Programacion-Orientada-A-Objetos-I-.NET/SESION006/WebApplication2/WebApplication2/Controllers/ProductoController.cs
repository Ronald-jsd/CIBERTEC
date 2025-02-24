using Microsoft.AspNetCore.Mvc;
using WebApplication2.Models; // Importar las clases del modelo
using Newtonsoft.Json; // Importar el paquete NuGet para manejar JSON

namespace WebApplication2.Controllers
{
    public class ProductoController : Controller
    {
        // Creación de un objeto JSON con la lista de productos inicial
        static string jProducto = @"
        [
            { 'IDProducto': 1, 'Descripcion': 'Laptop', 'Presentacion': 'Caja', 'Precio': 1500, 'Stock': 50 },
            { 'IDProducto': 2, 'Descripcion': 'Impresora', 'Presentacion': 'Caja', 'Precio': 600, 'Stock': 30 },
            { 'IDProducto': 3, 'Descripcion': 'Mouse', 'Presentacion': 'Blister', 'Precio': 25, 'Stock': 200 },
            { 'IDProducto': 4, 'Descripcion': 'Teclado', 'Presentacion': 'Caja', 'Precio': 45, 'Stock': 150 },
            { 'IDProducto': 5, 'Descripcion': 'Monitor', 'Presentacion': 'Caja', 'Precio': 300, 'Stock': 80 },
            { 'IDProducto': 6, 'Descripcion': 'Disco Duro Externo', 'Presentacion': 'Caja', 'Precio': 100, 'Stock': 60 }
        ]";

        // MÉTODO INDEX: Muestra todos los productos o filtra por descripción
        public IActionResult Index(string texto)
        {
            List<Producto> listaProductos = new List<Producto>();

            // Deserializar el JSON en una lista de productos
            if (!string.IsNullOrEmpty(jProducto))
            {
                listaProductos = JsonConvert.DeserializeObject<List<Producto>>(jProducto);
            }

            // Si no hay texto de búsqueda, devuelve la lista completa
            if (string.IsNullOrEmpty(texto))
            {
                return View(listaProductos);
            }

            // Filtrar productos por descripción (sin distinguir mayúsculas/minúsculas)
            var productosFiltrados = listaProductos
                .Where(p => p.Descripcion.Contains(texto, StringComparison.CurrentCultureIgnoreCase))
                .ToList();

            return View(productosFiltrados);
        }

        // MÉTODO CREATE (GET): Muestra el formulario de creación
        public IActionResult Create()
        {
            return View(new Producto());
        }

        // MÉTODO CREATE (POST): Crea un nuevo producto
        [HttpPost]
        public IActionResult Create(Producto p)
        {
            string mensaje = "";
            try
            {
                // Deserializar el JSON en una lista de productos
                List<Producto> listaProductos = JsonConvert.DeserializeObject<List<Producto>>(jProducto);
                listaProductos.Add(p); // Agregar nuevo producto a la lista

                // Serializar nuevamente la lista actualizada a JSON
                jProducto = JsonConvert.SerializeObject(listaProductos);
                mensaje = "Producto registrado";
            }
            catch (JsonException e) // Capturar errores de serialización
            {
                mensaje = e.Message;
            }

            ViewBag.mensaje = mensaje;
            return View(p);
        }

        // MÉTODO DETAILS: Muestra los detalles de un producto específico
        public IActionResult Details(int id)
        {
            List<Producto> listaProductos = JsonConvert.DeserializeObject<List<Producto>>(jProducto);
            Producto pro = listaProductos.FirstOrDefault(p => p.IDProducto == id);
            return View(pro);
        }

        // MÉTODO EDIT (GET): Muestra el formulario para editar un producto
        public IActionResult Edit(int id)
        {
            List<Producto> listaProductos = JsonConvert.DeserializeObject<List<Producto>>(jProducto);
            var productoExiste = listaProductos.FirstOrDefault(p => p.IDProducto == id);

            if (productoExiste == null)
            {
                return NotFound();
            }

            return View(productoExiste);
        }

        // MÉTODO EDIT (POST): Actualiza un producto existente
        [HttpPost]
        public IActionResult Edit(Producto pro)
        {
            if (ModelState.IsValid)
            {
                List<Producto> listaProductos = JsonConvert.DeserializeObject<List<Producto>>(jProducto);
                var productoExiste = listaProductos.FirstOrDefault(p => p.IDProducto == pro.IDProducto);

                if (productoExiste == null)
                {
                    return NotFound();
                }

                // Actualizar los datos del producto
                productoExiste.Descripcion = pro.Descripcion;
                productoExiste.Presentacion = pro.Presentacion;
                productoExiste.Precio = pro.Precio;
                productoExiste.Stock = pro.Stock;

                // Serializar la lista actualizada a JSON
                jProducto = JsonConvert.SerializeObject(listaProductos);

                return RedirectToAction("Index");
            }

            return View(pro);
        }

        // MÉTODO DELETE (GET): Muestra el formulario de confirmación de eliminación
        public IActionResult Delete(int id)
        {
            List<Producto> lProductos = JsonConvert.DeserializeObject<List<Producto>>(jProducto);
            var productoExistente = lProductos.FirstOrDefault(p => p.IDProducto == id);

            if (productoExistente == null)
            {
                return NotFound();
            }

            return View(productoExistente);
        }

        // MÉTODO DELETE (POST): Elimina el producto confirmado
        [HttpPost, ActionName("Delete")]
        public IActionResult DeleteConfirmado(int id)
        {
            List<Producto> lProductos = JsonConvert.DeserializeObject<List<Producto>>(jProducto);
            var productoExistente = lProductos.FirstOrDefault(p => p.IDProducto == id);

            if (productoExistente == null)
            {
                return NotFound();
            }

            // Eliminar el producto de la lista
            lProductos.Remove(productoExistente);

            // Serializar nuevamente la lista actualizada a JSON
            jProducto = JsonConvert.SerializeObject(lProductos);

            return RedirectToAction("Index");
        }
    }
}
