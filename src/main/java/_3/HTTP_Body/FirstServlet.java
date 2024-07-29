package _3.HTTP_Body;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Stream;

@WebServlet("/third")
public class FirstServlet extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("____________________________");
        String parValue = req.getParameter("param");
        System.out.println(parValue);
        System.out.println("____________________________");
        System.out.println(req.getParameterNames().toString());
        System.out.println("____________________________");

        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println(parameterMap);
        System.out.println("____________________________");

//        resp.setContentType("text/html");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        resp.setHeader("token", "12345");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Hello from first servlet! postman</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (BufferedReader reader = req.getReader();
             Stream<String> lines = reader.lines()){
            lines.forEach(System.out::println);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
