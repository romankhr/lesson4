package ua.lviv.lgs.lesson4.servlet;

import ua.lviv.lgs.lesson4.DataStore;
import ua.lviv.lgs.lesson4.dao.Role;
import ua.lviv.lgs.lesson4.dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object userAttribute = session.getAttribute(Attribute.SESSION_USER_KEY.getValue());

        if (Objects.isNull(userAttribute)) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        req.setAttribute(Attribute.REQUEST_JOURNALS.getValue(), DataStore.getJournals());
        req.setAttribute(Attribute.REQUEST_CHOSEN_JOURNALS.getValue(), DataStore.getChosenJournals());
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }
}
