package com.sddevops.DevOpsProject;

import java.util.*;

public class BookingCollection {
	
	 private ArrayList<Booking> bookings = new ArrayList<>();
	    private int capacity;

	    public BookingCollection() {
	    	/*bookings.add(new Booking("Lim Zheng Yang","Hotel 81","69","2022-02-27", "2022-02-28" ));
	    	bookings.add(new Booking("Kwan Gavin","Hotel 81","69","2022-04-27", "2022-07-12"));
	    	bookings.add(new Booking("Ng Zhong Qi","Idk la up to you","123","2022-06-12", "2022-07-12"));
	    	bookings.add(new Booking("Dahlimi Kuryadi Bin Dahlan","MBS","96","2022-06-12", "2022-07-12"));*/

	        this.capacity = 20;
	    }
	    public BookingCollection(int capacity) {
	        this.capacity = capacity;
	    }

	    public List<Booking> getBookings() {
	        return bookings;
	    }

	    public void addBooking(Booking booking) {
	    	if(bookings.size() != capacity) {
	    		bookings.add(booking);
	    	}
	    }
	    
	    public ArrayList<Booking> sortBookingsByName() {         
	        Collections.sort(bookings, Booking.nameComparator);         
	        return bookings;     
	    }
	    
	    public Booking findBookingsByName(String name) {
	    	for (Booking s : bookings) { 		      
	            if(s.getName().equals(name)) return s;
	       }
	    	return null;
	    }

	    public Booking findBookingByHotel(String hotel) {
	    	for (Booking s : bookings) { 		      
	            if(s.getHotel().equals(hotel)) return s;
	       }
	    	return null;
	    }

}
