import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Company extends HttpServlet {
	public void service(HttpServletRequest request
    , HttpServletResponse response) throws IOException, ServletException {
    
    	OutputStream os = response.getOutputStream();  //response : HttpServletResponse 객체
    PrintStream out = new PrintStream(os,true);
    out.println("Hello, Servlet~");
    }
}
