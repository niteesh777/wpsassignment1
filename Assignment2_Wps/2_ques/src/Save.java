import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Save() {
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
//		ResultSet rs=null;
		
		PrintWriter out=response.getWriter();
		 
		String id=request.getParameter("title");
		String body=request.getParameter("body");
		if(con==null)
			out.print("Connection Error");
		
		try {
			 smt=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			smt.execute("INSERT INTO blogs(title,body) VALUES('"+id+"','"+body+"')");
			out.print("inserted");
			response.sendRedirect("home");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	

}
