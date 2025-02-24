using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Options;
using WebDropDownDescendentes.Models;


namespace WebDropDownDescendentes.DbContext

{
    public class AplicacionDbContext : DbContext
    {
        public AplicacionDbContext(DbContextOptions<AplicacionDbContext> options)<AplicacionDbContext> Options) : base(options){}

        //aqui van las clase del modelo
    public DbSet <Provincia> Provincia {  get; set; }
    public DbSet<Provincia> Provincia { get; set; }

}
}
