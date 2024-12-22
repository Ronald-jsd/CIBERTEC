package customTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

// Clase personalizada para la etiqueta <currentDate>
public class DateTag extends TagSupport {

	private String formatoFecha = "dd-MM-yyyy";
	
	public void setFormat(String format) {
		this.formatoFecha = formatoFecha;
	}
	
    // Método que se ejecuta al inicio de la etiqueta
    @Override
    public int doStartTag() throws JspException {
        try {
            // Formatear la fecha actual
            SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);//("dd/MM/yyyy");

            String currentDate = sdf.format(new Date());

            // Escribir la fecha actual en la página JSP
            pageContext.getOut().write("Fecha actual: " + currentDate);
        } catch (Exception e) {
            throw new JspException("Error al generar la fecha actual", e);
        }
        // Indica que el cuerpo de la etiqueta debe ser omitido
        return SKIP_BODY;
    }
}