using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using WebApplication1.DatoContext;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class ContactoController : Controller
    {
        // Inyección de dependencias: Usar la clase contexto para acceder a la base de datos
        private readonly AplicacionDbContext _contexto;

        // Constructor de ContactoController que recibe un objeto de tipo contexto
        public ContactoController(AplicacionDbContext contexto)
        {
            _contexto = contexto;
        }

        // Acción para obtener todos los datos de la tabla Contacto
        // Método asíncrono porque la consulta puede tomar tiempo
        public async Task<ActionResult> Index()
        {
            // Retorna una lista de contactos definida en el contexto
            return View(await _contexto.Contacto.ToListAsync());
        }

        // Acción para mostrar el formulario de creación de un nuevo contacto
        public ActionResult Create()
        {
            return View();
        }

        // Acción que recibe el formulario de creación (POST)
        [HttpPost]
        public async Task<IActionResult> Create(Contacto co)
        {
            if (ModelState.IsValid)
            {
                // Asignar la fecha actual de creación si se desea
                // co.FechaCreacion = DateTime.Now;

                // Agregar el objeto al contexto de la base de datos
                _contexto.Contacto.Add(co);

                // Guardar los cambios de manera asíncrona
                await _contexto.SaveChangesAsync();

                // Redirigir a la vista Index
                return RedirectToAction(nameof(Index));
            }

            // Si hay errores de validación, retornar el mismo formulario con los datos ingresados
            return View(co);
        }

        // Acción para mostrar el formulario de edición de un contacto existente
        public IActionResult Edit(int id)
        {
            var contactoExistente = _contexto.Contacto.Find(id);
            if (contactoExistente == null)
            {
                return NotFound();
            }

            return View(contactoExistente);
        }

        // Acción que actualiza un contacto existente (POST)
        [HttpPost]
        public async Task<IActionResult> Edit(Contacto co)
        {
            if (ModelState.IsValid)
            {
                // Actualizar el contacto en el contexto
                _contexto.Update(co);

                // Guardar los cambios de manera asíncrona
                await _contexto.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }

            // Si hay errores de validación, retornar el mismo formulario
            return View();
        }

        // Acción para ver los detalles de un contacto
        public IActionResult Details(int id)
        {
            var contactoExistente = _contexto.Contacto.Find(id);
            if (contactoExistente == null)
            {
                return NotFound();
            }

            return View(contactoExistente);
        }

        // Acción para mostrar la confirmación de eliminación de un contacto
        public IActionResult Delete(int id)
        {
            var contactoExistente = _contexto.Contacto.Find(id);
            if (contactoExistente == null)
            {
                return NotFound();
            }

            return View(contactoExistente);
        }

        // Acción que elimina un contacto de manera asíncrona
        [HttpPost, ActionName("Delete")]
        public async Task<ActionResult> DeleteConfirmed(int id)
        {
            var contactoExistente = await _contexto.Contacto.FindAsync(id);

            if (contactoExistente == null)
            {
                return NotFound();
            }

            // Eliminar el contacto del contexto
            _contexto.Contacto.Remove(contactoExistente);

            // Guardar los cambios de manera asíncrona
            await _contexto.SaveChangesAsync();

            // Redirigir a la vista Index
            return RedirectToAction(nameof(Index));
        }
    }
}
