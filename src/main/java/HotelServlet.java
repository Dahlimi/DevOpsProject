
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
			case "/HotelServlet/delete":
				deleteHotel(request, response);
				break;
			case "/HotelServlet/edit":
				showEditForm(request, response);
				break;
			case "/HotelServlet/update":
				updateHotel(request, response);
				break;
			case "/HotelServlet/dashboard":
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
				String pricing = rs.getString("pricing");
				String star = rs.getString("star");
				String image = rs.getString("image");

				hotels.add(new Hotel(name, address, pricing, star, image));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("listHotels", hotels);
		request.getRequestDispatcher("/hotelManagement.jsp").forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String name = request.getParameter("name");
		Hotel existingHotel = new Hotel("", "", "", "", "");
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOTEL_BY_ID);) {
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				name = rs.getString("name");
				String address = rs.getString("address");
				String pricing = rs.getString("pricing");
				String star = rs.getString("star");
				String image = rs.getString("image");
				existingHotel = new Hotel(name, address, pricing, star, image);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("hotel", existingHotel);
		request.getRequestDispatcher("/hotelEdit.jsp").forward(request, response);
	}
	private void updateHotel(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String oriName = request.getParameter("oriName");
		 String name = request.getParameter("name");
		 String address = request.getParameter("address");
		 String pricing = request.getParameter("pricing");
		 String star = request.getParameter("star");
		 String image = request.getParameter("image");
		 
		 try (Connection connection = getConnection(); PreparedStatement statement =
				 connection.prepareStatement(UPDATE_HOTELS_SQL);) {
				  statement.setString(1, name);
				  statement.setString(2, address);
				  statement.setString(3, pricing);
				  statement.setString(4, star);
				  statement.setString(5, image);
				  statement.setString(6, oriName);
				  int i = statement.executeUpdate();
				  }
		 response.sendRedirect("http://localhost:8090/DevOpsProject/HotelServlet/dashboard");
	}
	
	private void deleteHotel(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("name");
		try (Connection connection = getConnection(); PreparedStatement statement =
				connection.prepareStatement(DELETE_HOTELS_SQL);) {
				 statement.setString(1, name);
				 int i = statement.executeUpdate();
				 }
		response.sendRedirect("http://localhost:8090/DevOpsProject/HotelServlet/dashboard");
	}

	

}
