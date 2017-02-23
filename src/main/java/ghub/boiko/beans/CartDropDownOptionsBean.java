package ghub.boiko.beans;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CartDropDownOptionsBean {
    private List<String> dropDownOptions = new ArrayList<String>();

    public synchronized void addDropDownOptions(String dropDownOption) {
        dropDownOptions.add(dropDownOption);
    }

    public synchronized List<String> getDropDownOption() {
        return new ArrayList<String>(dropDownOptions);
    }

    public static CartDropDownOptionsBean get(HttpSession session) {
        CartDropDownOptionsBean cartDropDownOptionsBean = (CartDropDownOptionsBean) session.getAttribute("dropdownoptions");
        if (cartDropDownOptionsBean == null) {
            cartDropDownOptionsBean = new CartDropDownOptionsBean();
            session.setAttribute("dropDownOptions", cartDropDownOptionsBean);
        }

        return cartDropDownOptionsBean;
    }
}
