package it.academy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("<dev>");
        writer.println("<ul>");
        writer.println("<li><a href=\"http://localhost:8080/carsServlet_war/car?vin=1\">BMW</a></li>");
        writer.println("<li><a href=\"http://localhost:8080/carsServlet_war/car?vin=2\">Volvo</a></li>");
        writer.println("<li><a href=\"http://localhost:8080/carsServlet_war/car?vin=3\">SAAB</a></li>");
        writer.println("</ul>");
        writer.println("</dev>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
