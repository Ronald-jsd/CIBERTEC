using Microsoft.AspNetCore.Mvc;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class PersonaController : Controller
    {

        private static List<Alumno> lAlumnos = new List<Alumno>()
        {
        new Alumno() {DNI = "75413655",ApellidoPaterno = "Jaime", ApellidoMaterno="Duran",Nombres="Ronald Santiago", Carrera = "Nutrición", Nota1=15, Nota2= 18, Nota3=17, FechaNac = DateTime.Parse("1999-03-03") },
        new Alumno() { DNI = "75413656", ApellidoPaterno = "Gomez", ApellidoMaterno = "Perez", Nombres = "Maria Fernanda", Carrera = "Ingeniería de Sistemas", Nota1 = 14, Nota2 = 17, Nota3 = 19, FechaNac = DateTime.Parse("2000-05-12") }, 
        new Alumno() { DNI = "75413657", ApellidoPaterno = "Lopez", ApellidoMaterno = "Martinez", Nombres = "Carlos Alberto", Carrera = "Medicina", Nota1 = 14, Nota2 = 15, Nota3 = 16, FechaNac = DateTime.Parse("1998-11-23") }
        };

        //listar
        public IActionResult Index()
        {
            return View(lAlumnos);
        }

        //create
        public IActionResult Create()
        {
            return View();
        }
        //create httpost
        [HttpPost]
        public IActionResult Create(Alumno al)
        {
            if (ModelState.IsValid)
            {
                lAlumnos.Add(al);
                return RedirectToAction("Index");
            }
            return View(al);
        }
    }
}
