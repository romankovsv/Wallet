package tags;

import database.currency.Currency;
import database.system.SystemType;
import database.system_currency.SystemCurrency;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;
/**
 * Created by SpiritMoon
 */
public class CustomTag extends SimpleTagSupport {
    private List<SystemType> types;
    private List<SystemCurrency> sc;
    private List<Currency> currency;

    @Override
    public void doTag() throws JspException, IOException {
        JspContext jspContext = getJspContext();
        JspWriter jspWriter = jspContext.getOut();
        for (SystemType s : types) {
            for (SystemCurrency sc : this.sc) {
                for (Currency c : currency) {
                    if (s.getId() == sc.getSystemId() && c.getId() == sc.getCurrencyId()) {
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

    public List<SystemType> getTypes() {
        return types;
    }

    public void setTypes(List<SystemType> types) {
        this.types = types;
    }

    public List<SystemCurrency> getSc() {
        return sc;
    }

    public void setSc(List<SystemCurrency> sc) {
        this.sc = sc;
    }

    public List<Currency> getCurrency() {
        return currency;
    }

    public void setCurrency(List<Currency> currency) {
        this.currency = currency;
    }
}
