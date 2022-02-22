
public class Booking {
	
	protected String name;

	public Booking(String name, String hotel, String roomnumber, String startdate, String enddate) {
		super();
		this.name = name;
		this.hotel = hotel;
		this.roomnumber = roomnumber;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	protected String hotel;
	protected String roomnumber;
	protected String startdate;
	protected String enddate;

}
