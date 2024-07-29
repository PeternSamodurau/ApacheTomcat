package _1.servletHeaders;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("____________________________");
        String userAgent =  req.getHeader("user-agent");
        System.out.println("User-Agent: " + userAgent);

        System.out.println("____________________________");

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
        String header = headerNames.nextElement();
            System.out.println(header + ": " + req.getHeader(header));
        }

        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setHeader("token", "12345");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Hello from first servlet!</h1>");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
