import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Preview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Preview() {
        super();
    }
    public static Connection connect() {
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			return con;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title=request.getParameter("title");
		String body=request.getParameter("body");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.print("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\"\r\n"
				+ "        integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>"
				+ "<br><br>");
	
		out.print("<div class='container'>"
				+ "<h4>"+title+"</h4>"
				+ "<p>"+body+"</p>");
						
		
		out.print("<form action='save' method='post'>"
				+ "<input type='hidden' name='title' value='"+title+"'>\r\n"
				+ "<input type='hidden' name='body' value='"+body+"'>"
				+ "<input type='checkbox' name='confirm' required> Are u sure that u want to save this blog"
				+ "<br><br>"
				+ "<button class='btn btn-primary' type='submit'>Save Blog</button>"
				+ "</form>"
				+ "</div>");
		out.print(" <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"\r\n"
				+ "        integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\r\n"
				+ "        crossorigin=\"anonymous\"></script>\r\n"
				+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "        integrity=\"sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx\"\r\n"
				+ "        crossorigin=\"anonymous\"></script>\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	

}
