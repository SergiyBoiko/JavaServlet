package ghub.boiko.beans;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CartNameBean {
    private List<String> names = new ArrayList<String>();

    public synchronized void addName(String name) {
        names.add(name);
    }

    public synchronized List<String> getName() {
        return new ArrayList<String>(names);
    }

    public static CartNameBean get(HttpSession session) {
        CartNameBean cartNameBean = (CartNameBean) session.getAttribute("name");
        if (cartNameBean == null) {
            cartNameBean = new CartNameBean();
            session.setAttribute("cartNameBean", cartNameBean);
        }

        return cartNameBean;
    }
}
