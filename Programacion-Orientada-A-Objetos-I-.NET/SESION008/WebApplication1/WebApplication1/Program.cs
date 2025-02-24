using Microsoft.EntityFrameworkCore;
using WebApplication1.DatoContext;

namespace WebApplication1
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            //Configuramos la conexion al servidor LOCAL de SQL SERVER
            builder.Services.AddDbContext<AplicacionDbContext>(op => op.UseSqlServer(builder.Configuration.GetConnectionString("cnx") ));
            
            
            // Add services to the container.
            builder.Services.AddControllersWithViews();

            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (!app.Environment.IsDevelopment())
            {
                app.UseExceptionHandler("/Home/Error");
            }
            app.UseStaticFiles();

            app.UseRouting();

            app.UseAuthorization();

            app.MapControllerRoute(
                name: "default",
                pattern: "{controller=Contacto}/{action=Index}/{id?}");

            app.Run();
        }
    }
}
