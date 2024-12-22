package customTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class FooterTag extends TagSupport {
    private String autor;
    private String correo;
    private String direccion;

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write(" Autor: " + autor + "*");
            pageContext.getOut().write(" Correo: " + correo + "*");
            pageContext.getOut().write(" Direccion: " + direccion + "*");
        } catch (Exception e) {
            throw new JspException("Error al generar el saludo", e);
        }
        return SKIP_BODY;
    }
}
