using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using WebApplication1.Datos;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class ContactoController : Controller
    {
        // Inyección de dependencias del contexto de la base de datos
        private readonly AplicacionDbContext _context;

        // Constructor que asigna el contexto a la variable local
        public ContactoController(AplicacionDbContext context)
        {
            _context = context;
        }

        // ==================== CRUD OPERACIONES ==================== //

        // Mostrar lista de contactos (READ)
        public async Task<IActionResult> Index()
        {
            // Retorna una lista asincrónica de todos los contactos
            return View(await _context.Contacto.ToListAsync());
        }

        // Mostrar formulario de creación de un nuevo contacto (GET)
        public IActionResult Create()
        {
            return View();
        }

        // Crear nuevo contacto (POST)
        [HttpPost]
        public async Task<IActionResult> Create(Contacto contacto)
        {
            if (ModelState.IsValid)
            {
                // Asigna la fecha actual antes de guardar
                contacto.FechaCreacion = DateTime.Now;

                // Agrega el nuevo contacto al contexto
                _context.Contacto.Add(contacto);

                // Guarda los cambios en la base de datos
                await _context.SaveChangesAsync();

                // Redirige a la lista de contactos
                return RedirectToAction(nameof(Index));
            }

            // Si hay errores en el modelo, retorna la vista con los datos ingresados
            return View(contacto);
        }

        // Mostrar formulario de edición de contacto (GET)
        public IActionResult Edit(int id)
        {
            var contacto = _context.Contacto.Find(id);

            if (contacto == null)
            {
                return NotFound();
            }

            return View(contacto);
        }

        // Editar un contacto existente (POST)
        [HttpPost]
        public async Task<IActionResult> Edit(Contacto contacto)
        {
            if (ModelState.IsValid)
            {
                _context.Update(contacto);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }

            return View(contacto);
        }

        // Mostrar detalles de un contacto específico (READ)
        public IActionResult Details(int id)
        {
            var contacto = _context.Contacto.Find(id);
            if (contacto == null)
            {
                return NotFound();
            }

            return View(contacto);
        }

        // Mostrar formulario de confirmación para eliminar contacto (GET)
        public IActionResult Delete(int id)
        {
            var contacto = _context.Contacto.Find(id);
            if (contacto == null)
            {
                return NotFound();
            }

            return View(contacto);
        }

        // Eliminar contacto (POST)
        [HttpPost, ActionName("Delete")]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var contacto = await _context.Contacto.FindAsync(id);

            if (contacto == null)
            {
                return NotFound();
            }

            _context.Contacto.Remove(contacto);
            await _context.SaveChangesAsync();

            return RedirectToAction(nameof(Index));
        }
    }
}
