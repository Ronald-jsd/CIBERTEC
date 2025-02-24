using Microsoft.AspNetCore.Mvc;
using NuGet.Configuration;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class MantenimientoController : Controller
    {
        // Lista estática de clientes predefinidos
        private static List<Cliente> lclientes = new List<Cliente>()
        {
            new Cliente{DNI = "77559988", Nombre = "Juan", Direccion = "Chorrillos", Celular = "996688549", Email = "juanpe@gmail.com"},
            new Cliente{DNI = "66554433", Nombre = "María", Direccion = "Miraflores", Celular = "987654321", Email = "maria@gmail.com"},
            new Cliente{DNI = "55443322", Nombre = "Carlos", Direccion = "San Isidro", Celular = "912345678", Email = "carlos@gmail.com"},
            new Cliente{DNI = "44332211", Nombre = "Ana", Direccion = "Barranco", Celular = "923456789", Email = "ana@gmail.com"},
            new Cliente{DNI = "33221100", Nombre = "Luis", Direccion = "Surco", Celular = "934567890", Email = "luis@gmail.com"},
            new Cliente{DNI = "22110099", Nombre = "Elena", Direccion = "La Molina", Celular = "945678901", Email = "elena@gmail.com"}
        };

        // MÉTODO: Listar y buscar clientes
        public async Task<IActionResult> Index(string dato)
        {
            List<Cliente> temporal;

            // Verificar si el parámetro 'dato' está vacío o es nulo
            if (string.IsNullOrEmpty(dato))
            {
                // Retornar toda la lista de clientes
                return View(await Task.Run(() => lclientes));
            }
            else
            {
                // Filtrar la lista de clientes por coincidencia en el nombre (ignora mayúsculas/minúsculas)
                temporal = lclientes.Where(
                    c => c.Nombre.Contains(dato, StringComparison.CurrentCultureIgnoreCase)).ToList();

                // Retornar la lista filtrada de clientes
                return View(await Task.Run(() => temporal));
            }
        }

        // MÉTODO: Mostrar formulario de creación de cliente
        public async Task<IActionResult> Create()
        {
            return View(await Task.Run(() => new Cliente()));
        }

        // MÉTODO: Registrar nuevo cliente
        [HttpPost]
        public async Task<IActionResult> Create(Cliente cli)
        {
            if (ModelState.IsValid)
            {
                lclientes.Add(cli);
                ViewBag.mensaje = "Registro realizado"; // Mensaje de éxito
                return View(await Task.Run(() => cli)); // Ejecutar de manera asincrónica
            }

            return View(await Task.Run(() => cli)); // Ejecutar de manera asincrónica
        }

        // MÉTODO: Mostrar detalles de un cliente
        public async Task<IActionResult> Details(string dni)
        {
            var clienteExiste = lclientes.FirstOrDefault(clie => clie.DNI == dni);

            // Verificar si el cliente existe
            if (clienteExiste == null)
            {
                return NotFound();
            }

            return View(await Task.Run(() => clienteExiste));
        }

        // MÉTODO: Mostrar formulario de edición de cliente
        public async Task<IActionResult> Edit(string dni)
        {
            var clienteExiste = lclientes.FirstOrDefault(cli => cli.DNI == dni);

            // Verificar si el cliente existe
            if (clienteExiste == null)
            {
                return NotFound();
            }

            return View(await Task.Run(() => clienteExiste));
        }

        // MÉTODO: Actualizar datos del cliente
        [HttpPost]
        public async Task<IActionResult> Edit(Cliente client)
        {
            if (ModelState.IsValid)
            {
                var clienteExiste = lclientes.FirstOrDefault(cli => cli.DNI == client.DNI);

                // Verificar si el cliente existe
                if (clienteExiste == null)
                {
                    return await Task.Run(() => NotFound());
                }

                // Actualizar datos del cliente
                clienteExiste.DNI = client.DNI;
                clienteExiste.Nombre = client.Nombre;
                clienteExiste.Direccion = client.Direccion;
                clienteExiste.Celular = client.Celular;
                clienteExiste.Email = client.Email;

                return RedirectToAction("Index");
            }

            return View(client);
        }

        // MÉTODO: Mostrar confirmación de eliminación
        [HttpGet]
        public async Task<IActionResult> Delete(string dni)
        {
            var clienteExiste = lclientes.FirstOrDefault(cli => cli.DNI == dni);

            // Verificar si el cliente existe
            if (clienteExiste == null)
            {
                return NotFound();
            }

            return View(clienteExiste);
        }

        // MÉTODO: Eliminar cliente de la lista
        [HttpPost]
        public async Task<IActionResult> Delete(string dni, Cliente cli)
        {
            var clienteExiste = lclientes.FirstOrDefault(c => c.DNI == dni);

            // Verificar si el cliente existe
            if (clienteExiste == null)
            {
                return NotFound();
            }

            // Eliminar el cliente de la lista
            lclientes.Remove(clienteExiste);
            TempData["mensaje"] = "Cliente eliminado exitosamente."; // Mensaje de éxito
            return RedirectToAction("Index");
        }
    }
}
