import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public View() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
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
		Connection con=Save.connect();
		Statement smt = null;
		ResultSet rs=null;
		if(con==null)
			out.print("Connection Error");
		
		try {
			 smt=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title=null;
		String body=null;
		try {
		rs=smt.executeQuery("SELECT * FROM blogs where id="+id);
		if(rs.next()) {
		title=rs.getString(2);
		body=rs.getString(3);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		out.print("<div class='container'>"
				+ "<h4>"+title+"</h4>"
				+ "<p>"+body+"</p>");
		out.print("</div>");
		out.print(" <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"\r\n"
				+ "        integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\r\n"
				+ "        crossorigin=\"anonymous\"></script>\r\n"
				+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "        integrity=\"sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx\"\r\n"
				+ "        crossorigin=\"anonymous\"></script>\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>");
	}

	

}
