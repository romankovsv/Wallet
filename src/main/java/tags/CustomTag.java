package tags;

import database.currency.Currency;
import database.type.Type;
import database.type_currency.TypeCurrency;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class CustomTag extends SimpleTagSupport {
    private List<Type> types;
    private List<TypeCurrency> sc;
    private List<Currency> currency;

    @Override
    public void doTag() throws JspException, IOException {
        JspContext jspContext = getJspContext();
        JspWriter jspWriter = jspContext.getOut();
        for (Type s : types) {
            for (TypeCurrency sc : this.sc) {
                for (Currency c : currency) {
                    if (s.getId() == sc.getTypeId() && c.getId() == sc.getCurrencyId()) {
                        jspWriter.println("<tr style=\"border: 2px solid #ccc\">");
                        jspWriter.println("<td>" + s.getName() + "</td>");
                        jspWriter.println("<td>" + c.getName() + "</td>");
                        jspWriter.println("<td>");
                        jspWriter.println("<button>");
                        jspWriter.println("<a href=\"new-wallet/create?type=" + s.getId() +
                                "&currency=" + c.getId() + "\">Create</a>");
                        jspWriter.println("</button>");
                        jspWriter.println("</td>");
                        jspWriter.println("</tr>");

                    }
                }
            }
        }
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public List<TypeCurrency> getSc() {
        return sc;
    }

    public void setSc(List<TypeCurrency> sc) {
        this.sc = sc;
    }

    public List<Currency> getCurrency() {
        return currency;
    }

    public void setCurrency(List<Currency> currency) {
        this.currency = currency;
    }
}