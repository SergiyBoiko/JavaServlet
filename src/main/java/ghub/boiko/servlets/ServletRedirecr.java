package ghub.boiko.servlets;

import ghub.boiko.cart.CartDropDownOption;
import ghub.boiko.cart.CartMessage;
import ghub.boiko.cart.CartName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ServletRedirecr extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        CartName cartName = CartName.get(session);
            for(String value : request.getParameterValues("name")) {
                if (!value.trim().isEmpty()) {
                    cartName.addName(value.trim());
                }
            }
        CartMessage cartMessage = CartMessage.get(session);
            for(String value : request.getParameterValues("message")) {
                if (!value.trim().isEmpty()) {
                    cartMessage.addMessage(value.trim());
                }
            }

        CartDropDownOption cartDropDownOption = CartDropDownOption.get(session);
            for(String value : request.getParameterValues("dropdownoption")) {
                if (!value.trim().isEmpty()) {
                    cartDropDownOption.addDropDownOption(value.trim());
                }
            }

        response.sendRedirect("/index.jsp");
    }
}
