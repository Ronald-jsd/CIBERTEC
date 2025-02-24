namespace WebApplication3.Models
{
    public class Practicante:Colaborador
    {

        public override string GenerarID()
        {
            string codigoID = "P"
                + ApellidoPaterno
                + ApellidoMaterno.Substring(0, 1)
                + Sexo
                + DNI.Substring(DNI.Length - 3);

            return codigoID.ToUpper();
        }


    }
}
