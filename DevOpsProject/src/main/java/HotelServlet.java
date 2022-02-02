
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HotelServlet
 */
@WebServlet("/HotelServlet")
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HotelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String jdbcURL = "jdbc:mysql://localhost:3306/hoteldetails";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	private static final String INSERT_HOTELS_SQL = "INSERT INTO HotelDetails"
			+ " (name, address, pricing, star, image) VALUES " + " (?, ?, ?, ?);";
	private static final String SELECT_HOTEL_BY_ID = "select name,address,pricing,star,image from HotelDetails where name =?";
	private static final String SELECT_ALL_HOTELS = "select * from HotelDetails ";
	private static final String DELETE_HOTELS_SQL = "delete from HotelDetails where name = ?;";
	private static final String UPDATE_HOTELS_SQL = "update HotelDetails set name = ?, address= ?, star = ?, pricing = ?, image =? where name = ?;";

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
				listHotels(request, response);
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

	private void listHotels(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Hotel> hotels = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOTELS);) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				String star = rs.getString("star");
				String pricing = rs.getString("pricing");
				String image = rs.getString("image");

				hotels.add(new Hotel(name, address, star, pricing, image));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("listHotels", hotels);
		request.getRequestDispatcher("/hotelManagement.jsp").forward(request, response);
	}

}
