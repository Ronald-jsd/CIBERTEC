using Microsoft.EntityFrameworkCore;
using WebApplication1.Datos;

var builder = WebApplication.CreateBuilder(args);

//AQUI CONFIGURAMOS LA CONEXION  AL SERVIDOR LOCAL DE SQL SERVER
builder.Services.AddDbContext<AplicacionDbContext>(  //va nuestra clase DbContext
    op => op.UseSqlServer(builder.
    Configuration.GetConnectionString("cnx")));



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
    pattern: "{controller=Empleado}/{action=Index}/{id?}");

app.Run();
