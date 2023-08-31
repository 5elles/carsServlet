package it.academy.controller;

import it.academy.model.entity.Car;
import it.academy.model.entity.User;
import it.academy.model.repository.CarRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> carList = CarRepository.getInstance().getCars();
        PrintWriter writer = resp.getWriter();
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");

        writer.println("<html>");
        writer.println("<body>");
        writer.println("<dev>");
        writer.print("User: ");
        writer.println("<b>" + user.getLogin() + "</b>");
        writer.println("<p>");
        writer.println("List of cars: ");
        writer.println("<ul>");
        for (Car car: carList) {
            String vin = car.getVin();
            String brand = car.getBrand();
            writer.printf("<li><a href=\"/car?vin=%s\">%s</a></li>%n", vin, brand);
        }
        writer.println("</ul>");
        writer.println("</p>");

        writer.println("</dev>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
