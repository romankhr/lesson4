package ua.lviv.lgs.lesson4.servlet;

import ua.lviv.lgs.lesson4.DataStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/chooseJournal")
public class UserChooseJournal  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("id");
        DataStore.getJournals().stream()
                .filter(user ->  user.getName().equalsIgnoreCase(name))
                .findAny()
                .ifPresent(DataStore.getChosenJournals()::add);

        resp.sendRedirect(req.getContextPath() + "/user");
    }
}