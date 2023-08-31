package it.academy.controller;

import it.academy.model.entity.Car;
import it.academy.model.repository.CarRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/car")
public class CarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> carList = CarRepository.getInstance().getCars();
        PrintWriter writer = resp.getWriter();
        String vin = req.getParameter("vin");

        writer.println("<html>");
        writer.println("<body>");
        writer.println("<dev>");

            for (Car car : carList) {
                if (car.getVin().equals(vin)){
                    String carVin = car.getVin();
                    String carBrand = car.getBrand();
                    String carModel = car.getModel();
                    writer.printf("This is %s. %nModel: %s, vin: %s", carBrand, carModel, carVin);
                }
            }

        writer.println("</dev>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
