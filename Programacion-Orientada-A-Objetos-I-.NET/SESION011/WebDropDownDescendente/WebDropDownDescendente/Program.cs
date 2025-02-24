using Microsoft.EntityFrameworkCore;
using WebDropDownDescendente.Datos;

var builder = WebApplication.CreateBuilder(args);

//Configuran la conexion al servidor LOCAL DE SQL SERVER
builder.Services.AddDbContext<AplicacionDbContext>(
    op => op.UseSqlServer(
        builder.Configuration.GetConnectionString("cnx")));          

/*-----------------*/


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
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();
