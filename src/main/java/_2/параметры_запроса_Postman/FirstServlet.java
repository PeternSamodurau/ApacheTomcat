package _2.параметры_запроса_Postman;

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
import java.util.Map;

@WebServlet("/second")
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
        System.out.println("____________________________");
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println(parameterMap);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
