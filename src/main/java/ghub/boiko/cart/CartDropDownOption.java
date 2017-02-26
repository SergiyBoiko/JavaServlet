package ghub.boiko.cart;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CartDropDownOption {
    private List<String> dropDownOptions = new ArrayList<String>();

    public synchronized void addDropDownOption(String dropDownOption) {
        dropDownOptions.add(dropDownOption);
    }

    public synchronized List<String> getDropDownOption() {
        return dropDownOptions;
    }

    public static CartDropDownOption get(HttpSession session) {
        CartDropDownOption cartDropDownOption = (CartDropDownOption) session.getAttribute("cartDropDownOption");
        if (cartDropDownOption == null) {
            cartDropDownOption = new CartDropDownOption();
            session.setAttribute("cartDropDownOption", cartDropDownOption);
        }

        return cartDropDownOption;
    }
}
