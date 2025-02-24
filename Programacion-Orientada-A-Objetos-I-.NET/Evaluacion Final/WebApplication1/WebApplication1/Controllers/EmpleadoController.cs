using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.ActionConstraints;
using Microsoft.AspNetCore.Mvc.Infrastructure;
using Microsoft.Build.Construction;
using Microsoft.CodeAnalysis.CSharp.Syntax;
using Microsoft.EntityFrameworkCore;
using Microsoft.Identity.Client;
using System.Diagnostics.Contracts;
using WebApplication1.Datos;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class EmpleadoController : Controller
    {
        /**/
        private readonly AplicacionDbContext _context;

        // contex a la  variable tipo AplicacionDbContext_Conext
        public EmpleadoController(AplicacionDbContext context)
        {
            _context = context;
        }
  
        public async Task<IActionResult> Index(string dato)
        {
            // Referencia a la tabla Empleado en el DbContext
            var empleadosQuery = _context.Empleado.AsQueryable();

            if (!string.IsNullOrEmpty(dato))
            {
                empleadosQuery = empleadosQuery.Where(
                    al => al.DNI.Contains(dato) || al.Apellidos.Contains(dato));
            }
            // Retorna la vista con la lista de empleados (filtrada o completa)
            return View(await empleadosQuery.ToListAsync());
        }

        //----------------------------------------------------------------
        public IActionResult Create()
        {
            return View();
        }

        //METODO POST
        [HttpPost]
        public async Task<IActionResult> Create(Empleado co)
        {
            if (ModelState.IsValid)
            {
                // Verifica si el DNI ya existe en la base de datos
                var existingEmpleado = await _context.Empleado.FirstOrDefaultAsync(e => e.DNI == co.DNI);

                if (existingEmpleado != null)
                {
                    ViewBag.Mensaje = "El DNI ingresado ya existe.";
                    return View(co);
                }
                _context.Empleado.Add(co);
                await _context.SaveChangesAsync();
                return RedirectToAction("Index"); 
            }
            return View(co);
        }

        //----------------------------------------------------------------
        /* EDIT */

        public IActionResult Edit(int id)
        {
            var con = _context.Empleado.Find(id);

            if (con == null)
            {
                return NotFound();
            }
            return View(con);
        }


        [HttpPost]
        public async Task<IActionResult> Edit(Empleado con)
        {
            if (ModelState.IsValid)
            {
                _context.Update(con);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View();
        }

        //----------------------------------------------------------------
        /* DETALLE */
        public IActionResult Details(int id)
        {
            var con = _context.Empleado.Find(id);
            if (con == null)
            {
                return NotFound();
            }
            return View(con);
        }

        //----------------------------------------------------------------
        /* DELETE */
        public IActionResult Delete(int id)
        {
            //busca por id  y luego lo retorna 
            var con = _context.Empleado.Find(id);
            if (con == null)
            {
                return NotFound();
            }
            return View(con);
        }


        [HttpPost]
        public async Task<IActionResult> Delete(int? id)
        {

            var con = await _context.Empleado.FindAsync(id);


            if (con == null)
            {
                return View();
            }
            _context.Empleado.Remove(con);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

    }
}

