
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class BookingRegister
 */
@WebServlet("/BookingRegister")
public class BookingRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookingRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		{
			// TODO Auto-generated method stub
			response.setContentType("text/html");

			PrintWriter out = response.getWriter();

			String a = request.getParameter("userName");
			String b = request.getParameter("hotelName");
			String c = request.getParameter("roomNumber");
			String d = request.getParameter("startDate");
			String e = request.getParameter("endDate");

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbooking", "root",
						"password");

				PreparedStatement ps = con.prepareStatement("insert into HOTELBOOKING values(?,?,?,?,?)");

				ps.setString(1, a);
				ps.setString(2, b);
				ps.setString(3, c);
				ps.setString(4, d);
				ps.setString(5, e);

				int i = ps.executeUpdate();

				if (i > 0) {
					PrintWriter writer = response.getWriter();
					writer.println("<h1>" + "You have successfully registered an hotel booking!" + "</h1>");
					writer.close();
				}
			}

			catch (Exception exception) {
				System.out.println(exception);
				out.close();
			}
			doGet(request, response);
		}
	}
}
