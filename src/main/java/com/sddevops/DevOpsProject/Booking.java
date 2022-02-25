package com.sddevops.DevOpsProject;

import java.util.Comparator;
import java.util.Objects;

public class Booking {
	private String name;
	private String hotel;
	private String roomnumber;
	private String startdate;
	private String enddate;
	
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

	@Override
	public int hashCode() {
		return Objects.hash(name, hotel, roomnumber, startdate, enddate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Booking))
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(roomnumber, other.roomnumber) && Objects.equals(name, other.name) && Objects.equals(startdate, other.startdate)
				&& Objects.equals(enddate, other.enddate)
				&& Objects.equals(hotel, other.hotel);
	}
	public static Comparator<Booking> nameComparator = new Comparator<Booking>() {
		@Override
		public int compare(Booking s1, Booking s2) {
			return (int) (s1.getName().compareTo(s2.getName()));
		}
	};
	
}