package ghub.boiko.beans;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CartMessageBean {

    private List<String> messages = new ArrayList<String>();

    public synchronized void addMessage(String message) {
        messages.add(message);
    }

    public synchronized List<String> getMessage() {
        return new ArrayList<String>(messages);
    }

    public static CartMessageBean get(HttpSession session) {
        CartMessageBean cartMessageBean = (CartMessageBean) session.getAttribute("name");
        if (cartMessageBean == null) {
            cartMessageBean = new CartMessageBean();
            session.setAttribute("cartMessageBean", cartMessageBean);
        }

        return cartMessageBean;
    }
}