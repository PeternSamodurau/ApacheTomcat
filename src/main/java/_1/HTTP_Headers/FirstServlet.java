package _1.HTTP_Headers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Enumeration;
// Методы init, doGet, doPost и destroy в сервлете вызываются контейнером сервлетов (например, Tomcat), а не напрямую .
// Вот как это работает:
//
//init: Этот метод вызывается контейнером сервлетов при инициализации сервлета. Это происходит один раз, когда сервлет загружается в память.
//doGet и doPost: Эти методы вызываются контейнером сервлетов каждый раз,
// когда сервер получает соответствующий HTTP-запрос (GET или POST) для данного сервлета.
// Контейнер сервлетов автоматически определяет, какой метод вызывать, основываясь на типе HTTP-запроса.
//destroy: Этот метод вызывается контейнером сервлетов перед тем, как сервлет будет выгружен из памяти.
// Это позволяет сервлету выполнить любые необходимые действия по очистке.
//Контейнер сервлетов управляет жизненным циклом сервлета,
// обеспечивая вызов этих методов в нужное время.
// Это позволяет вам сосредоточиться на логике обработки запросов, не беспокоясь о том, когда и как вызывать эти методы.
@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Стартовая строка
        String method =req.getMethod();
        String uri = req.getRequestURI();
        String protocol = req.getProtocol();
        System.out.println("Стартовая строка: " + method + " " + uri + " " + protocol);
        System.out.println("____________________________");

        // Выводим заголовки
        System.out.println("Заголовки: content-type" + " "+ req.getHeader("content-type")); //В GET-запросах заголовок Content-Type обычно не используется,
        // так как GET-запросы не содержат тела запроса. Поэтому заголовок Content-Type может быть null.
        Enumeration<String> headerNames = req.getHeaderNames();// Enumeration - интерфейс для перечисления значений в коллекции (в данном случае - заголовки)
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            System.out.println("Заголовок: " + header + " " + req.getHeader(header));
        }
        System.out.println("____________________________");

        // Тело запроса - пустое по умолчанию
        StringBuilder body = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            body.append(line).append("\n");
        }
        System.out.println("Тело запроса: " + body.toString());
        System.out.println("____________________________");

        //Отправляем ответ
        resp.setContentType("text/html"); // тип содержимого ответа - html
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setHeader("token", "12345");

        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Hello from first servlet!</h1>");
            writer.write("<p>Стартовая строка ответа: " + protocol + "" + method + " " + uri +" " + resp.getStatus() +"</p>");

            writer.write("<p>Заголовки ответа : " + resp.getContentType() + "</p>");
            Collection<String> headerNames1 = resp.getHeaderNames(); // Получаем заголовки ответа
            for (String header : headerNames1) {
                writer.write("Заголовок ответа: " + header + " " + resp.getHeader(header)); // Используем resp.getHeader(header)
                writer.write("<br>");
            }

            writer.write("<p>Тело ответа: " + body.toString() + "</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String email = req.getParameter("email");

        if (name != null && email != null) {
            resp.getWriter().println("<h1>Данные формы</h1>");
            resp.getWriter().println("<p>Имя: " + name + "</p>");
            resp.getWriter().println("<p>Email: " + email + "</p>");
        } else {
            resp.getWriter().println("<h1>Ошибка: Параметры не найдены</h1>");
        }
    }

    @Override
    public void destroy () {
        super.destroy();
    }
}