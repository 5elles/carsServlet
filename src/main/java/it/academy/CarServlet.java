package it.academy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet("/car")
public class CarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();


        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("<dev>");
//        if (httpSession.getAttribute("user") != null) {
            String vin = req.getParameter("vin");

            Map<String, String> carsMap = new HashMap<>();
            carsMap.put("1", "<html>\n<body>\nThis is BMW\n</body>\n</html>");
            carsMap.put("2", "<html>\n<body>\nThis is Volvo\n</body>\n</html>");
            carsMap.put("3", "<html>\n<body>\nThis is SAAB\n</body>\n</html>");
            for (Map.Entry<String, String> entry :
                    carsMap.entrySet()) {
                if (Objects.equals(entry.getKey(), vin)) writer.println(entry.getValue());
            }
//        } else {
//            writer.println("Please, login!");
//        }
        writer.println("</dev>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
