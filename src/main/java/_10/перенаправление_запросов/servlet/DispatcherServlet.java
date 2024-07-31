package _10.перенаправление_запросов.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/flights");  // перенаправляем запрос на URL /flights из практического задания

        req.setAttribute("message", "Hello, dispatcher!"); // добавляем атрибут в запрос, чтобы потом можно было получить его из практического задания

        requestDispatcher.forward(req, resp); // метод перенаправления, который перенаправляет те же данные, что и в практическом задании




        System.out.println(req.getAttribute("message"));
    }
}
