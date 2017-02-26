package ghub.boiko.cart;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CartName {
    private List<String> names = new ArrayList<String>();

    public synchronized void addName(String name) {
        names.add(name);
    }

    public synchronized List<String> getName() {
        return  names;
    }

    public static CartName get(HttpSession session) {
        CartName cartName = (CartName) session.getAttribute("cartName");
        if (cartName == null) {
            cartName = new CartName();
            session.setAttribute("cartName", cartName);
        }

        return cartName;
    }
}
