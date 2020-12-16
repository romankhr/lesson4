package ua.lviv.lgs.lesson4.servlet;

import ua.lviv.lgs.lesson4.DataStore;
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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object userAttribute = session.getAttribute(Attribute.SESSION_USER_KEY.getValue());

        if (!Objects.isNull(userAttribute)) {
            redirectUserToHomePage((User) userAttribute, req, resp);
            return;
        }

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("pass");

        Optional<User> registeredUser = DataStore.getUser(email, password);

        if (!registeredUser.isPresent()) {
            req.setAttribute(Attribute.REQUEST_LOGIN_ERROR.getValue(), "Login or password are invalid.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }

        User user = registeredUser.get();

        HttpSession session = req.getSession();
        session.setAttribute(Attribute.SESSION_USER_KEY.getValue(), user);

        req.setAttribute(Attribute.REQUEST_USER_NAME_KEY.getValue(), user.getFirstName() + " " + user.getLastName());

        redirectUserToHomePage(user, req, resp);
    }

    private void redirectUserToHomePage(User user, HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        switch (user.getRole()) {
            case USER: resp.sendRedirect(req.getContextPath() + "/user");
            case ADMIN: resp.sendRedirect(req.getContextPath() + "/admin");
        }
    }
}
