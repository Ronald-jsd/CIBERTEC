package customTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class DolarTag extends TagSupport {

	private String dolar;

	public void setName(String dolar) {
		this.dolar = dolar;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().write("Hola, " + dolar + " este mensaje es de una etiqueta personalizada de java.");
		} catch (Exception e) {
			throw new JspException("Error al generar saludo");
		}
		return SKIP_BODY;
	}

}
