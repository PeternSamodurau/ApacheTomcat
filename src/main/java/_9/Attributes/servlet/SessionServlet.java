package _9.Attributes.servlet;

import _9.Attributes.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

// Attribute нужен для хранения данных в сессии.

@WebServlet("/session1")
public class SessionServlet extends HttpServlet {

    private static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println(session.isNew() ? "new" : "old");
        System.out.println("___________________________");

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            System.out.println(header + ": " + req.getHeader(header));
        }
        System.out.println("___________________________");

        UserDto userDto = (UserDto) session.getAttribute(USER);
        System.out.println(userDto);
        System.out.println("___________________________");

        if (userDto == null) {
            userDto = UserDto.builder().id(25L).name("Vasya").email("a@a.ru").build();
            session.setAttribute(USER, userDto);
        }
        System.out.println(session.getAttribute(USER));     // без создания нового объекта UserDto

        System.out.println("___________________________");

        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.getWriter().write(String.format("Hello, %s, %s", userDto.getName(), userDto.getEmail()));
    }
}
