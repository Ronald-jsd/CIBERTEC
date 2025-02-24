using Microsoft.AspNetCore.Mvc;
using Microsoft.CodeAnalysis.CSharp.Syntax;
using Newtonsoft.Json;
using System;
using System.Linq;
using WebApplication1.Models;
using static System.Runtime.InteropServices.JavaScript.JSType;



namespace WebApplication1.Controllers
{
    public class AlumnoController : Controller
    {

        //La Ruta de carpeta a guardar el archivo JSON
        private readonly string carpeta = Path.Combine(Directory.GetCurrentDirectory(), "folder");

        //Almacenar ruta del archivo JSON
        private readonly string archivo;


       public AlumnoController()
        {
            //verificacion si carpeta existe
            if (!Directory.Exists(carpeta))
            {
                Directory.CreateDirectory(carpeta);
            }

            //Asigno ruta del archivo JSON
            archivo = Path.Combine(carpeta, "Alumnos.json");
        }

        //Metodo Leer datos del archivo .Json y devolver una lista proveedores
        private List<Alumno> LeerAlumnos()
        {
            //validacion si el archivo existe
            if (!System.IO.File.Exists(archivo))
            {
                return new List<Alumno>();
            }

            using (FileStream fs = new FileStream(archivo, FileMode.Open, FileAccess.Read))//abrir json, solo lectura
            using (StreamReader sr = new StreamReader(fs))//leer el archivo
            {
                string jsonData = sr.ReadToEnd();
                return JsonConvert.DeserializeObject<List<Alumno>> (jsonData) ?? new List<Alumno>();
            }
        }

        private void GrabarAlumnos(List<Alumno> alumnos)
        {
            using (FileStream fs = new FileStream(archivo, FileMode.Create, FileAccess.Write))//abrir json, escritura
            using (StreamWriter sw = new StreamWriter(fs))
            {
                string jsonData = JsonConvert.SerializeObject(alumnos, Formatting.Indented);
                sw.Write(jsonData);
            }
        }

        public IActionResult Index(string dato)
        {
            var listaAlumno = LeerAlumnos();


            if (!string.IsNullOrEmpty(dato))
            {
                var alumnosFiltrados = listaAlumno.Where(
                    al =>   al.DNI.Contains(dato, StringComparison.CurrentCultureIgnoreCase)
                         || al.Apellidos.Contains(dato, StringComparison.CurrentCultureIgnoreCase)).ToList();
                
                return View(alumnosFiltrados);
            }
            return View(listaAlumno);
            
        }
        
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Create(Alumno alu)
        {
                string mensaje = "";
                var listaAlumnoss = LeerAlumnos();

                var alumnoEncontrado = listaAlumnoss.FirstOrDefault(p => p.DNI == alu.DNI);

               if (alumnoEncontrado != null)
               {
                   mensaje = "Su dni ya existe";
                   ViewBag.mensaje = mensaje;
                 return View(alu);
               }
           
                if (ModelState.IsValid)
                {
                    var listaAlumnos = LeerAlumnos().ToList();

                alu.idAlumno = listaAlumnos.Count > 0 ? listaAlumnos.Max(p => p.idAlumno + 1) : 1;

                    //if (listaAlumnos.Any())
                    //{
                    //    // Asigna el ID sumando 1 al máximo ID existente en la lista
                    //    alu.idAlumno = listaAlumnos.Max(al => al.idAlumno) + 1;
                    //}
                    //else
                    //{
                    //    alu.idAlumno = 1;
                    //}
                    listaAlumnos.Add(alu);
                    GrabarAlumnos(listaAlumnos);
                    return RedirectToAction("Index");
                }

                return View(alu);    
        }



            public IActionResult Edit(int id)
        {
            var listaAlumnos = LeerAlumnos(); //lista actual alumnos
            var alumnoExistente = listaAlumnos.FirstOrDefault(p => p.idAlumno == id); 
            if (alumnoExistente == null) 
            {
                return NotFound(); 
            }
            return View(alumnoExistente); 

        }


        [HttpPost]
        public IActionResult Edit(Alumno alu)
        {
            if (ModelState.IsValid)
            {
                var listaAlumnos = LeerAlumnos();
                
                // Busca el índice del alumno a editar en la lista
                var indexAlu = listaAlumnos.FindIndex(p => p.idAlumno == alu.idAlumno);
                
                if(indexAlu != -1)// Si encuentra el alumno en la lista
                {
                    listaAlumnos[indexAlu] = alu; // Actualiza los datos del alumno en la lista
                    GrabarAlumnos(listaAlumnos);  // Guarda la lista actualizada en el archivo JSON
                }

                return RedirectToAction("Index");
            }

            return View(alu);
        }
        
        public IActionResult Delete(int id )
        {
            var listaAlumnos = LeerAlumnos(); 
            var alum = listaAlumnos.FirstOrDefault(p => p.idAlumno == id); 
            if (alum == null) 
            {
                return NotFound(); 
            }
            return View(alum);

        }

        [HttpPost, ActionName("Delete")]
        public IActionResult DeleteConfirmed(int id)
        {
            if (ModelState.IsValid)
            {
                var listaAlumnos = LeerAlumnos().ToList();

                var alum = listaAlumnos.FirstOrDefault(p => p.idAlumno == id);

                if (alum != null) 
                {
                    listaAlumnos.Remove(alum);
                    GrabarAlumnos(listaAlumnos); 
                }
                return RedirectToAction("Index");
            }
            return NotFound(); // Retorna un error 404 si el modelo no es válido
        }
         


        public IActionResult Details(int id)
        {
            var listaAlumnos = LeerAlumnos();
            var alu = listaAlumnos.FirstOrDefault(p => p.idAlumno == id);


            if(alu == null)
            {
                return NotFound(); 
            }
            return View(alu);
        }











    }
}
