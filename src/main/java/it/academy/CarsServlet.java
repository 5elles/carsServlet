package it.academy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("<dev>");

//        if (httpSession.getAttribute("user") != null) {
            writer.println("List: ");
            writer.println("<ul>");
            writer.println("<li><a href=\"/carsServlet_war/car?vin=1\">BMW</a></li>");
            writer.println("<li><a href=\"/carsServlet_war/car?vin=2\">Volvo</a></li>");
            writer.println("<li><a href=\"/carsServlet_war/car?vin=3\">SAAB</a></li>");
            writer.println("</ul>");
//        } else {
//            writer.println("Please, login!");
//        }

        writer.println("</dev>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
