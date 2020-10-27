import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Base64;


public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Employee() {
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
		Connection con=connect();
		Statement smt = null;
		ResultSet rs=null;
		Blob blob=null;
		PrintWriter out=response.getWriter();
		 
		int id=Integer.parseInt(request.getParameter("id"));
		if(con==null)
			out.print("Connection Error");
		
		try {
			 smt=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs=smt.executeQuery("SELECT * FROM employee where id="+id);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.next();
			response.setContentType("text/html");
			
			
			blob=rs.getBlob(4);
			InputStream inputStream = blob.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			 
			while ((bytesRead = inputStream.read(buffer)) != -1) {
			    outputStream.write(buffer, 0, bytesRead);
			}
			 
			byte[] imageBytes = outputStream.toByteArray();
			 
			String image = Base64.getEncoder().encodeToString(imageBytes);
			 
			inputStream.close();
			outputStream.close();
			
			String name=rs.getString(2);
			Date dob=rs.getDate(3);
			
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
					+ "<body>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "    <table class=\"table table-dark\">\r\n"
					+ "       <tbody>\r\n"
					+ "          <tr>\r\n"
					+ "            <th scope=\"row\">Employee ID</th>\r\n"
					+ "            <td>"+id+"</td>\r\n"
					+ "            \r\n"
					+ "          </tr>\r\n"
					+ "          <tr>\r\n"
					+ "            <th scope=\"row\">Employee Name</th>\r\n"
					+ "            <td>"+name+"</td>\r\n"
					+ "            \r\n"
					+ "          </tr>\r\n"
					+ "          <tr>\r\n"
					+ "            <th scope=\"row\">Date of Birth</th>\r\n"
					+ "            <td>"+dob+"</td>\r\n"
					+ "          </tr>\r\n"
					+ "          <tr>\r\n"
					+ "            <th scope=\"row\">Profile Photo</th>\r\n"
					+ "            <td>"
					+ "<img src='data:image/jpg;base64,"+image+"' width='240' height='300'/>"
					+ "</td>\r\n"
					+ "          </tr>\r\n"
					+ "        </tbody>\r\n"
					+ "      </table>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"\r\n"
					+ "        integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\r\n"
					+ "        crossorigin=\"anonymous\"></script>\r\n"
					+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js\"\r\n"
					+ "        integrity=\"sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx\"\r\n"
					+ "        crossorigin=\"anonymous\"></script>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "\r\n"
					+ "</html>");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			
			rd.include(request, response);
			out.print("<br>"
					+ "<div class='container' style='color:red;text-align:center'>"
					+ "Details not found"
					+ "</div>");
			
		}	
	}
}
