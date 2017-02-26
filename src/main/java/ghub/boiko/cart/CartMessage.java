package ghub.boiko.cart;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CartMessage {

    private List<String> messages = new ArrayList<String>();

    public synchronized void addMessage(String message) {
        messages.add(message);
    }

    public synchronized List<String> getMessage() {
        return messages;
    }

    public static CartMessage get(HttpSession session) {
        CartMessage cartMessage = (CartMessage) session.getAttribute("cartMessage");
        if (cartMessage == null) {
            cartMessage = new CartMessage();
            session.setAttribute("cartMessage", cartMessage);
        }

        return cartMessage;
    }
}