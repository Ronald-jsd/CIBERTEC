var builder = WebApplication.CreateBuilder(args);

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
        //pattern: "{controller=Solucion}/{action=Index}/{id?}");
        //Cambiamos Home por el nombre de la vista generado:  Solucion 
        pattern: "{controller=Solucion}/{action=IndexGeneral}/{id?}");

app.Run();
