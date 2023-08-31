package it.academy.controller;

import it.academy.model.entity.User;
import it.academy.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = req.getReader().lines().collect(Collectors.joining());
        String[] parameters = body.split("&");
        String login = parameters[0].substring(parameters[0].indexOf("=") + 1);
        String password = parameters[1].substring(parameters[1].indexOf("=") + 1);
        LoginService loginService = new LoginService();
        PrintWriter printWriter = resp.getWriter();

        printWriter.println("<html>");
        printWriter.println("<body>");

        if (loginService.checkCredentials(login, password)) {
            HttpSession httpSession = req.getSession();
            User user = new User(login, password);
            httpSession.setAttribute("user", user);

            resp.sendRedirect("/cars");

        } else {
            printWriter.println("Try to login again!");
            printWriter.println("<br>");
            printWriter.println("<a href=\"/login\">Login</a>");
        }

        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}
