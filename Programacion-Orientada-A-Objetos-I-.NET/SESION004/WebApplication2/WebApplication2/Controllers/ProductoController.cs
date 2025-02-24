using Microsoft.AspNetCore.Mvc;
using WebApplication2.Models;

namespace WebApplication2.Controllers
{
    public class ProductoController : Controller
    {
        // 1. CREAR LISTA ESTÁTICA DE PRODUCTOS
        private static List<Producto> lproductos = new List<Producto>()
        {
            new Producto{ IDProducto = 1, Descripcion = "Mouse", UnidadMedida = "unidad", Precio = 25.50, Stock = 100 },
            new Producto{ IDProducto = 2, Descripcion = "Teclado", UnidadMedida = "unidad", Precio = 45.00, Stock = 50 },
            new Producto{ IDProducto = 3, Descripcion = "Monitor", UnidadMedida = "unidad", Precio = 150.00, Stock = 30 },
            new Producto{ IDProducto = 4, Descripcion = "Impresora", UnidadMedida = "unidad", Precio = 120.00, Stock = 20 },
            new Producto{ IDProducto = 5, Descripcion = "Altavoces", UnidadMedida = "par", Precio = 35.00, Stock = 75 }
        };

        // 2. MÉTODO INDEX: LISTAR Y FILTRAR PRODUCTOS
        public IActionResult Index(string dato = "")
        {
            if (string.IsNullOrEmpty(dato))
            {
                return View(lproductos); // Mostrar la lista completa de productos
            }
            else
            {
                // Filtrar productos por descripción (sin importar mayúsculas o minúsculas)
                var productosFiltrados = lproductos.Where(
                    c => c.Descripcion.Contains(dato, StringComparison.CurrentCultureIgnoreCase));

                return View(productosFiltrados);
            }
        }

        // 3. MÉTODO CREATE: MOSTRAR FORMULARIO PARA AGREGAR NUEVO PRODUCTO
        public IActionResult Create()
        {
            return View();
        }

        // Procesar el formulario de creación de producto
        [HttpPost]
        public IActionResult Create(Producto prod)
        {
            if (ModelState.IsValid)
            {
                // Generar un nuevo ID para el producto
                prod.IDProducto = lproductos.Count > 0
                    ? lproductos.Max(p => p.IDProducto) + 1
                    : 1;

                lproductos.Add(prod); // Agregar el nuevo producto a la lista
                return RedirectToAction("Index");
            }

            return View(prod); // Si no es válido, mantener al usuario en la vista de creación
        }

        // 4. MÉTODO EDIT: MOSTRAR FORMULARIO PARA EDITAR UN PRODUCTO
        public IActionResult Edit(int id)
        {
            var productoExistente = lproductos.FirstOrDefault(p => p.IDProducto == id);
            if (productoExistente == null)
            {
                return NotFound(); // Retorna error 404 si el producto no existe
            }
            return View(productoExistente);
        }

        // Procesar los cambios en el producto
        [HttpPost]
        public IActionResult Edit(Producto product)
        {
            if (ModelState.IsValid)
            {
                var productoExistente = lproductos.FirstOrDefault(p => p.IDProducto == product.IDProducto);

                if (productoExistente == null)
                {
                    return NotFound();
                }

                // Actualizar los datos del producto
                productoExistente.Descripcion = product.Descripcion;
                productoExistente.UnidadMedida = product.UnidadMedida;
                productoExistente.Stock = product.Stock;
                productoExistente.Precio = product.Precio;

                return RedirectToAction("Index"); // Redirigir al listado de productos
            }
            return View(product);
        }

        // 5. MÉTODO DETAILS: MOSTRAR DETALLES DE UN PRODUCTO
        public IActionResult Details(int id)
        {
            var productoExistente = lproductos.FirstOrDefault(p => p.IDProducto == id);
            if (productoExistente == null)
            {
                return NotFound();
            }
            return View(productoExistente);
        }

        // 6. MÉTODO DELETE: MOSTRAR CONFIRMACIÓN DE ELIMINACIÓN
        public IActionResult Delete(int id)
        {
            var productoExistente = lproductos.FirstOrDefault(p => p.IDProducto == id);
            if (productoExistente == null)
            {
                return NotFound();
            }
            return View(productoExistente); // Mostrar el producto para confirmación
        }

        // Procesar la eliminación del producto
        [HttpPost, ActionName("Delete")]
        public IActionResult DeleteConfirmacion(int id)
        {
            var productoExistente = lproductos.FirstOrDefault(p => p.IDProducto == id);
            if (productoExistente == null)
            {
                return NotFound();
            }

            lproductos.Remove(productoExistente); // Eliminar el producto de la lista
            return RedirectToAction("Index");
        }
    }
}
