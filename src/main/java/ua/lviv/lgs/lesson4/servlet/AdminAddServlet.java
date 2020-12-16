package ua.lviv.lgs.lesson4.servlet;

import ua.lviv.lgs.lesson4.DataStore;
import ua.lviv.lgs.lesson4.dao.Journal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/add")
public class AdminAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String name=request.getParameter("name");
         String publication=request.getParameter("publication");
         Integer year=Integer.parseInt(request.getParameter("year"));
         Integer month=Integer.parseInt(request.getParameter("month"));
         Integer price=Integer.parseInt(request.getParameter("price"));

         DataStore.getJournals().add(new Journal(name, publication, year, month, price));

        request.setAttribute(Attribute.REQUEST_JOURNALS.getValue(), DataStore.getJournals());
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

}

