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
import java.util.Optional;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object userAttribute = session.getAttribute(Attribute.SESSION_USER_KEY.getValue());

        if (!Objects.isNull(userAttribute)) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        req.setAttribute(Attribute.REQUEST_JOURNALS.getValue(), DataStore.getJournals());
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fistName = req.getParameter("fistName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("pass");

        Optional<User> registeredUser = DataStore.getUser(email);

        if (registeredUser.isPresent()) {
            req.setAttribute(Attribute.REQUEST_REGISTRATION_ERROR.getValue(), "Such user already exists.");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        User user = new User(fistName, lastName, email, password, Role.USER);

        DataStore.getUsers().add(user);

        HttpSession session = req.getSession();
        session.setAttribute(Attribute.SESSION_USER_KEY.getValue(), user);

        resp.sendRedirect(req.getContextPath() + "/user");
    }

}

