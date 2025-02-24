using Microsoft.AspNetCore.Mvc;
using WebApplication1.Models; // Importamos la carpeta de nuestras clases

namespace WebApplication1.Controllers
{
    public class AcademicoController : Controller
    {
        // 1. CREAR LA LISTA DE OBJETOS
        // List<NombreDeLaClase> nombreDeLaLista = new List<NombreDeLaClase>();
        static private List<Curso> lcursos = new List<Curso>()
        {
            // Agregamos cursos a la lista
            new Curso(){ IDCurso = 1, Descripcion = "Introducción a la Algoritmia", Creditos = 4 },
            new Curso(){ IDCurso = 2, Descripcion = "Arquitectura de Entornos Web", Creditos = 3 },
            new Curso(){ IDCurso = 3, Descripcion = "Algoritmos y Estructura de Datos", Creditos = 4 },
            new Curso(){ IDCurso = 4, Descripcion = "Desarrollo de Entornos Web", Creditos = 3 },
            new Curso(){ IDCurso = 5, Descripcion = "Base de Datos", Creditos = 5 },
        };

        // 2. MÉTODO PARA BUSCAR O FILTRAR CURSOS
        public IActionResult Index(string dato = "")
        {
            // Verificar si el valor ingresado está vacío
            if (string.IsNullOrEmpty(dato))
            {
                return View(lcursos); // Retornar la lista completa de cursos
            }
            else
            {
                // Retornar cursos que coincidan con el término de búsqueda (sin importar mayúsculas o minúsculas)
                return View(lcursos.Where(
                    c => c.Descripcion.Contains(dato, StringComparison.CurrentCultureIgnoreCase)));
            }
        }

        // 3. MÉTODO CREATE: MOSTRAR FORMULARIO PARA CREAR UN NUEVO CURSO
        public IActionResult Create()
        {
            return View();
        }

        // Procesar el formulario para agregar un nuevo curso
        [HttpPost]
        public IActionResult Create(Curso c)
        {
            // Verificar si el modelo es válido
            if (ModelState.IsValid)
            {
                lcursos.Add(c); // Agregar el nuevo curso a la lista
                return RedirectToAction("Index"); // Redirigir al listado de cursos
            }
            return View(c); // Si no es válido, mantener al usuario en el formulario
        }

        // 4. MÉTODO DETAILS: MOSTRAR DETALLES DE UN CURSO
        public IActionResult Details(int id = 0)
        {
            var c = lcursos.FirstOrDefault(cu => cu.IDCurso == id); // Buscar curso por ID
            if (c == null)
            {
                return NotFound(); // Si no se encuentra, devolver error 404
            }
            return View(c); // Retornar la vista con los detalles del curso
        }

        // 5. MÉTODO EDITAR: MOSTRAR FORMULARIO PARA EDITAR UN CURSO
        public IActionResult Edit(int id)
        {
            var c = lcursos.FirstOrDefault(cu => cu.IDCurso == id);
            if (c == null)
            {
                return NotFound();
            }
            return View(c); // Retornar el formulario con los datos del curso
        }

        // Procesar los cambios realizados en el curso
        [HttpPost]
        public IActionResult Edit(int id, Curso ce)
        {
            if (ModelState.IsValid)
            {
                var c = lcursos.FirstOrDefault(cu => cu.IDCurso == id);
                if (c == null)
                {
                    return NotFound();
                }
                c.Descripcion = ce.Descripcion;
                c.Creditos = ce.Creditos;
                return RedirectToAction("Index"); // Redirigir al listado de cursos
            }
            return View();
        }

        // 6. MÉTODO DELETE: MOSTRAR CONFIRMACIÓN PARA ELIMINAR UN CURSO
        public IActionResult Delete(int id)
        {
            var c = lcursos.FirstOrDefault(c => c.IDCurso == id);
            if (c == null)
            {
                return NotFound();
            }
            return View(c); // Mostrar la vista de confirmación
        }

        // Procesar la eliminación del curso
        [HttpPost]
        public IActionResult Delete(int id, Curso cur)
        {
            var c = lcursos.FirstOrDefault(cur => cur.IDCurso == id);
            if (c == null)
            {
                return NotFound();
            }
            lcursos.Remove(c); // Eliminar el curso de la lista
            return RedirectToAction("Index"); // Redirigir al listado de cursos
        }
    }
}
