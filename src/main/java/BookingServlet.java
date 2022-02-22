
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
	public BookingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String jdbcURL = "jdbc:mysql://localhost:3306/hotelbooking";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	private static final String INSERT_BOOKINGS_SQL = "INSERT INTO HotelBooking"
			+ " (name, hotel, roomnumber, startdate, enddate) VALUES " + " (?, ?, ?, ?);";
	private static final String SELECT_BOOKING_BY_ID = "select name, hotel, roomnumber, startdate, enddate from HotelBooking where name =?";
	private static final String SELECT_ALL_BOOKINGS = "select * from HotelBooking ";
	private static final String DELETE_BOOKINGS_SQL = "delete from HotelBooking where name = ?;";
	private static final String UPDATE_BOOKINGS_SQL = "update HotelBooking set name = ?,hotel= ?, roomnumber =?,startdate =?,enddate =? where name = ?;";

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
			throws SQLException, IOException, ServletException {
		List<Booking> bookings = new ArrayList<>();
		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKINGS);) {
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
			case "/BookingServlet/edit":
				showEditForm(request, response);
				break;
			case "/BookingServlet/update":
				updateBooking(request, response);
				break;
			case "/BookingServlet/delete":
				deleteBooking(request, response);
				break;
			case "/BookingServlet/dashboard":

				listBookings(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String name = request.getParameter("name");

		Booking existingBooking = new Booking("", "", "", "", "");

		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKING_BY_ID);) {
			preparedStatement.setString(1, name);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				name = rs.getString("name");
				String hotel = rs.getString("hotel");
				String roomnumber = rs.getString("roomnumber");
				String startdate = rs.getString("startdate");
				String enddate = rs.getString("enddate");
				existingBooking = new Booking(name, hotel, roomnumber, startdate, enddate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("booking", existingBooking);
		request.getRequestDispatcher("/bookingEdit.jsp").forward(request, response);
		// TODO Auto-generated method stub

	}

	private void updateBooking(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String oriName = request.getParameter("oriName");
		String name = request.getParameter("name");
		String hotel = request.getParameter("hotel");
		String roomnumber = request.getParameter("roomnumber");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");

		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKINGS_SQL);) {
			statement.setString(1, name);
			statement.setString(2, hotel);
			statement.setString(3, roomnumber);
			statement.setString(4, startdate);
			statement.setString(5, enddate);
			statement.setString(6, oriName);
			int i = statement.executeUpdate();
		}
		response.sendRedirect("http://localhost:8090/DevOpsProject/BookingServlet/dashboard");
	}

	private void deleteBooking(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String name = request.getParameter("name");

		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_BOOKINGS_SQL);) {
			statement.setString(1, name);
			int i = statement.executeUpdate();
		}
		response.sendRedirect("http://localhost:8090/DevOpsProject/BookingServlet/dashboard");

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
