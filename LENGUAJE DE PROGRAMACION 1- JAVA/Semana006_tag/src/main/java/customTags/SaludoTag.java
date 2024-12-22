package customTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SaludoTag extends TagSupport{
	private String name;

    // Setter para el atributo del tag
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            // Imprime el saludo personalizado
            pageContext.getOut().write("¡Hola, " + name + "! Ya puedes registrar a tus usuarios");
        } catch (Exception e) {
            throw new JspException("Error al generar el saludo", e);
        }
        return SKIP_BODY; // No procesa el cuerpo de la etiqueta
    }
}
