
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	private String jdbcURL = "jdbc:mysql://localhost:3306/hotelbooking";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	private static final String INSERT_BOOKINGS_SQL = "INSERT INTO HotelBooking"
			+ " (name, hotel, roomnumber, startdate, enddate) VALUES " + " (?, ?, ?, ?);";
	private static final String SELECT_BOOKING_BY_ID = "select name, hotel, roomnumber, startdate, enddate from HotelBooking where name =?";
	private static final String SELECT_ALL_BOOKINGS = "select * from HotelBooking ";
	private static final String DELETE_BOOKINGS_SQL = "delete from HotelBooking where name = ?;";
	private static final String UPDATE_BOOKINGS_SQL = "update UserDetails set name = ?,hotel= ?, roomnumber =?,startdate =?,enddate =? where name = ?;";

	public BookingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	private void listBookings(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
			{
			List <Booking> bookings = new ArrayList <>();
			 try (Connection connection = getConnection();
					 
					 PreparedStatement preparedStatement =
							 connection.prepareStatement(SELECT_ALL_BOOKINGS);) {
				 ResultSet rs = preparedStatement.executeQuery();
				 
				 while (rs.next()) {
					 String name = rs.getString("name");
					 String hotel = rs.getString("hotel");
					 String roomnumber = rs.getString("roomnumber");
					 String startdate = rs.getString("startdate");
					 String enddate = rs.getString("enddate");
					 bookings.add(new Booking(name, hotel, roomnumber, startdate, enddate));
					 }
					 } catch (SQLException e) {
					 System.out.println(e.getMessage());
					 }
			 request.setAttribute("listBookings", bookings);
			 request.getRequestDispatcher("/bookingManagement.jsp").forward(request, response);
			 }
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		try {
			switch (action) {
			case "/insert":
				break;
			case "/delete":
				break;
			case "/edit":
				break;
			case "/update":
				break;
			default:
				listBookings(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
