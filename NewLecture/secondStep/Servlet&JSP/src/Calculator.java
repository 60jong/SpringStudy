import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/calculator")
public class Calculator extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String exp = "";

        Cookie[] cookies = request.getCookies();
        if(cookies != null)
            for (Cookie c : cookies) {
                if (c.getName().equals("exp"))
                    exp = c.getValue();
                break;
            }


        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("        <title>Calc</title>");
        out.println("        <style>");
        out.println("            input{");
        out.println("                width: 50px;");
        out.println("                height: 50px;");
        out.println("            }");
        out.println("            .output{");
        out.println("                height: 50px;");
        out.println("                font-size: 24px;");
        out.println("                font-weight: bold;");
        out.println("                background: gray;");
        out.println("                text-align: right;");
        out.println("                padding-right: 5px;");
        out.println("            }");
        out.println("        </style>");
        out.println("     </head>");
        out.println("     <body>");
        out.println("      <form action=\"calc\" method=\"post\">");
        out.println("        <table>");
        out.println("            <tr>");
        out.printf("               <td class=\"output\" colspan=\"4\">%s</td>\n",exp);
        out.println("            </tr>");
        out.println("            <tr>");
        out.println("                <td><input type=\"submit\" name=\"operator\" value=\"CE\"/></td>");
        out.println("                <td><input type=\"submit\" name=\"operator\" value=\"C\"/></td>");
        out.println("                <td><input type=\"submit\" name=\"operator\" value=\"≪\"/></td>");
        out.println("                <td><input type=\"submit\" name=\"operator\" value=\"/\"/></td>");
        out.println("            </tr>");
        out.println("            <tr>");
        out.println("                <td><input type=\"submit\" name=\"value\" value=\"7\"/></td>");
        out.println("                <td><input type=\"submit\" name=\"value\" value=\"8\"/></td>");
        out.println("                <td><input type=\"submit\" name=\"value\" value=\"9\"/></td>");
        out.println("                <td><input type=\"submit\" name=\"operator\" value=\"*\"/></td>");
        out.println("            </tr>");
        out.println("            <tr>");
        out.println("                <td><input type=\"submit\" name=\"value\" value=\"4\"/></td>");
        out.println("                <td><input type=\"submit\" name=\"value\" value=\"5\"/></td>");
        out.println("                <td><input type=\"submit\" name=\"value\" value=\"6\"/></td>");
        out.println("                <td><input type=\"submit\" name=\"operator\" value=\"-\"/></td>");
        out.println("            </tr>");
        out.println("            <tr>");
        out.println("                <td><input type=\"submit\" name=\"value\" value=\"1\"/></td>");
        out.println("                <td><input type=\"submit\" name=\"value\" value=\"2\"/></td>");
        out.println("                <td><input type=\"submit\" name=\"value\" value=\"3\"/></td>");
        out.println("               <td><input type=\"submit\" name=\"operator\" value=\"+\"/></td>");
        out.println("            </tr>");
        out.println("            <tr>");
        out.println("                <td><input type=\"submit\" name=\"operator\" value=\"±\"/></td>");
        out.println("                <td><input type=\"submit\" name=\"value\" value=\"0\"/></td>");
        out.println("                <td><input type=\"submit\" name=\"dot\" value=\".\"/></td>");
        out.println("                <td><input type=\"submit\" name=\"operator\" value=\"=\"/></td>");
        out.println("            </tr>");
        out.println("        </table>");
        out.println("      </form>");
        out.println("    </body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        String value = request.getParameter("value");
        String operator = request.getParameter("operator");
        String dot = request.getParameter("dot");

        String exp = "";

        if(cookies != null)
            for (Cookie c : cookies) {
                if(c.getName().equals("exp"))
                    exp = c.getValue();
                break;
            }

        if (operator != null && operator.equals("=")) {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            try {
                exp = String.valueOf(engine.eval(exp));
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        } else {
            exp += (value!=null) ? value : "";
            exp += (operator!=null) ? operator : "";
            exp += (dot!=null) ? dot : "";
        }

        Cookie expCookie = new Cookie("exp", exp);

        response.addCookie(expCookie);
        response.sendRedirect("calculator");
    }
}
