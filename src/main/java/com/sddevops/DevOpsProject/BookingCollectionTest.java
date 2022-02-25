package com.sddevops.DevOpsProject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookingCollectionTest {

	private BookingCollection bc;
	private Booking b1;
	private Booking b2;
	private Booking b3;
	private Booking b4;
	private final int BOOKING_COLLECTION_SIZE = 4;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		bc = new BookingCollection();
		b1 = new Booking("Lim Zheng Yang", "Hotel 81", "69", "2022-02-27", "2022-02-28");
		b2 = new Booking("Kwan Gavin", "Hotel 81", "69", "2022-04-27", "2022-07-12");
		b3 = new Booking("Ng Zhong Qi", "Idk la up to you", "123", "2022-06-12", "2022-07-12");
		b4 = new Booking("Dahlimi Kuryadi Bin Dahlan", "MBS", "96", "2022-06-12", "2022-07-12");
		bc.addBooking(b1);
		bc.addBooking(b2);
		bc.addBooking(b3);
		bc.addBooking(b4);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.sddevops.DevOpsProject.BookingCollection#getBookings()}.
	 */
	@Test
	void testGetBookings() {
		//fail("Not yet implemented");
		
		 List<Booking> testBc = bc.getBookings();
		 
		 assertFalse(testBc.isEmpty());
		 
		 assertEquals(testBc.size(), BOOKING_COLLECTION_SIZE);
		
		
	}

	/**
	 * Test method for
	 * {@link com.sddevops.DevOpsProject.BookingCollection#addBooking(com.sddevops.DevOpsProject.Booking)}.
	 */
	@Test
	void testAddBooking() {
		// fail("Not yet implemented");
		List<Booking> testBc = bc.getBookings();

		assertEquals(testBc.size(), BOOKING_COLLECTION_SIZE);

		bc.addBooking(b1);

		assertEquals(bc.getBookings().size(), BOOKING_COLLECTION_SIZE + 1);

	}

	/**
	 * Test method for
	 * {@link com.sddevops.DevOpsProject.BookingCollection#sortBookingsByName()}.
	 */
	@Test
	void testSortBookingsByName() {
		 List<Booking> testBc = bc.sortBookingsByName();

	        // Arrange
	        String newBookingName1 = testBc.get(0).getName();
	        String newBookingName2 = testBc.get(1).getName();
	        String newBookingName3 = testBc.get(2).getName();
	        String newBookingName4 = testBc.get(3).getName();
	        
	        
	        assertEquals(newBookingName1, "Dahlimi Kuryadi Bin Dahlan");
	        assertEquals(newBookingName2, "Kwan Gavin");
	        assertEquals(newBookingName3, "Lim Zheng Yang");
	        assertEquals(newBookingName4, "Ng Zhong Qi");
	}

	/**
	 * Test method for
	 * {@link com.sddevops.DevOpsProject.BookingCollection#findBookingsByName(java.lang.String)}.
	 */
	@Test
	void testFindBookingsByName() {
		Booking a = bc.findBookingsByName("Kwan Gavin");
		Booking b = bc.findBookingsByName("Name not found in Bookings");
		
		assertNotNull(a);
		assertEquals(a.getHotel(),"Hotel 81");
		assertNull(b);
	}

	@Test
	void testFindBookingByHotel() {
		Booking a = bc.findBookingByHotel("MBS");
		Booking b = bc.findBookingByHotel("Hotel not found in Bookings");
		
		assertNotNull(a);
		assertEquals(a.getName(),"Dahlimi Kuryadi Bin Dahlan");
		assertNull(b);
	}

}
