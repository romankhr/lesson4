package ua.lviv.lgs.lesson4.servlet;

import ua.lviv.lgs.lesson4.DataStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/removeChosenJournal")
public class UserRevoveChosenJournal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("id");
        DataStore.getChosenJournals().stream()
                .filter(user ->  user.getName().equalsIgnoreCase(name))
                .findAny()
                .ifPresent(DataStore.getChosenJournals()::remove);

        resp.sendRedirect(req.getContextPath() + "/user");
    }
}