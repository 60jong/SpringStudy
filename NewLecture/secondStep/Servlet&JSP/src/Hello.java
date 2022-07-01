import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/hello")
public class Hello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _num = request.getParameter("num");
        int num = Integer.parseInt(_num);

        String result = "";
        if (num % 2 == 0) {
            result = "짝수";
        } else {
            result = "홀수";
        }

        request.setAttribute("result", result);
        request.setAttribute("list",List.of(1,2,3,4) );
        RequestDispatcher dispatcher = request.getRequestDispatcher("hello.jsp");
        dispatcher.forward(request,response);
    }
}
