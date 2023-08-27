package it.academy;

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
        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("<form action=\"/carsServlet_war/login\" method=\"post\">");
        writer.println("<label>Login: </label>");
        writer.println("<input name=\"login\">");
        writer.println("<br>");
        writer.println("<label>Password: </label>");
        writer.println("<input name=\"password\">");
        writer.println("<br>");
        writer.println("<input type=\"submit\">");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
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

            printWriter.printf("User %s is logged in", login);
            printWriter.println("<br>");
            printWriter.println("<a href=\"/carsServlet_war/cars\">Car brands</a>");
        } else {
            printWriter.println("Try to login again!");
            printWriter.println("<br>");
            printWriter.println("<a href=\"/carsServlet_war/login\">Login</a>");
        }

        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}
