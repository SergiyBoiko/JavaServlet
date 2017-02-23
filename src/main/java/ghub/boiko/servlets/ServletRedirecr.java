package ghub.boiko.servlets;

import ghub.boiko.beans.CartDropDownOptionsBean;
import ghub.boiko.beans.CartMessageBean;
import ghub.boiko.beans.CartNameBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        CartNameBean cartNameBean = CartNameBean.get(session);
            for(String value : request.getParameterValues("name")) {
                if (!value.trim().isEmpty()) {
                    cartNameBean.addName(value.trim());
                }
            }
        CartMessageBean cartMessageBean = CartMessageBean.get(session);
        for(String value : request.getParameterValues("message")) {
            if (!value.trim().isEmpty()) {
                cartMessageBean.addMessage(value.trim());
            }
        }

        CartDropDownOptionsBean cartDropDownOptionsBean = CartDropDownOptionsBean.get(session);
        for(String value : request.getParameterValues("dropdownoptions")) {
            if (!value.trim().isEmpty()) {
                cartDropDownOptionsBean.addDropDownOptions(value.trim());
            }
        }


        response.sendRedirect("/index.jsp");
    }

//    private <T> void cartClassCartBean(T nameBean, HttpServletRequest request, String attribute){
//        HttpSession session = request.getSession(true);
//        nameBean = T.get(session);
//        for(String value : request.getParameterValues("name")) {
//            if (!value.trim().isEmpty()) {
//                cartNameBean.addName(value.trim());
//            }
//        }
//    }

}
