using Microsoft.AspNetCore.Mvc; 
using Newtonsoft.Json;
using WebApplication1.Models; 

namespace WebApplication1.Controllers
{
    public class ProveedorController : Controller 
    {
        // Variable que indica la ubicación y el nombre de la carpeta 
        // donde se almacenará el archivo de datos ( .JSON )
        private readonly string carpeta = Path.Combine(Directory.GetCurrentDirectory(), "folder");
        // Path.Combine --> para indicar la ruta
        // Directory.GetCurrentDirectory()  --> Obtiene el directorio actual
        // "folder" --> nombre libre de la carpeta

        // Declarando la variable del archivo JSON
        // Nombre libre --> archivo
        private readonly string archivo;

        // Constructor del controlador Proveedor
        public ProveedorController()
        {
            // Verificar si la carpeta de destino existe
            // Si no existe, se crea la carpeta
            if (!Directory.Exists(carpeta))
            {
                Directory.CreateDirectory(carpeta); // Crear la carpeta
            }

            // Almacena en la variable "archivo" el nombre y la ruta del archivo .JSON
            archivo = Path.Combine(carpeta, "Proveedores.json"); // Ruta del archivo JSON
        }

        // Método privado para realizar el proceso de lectura
        // de datos del archivo Proveedores.json
        private List<Proveedor> LeeProveedores()
        {
            // Si no existe el archivo Proveedores.json
            if (!System.IO.File.Exists(archivo))
            {
                return new List<Proveedor>(); // Retorna una lista vacía si no existe el archivo
            }

            // Abre el archivo en modo lectura
            using (FileStream fs = new FileStream(archivo, FileMode.Open, FileAccess.Read))
            using (StreamReader sr = new StreamReader(fs))
            {
                string jsonData = sr.ReadToEnd(); // Lee todo el contenido del archivo
                // Deserializa el contenido JSON a una lista de Proveedor
                return JsonConvert.DeserializeObject<List<Proveedor>>(jsonData) ?? new List<Proveedor>();
            }
        }

        // Método para realizar el proceso de escritura de los datos en el archivo Proveedores.json
        private void grabarProveedores(List<Proveedor> proveedores)
        {
            // Abre el archivo en modo escritura (crea el archivo si no existe)
            using (FileStream fs = new FileStream(archivo, FileMode.Create, FileAccess.Write))
            using (StreamWriter sw = new StreamWriter(fs))
            {
                // Serializa la lista de proveedores a formato JSON
                string jsonData = JsonConvert.SerializeObject(proveedores, Formatting.Indented);
                sw.Write(jsonData); // Escribe el contenido JSON en el archivo
            }
        }

        // Acción para mostrar la lista de proveedores
        public IActionResult Index()
        {
            var listaProveedores = LeeProveedores(); // Llama al método para leer los proveedores
            return View(listaProveedores); // Retorna la vista con la lista de proveedores
        }

        /* Método para crear un nuevo proveedor */
        public IActionResult Create()
        {
            return View(); // Retorna la vista para crear un nuevo proveedor
        }

        [HttpPost]
        public IActionResult Create(Proveedor pro) // Recibe un proveedor desde el formulario
        {
            if (ModelState.IsValid) // Verifica si el modelo es válido
            {
                var listaProveedores = LeeProveedores(); // Obtiene la lista actual de proveedores

                // Asignando un ID único al nuevo proveedor
                if (listaProveedores.Any())
                {
                    // Toma el máximo valor de ID y le suma 1
                    pro.IDProveedor = listaProveedores.Max(p => p.IDProveedor) + 1;
                }
                else
                {
                    // Si no hay elementos, asigna el ID 1
                    pro.IDProveedor = 1;
                }

                // Agrega el nuevo proveedor a la lista
                listaProveedores.Add(pro);
                grabarProveedores(listaProveedores); // Serializa y guarda la lista actualizada
                return RedirectToAction("Index"); // Redirige a la acción Index
            }
            return View(pro); // Retorna la vista con el objeto que se intentó guardar
        }

        // Acción para mostrar el formulario de edición de un proveedor
        public IActionResult Edit(int id)
        {
            var listaProveedores = LeeProveedores(); // Llama al método para leer los proveedores
            var pro = listaProveedores.FirstOrDefault(p => p.IDProveedor == id); // Busca el proveedor por ID
            if (pro == null)
            {
                return NotFound(); // Retorna un 404 si no se encuentra
            }
            return View(pro); // Retorna la vista con el proveedor encontrado
        }

        [HttpPost]
        public IActionResult Edit(Proveedor pro) // Recibe el proveedor modificado
        {
            if (ModelState.IsValid)
            {
                var listaProveedores = LeeProveedores(); // Obtiene la lista actual de proveedores

                // Obtener el índice del elemento en la lista por ID
                var index = listaProveedores.FindIndex(p => p.IDProveedor == pro.IDProveedor);
                if (index != -1) // Si se encuentra el proveedor
                {
                    listaProveedores[index] = pro; // Actualiza el proveedor en la lista
                    grabarProveedores(listaProveedores); // Guarda la lista actualizada
                }

                return RedirectToAction("Index"); // Redirige a la acción Index
            }
            return View(pro); // Retorna la vista con el objeto que se intentó guardar
        }

        // Acción para mostrar la confirmación de eliminación de un proveedor
        public IActionResult Delete(int id)
        {
            var listaProveedores = LeeProveedores();
            var pro = listaProveedores.FirstOrDefault(p => p.IDProveedor == id);
            if (pro == null)
            {
                return NotFound();
            }
            return View(pro);
        }

        [HttpPost, ActionName("Delete")] // Indica que este método corresponde a la acción Delete
        public IActionResult DeleteConfirmado(int id)
        {
            if (ModelState.IsValid)
            {
                var listaProveedores = LeeProveedores().ToList();

                // Busca el proveedor por ID para eliminarlo
                var pro = listaProveedores.FirstOrDefault(p => p.IDProveedor == id);
                if (pro != null)
                {
                    listaProveedores.Remove(pro); // Elimina el proveedor de la lista
                    grabarProveedores(listaProveedores); // Guarda la lista actualizada
                }

                return RedirectToAction("Index"); // Redirige a la acción Index
            }
            return NotFound();
        }

        // Acción para mostrar los detalles de un proveedor
        public IActionResult Details(int id)
        {
            var listaProveedores = LeeProveedores();
            var pro = listaProveedores.FirstOrDefault(p => p.IDProveedor == id);
            if (pro == null)
            {
                return NotFound();
            }
            return View(pro);
        }
    }
}
