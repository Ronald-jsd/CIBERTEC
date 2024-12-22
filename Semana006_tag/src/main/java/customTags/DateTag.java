package customTags;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTag extends TagSupport {

    private String format = "dd-MM-yyyy"; // Formato por defecto

    // Setter para permitir que el formato sea modificado desde el JSP
    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            // Obtener la fecha actual
            Date currentDate = new Date();
 
            // Formatear la fecha según el formato especificado
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String formattedDate = sdf.format(currentDate);

            // Escribir la fecha formateada en la salida
            pageContext.getOut().write(formattedDate);
        } catch (IOException e) {
            throw new JspException("Error in DateTag", e);
        }
        return SKIP_BODY; // No necesitamos procesar el cuerpo de la etiqueta
    }
}
