using System;
using System.Diagnostics; // Importar la clase Stopwatch
using System.Threading.Tasks; // Importar tareas asincrónicas

class Program
{
    // MÉTODO ASINCRÓNICO: Tarea 1
    static async Task Tarea1()
    {
        await Task.Delay(2000); // Espera de 2 segundos
        Console.WriteLine("Tarea 1 completada"); // Imprimir mensaje al finalizar
    }

    // MÉTODO ASINCRÓNICO: Tarea 2
    static async Task Tarea2()
    {
        await Task.Delay(2000); // Espera de 2 segundos
        Console.WriteLine("Tarea 2 completada"); // Imprimir mensaje al finalizar
    }

    // MÉTODO ASINCRÓNICO: Ejecutar ambas tareas en paralelo
    static async Task Ejecutar()
    {
        Task t1 = Tarea1(); // Iniciar Tarea1 sin esperar a que termine
        Task t2 = Tarea2(); // Iniciar Tarea2 sin esperar a que termine
        await Task.WhenAll(t1, t2); // Esperar a que ambas tareas finalicen
    }

    // MÉTODO PRINCIPAL
    static async Task Main(string[] args)
    {
        Stopwatch sw = new(); // Crear instancia de Stopwatch
        sw.Start(); // Iniciar el cronómetro

        await Ejecutar(); // Ejecutar las tareas asincrónicas

        sw.Stop(); // Detener el cronómetro
        Console.WriteLine($"Tiempo total de ejecución: {sw.ElapsedMilliseconds} ms"); // Mostrar tiempo transcurrido
    }
}
