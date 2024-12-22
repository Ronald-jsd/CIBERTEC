package customTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SaludoTag extends TagSupport {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().write("Hola, " + name + " este mensaje es de una etiqueta personalizada de java.");
		} catch (Exception e) {
			throw new JspException("Error al generar saludo");
		}
		return SKIP_BODY;
	}

}
