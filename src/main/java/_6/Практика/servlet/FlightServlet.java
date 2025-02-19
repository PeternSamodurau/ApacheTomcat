package _6.Практика.servlet;

import _6.Практика.service.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");         //выводим в браузер страницу html
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<h1>Список перелетов : </>");
            printWriter.write("<ul>");
            flightService.findAll().forEach(flightDto -> {
            printWriter.write("""
                    <li>
                    <a href="/tickets?flightId=%d">%s</a>
                    </li>
                    """.formatted(flightDto.getId(), flightDto.getDescription()));
            });
            printWriter.write("</ul>");
        }
    }
}
