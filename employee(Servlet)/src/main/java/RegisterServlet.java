import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
	Connection con;
	// Database connectivity (use Lifecycle method init())
	public void init(ServletConfig config) {
		String driver = config.getInitParameter("driver");
		String url = config.getInitParameter("url");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		// To get the values from the form which refers this Servlet
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			PreparedStatement st = con.prepareStatement("insert into users values ('"+name+"','"+username+"','"+password+"')");

			/* For replace the java variable at a place of the value inside the table
				we use " " inside ' ' 
			*/
			
			st.executeUpdate();
			out.println("Registered Sucessfully<br>");
			out.println("Click <a href=\"/employee(Servlet)/login.jsp\">here</a>");
		} catch (Exception e) {
			out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	// Closing the database connectivity (use Lifecycle method destroy())
	public void destroy() {
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
