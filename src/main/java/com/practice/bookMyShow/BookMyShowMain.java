package com.practice.bookMyShow;

public class BookMyShowMain {

	public static void main(String[] args) {
		
		User user = new User(1, "AJ");
		Movie mv1 = new Movie(1, "Bahabuli", 120);
		Movie mv2 = new Movie(2, "Gladiator", 180);
		
		Theatre th1 = new Theatre(1, "Noida");
		Theatre th2 = new Theatre(2, "Gurgaon");
		
		Screen sc1 = new Screen(1, 1);
		Screen sc2 = new Screen(2, 1);
		th1.addScreen(sc1);
		th1.addScreen(sc2);
		
		Show sh1 = new Show(1, sc1, th1.theatreId , mv1, 100);
		Show sh2 = new Show(2, sc1, th1.theatreId , mv2, 100);
		
		th1.addShow(sh1);
		th1.addShow(sh2);
		
		Show sh3 = new Show(3, sc2, th1.theatreId , mv1, 100);
		Show sh4 = new Show(4, sc2, th1.theatreId , mv2, 100);
		
		th1.addShow(sh3);
		th1.addShow(sh4);
		
		
//		Seat(int id, int row, int screenId, SeatCategory category);
		Seat st1 = new Seat(1, 1, 1, SeatCategory.NORMAL);
		Seat st2 = new Seat(2, 1, 1, SeatCategory.NORMAL);
		
		sc1.add(st1);
		sc1.add(st2);
		
		Booking booking = sh1.bookSeat(1, 1, user);
		booking.payment.donePayment();
		

		Screen sc3 = new Screen(3, 2);
		Screen sc4 = new Screen(4, 2);
		th2.addScreen(sc4);
		th2.addScreen(sc3);
		
		
		Show sh5 = new Show(5, sc3, th2.theatreId , mv1, 100);
		Show sh6 = new Show(6, sc3, th2.theatreId , mv2, 100);
		
		th2.addShow(sh5);
		th2.addShow(sh6);
		
		Show sh7 = new Show(7, sc4, th2.theatreId , mv1, 100);
		Show sh8 = new Show(8, sc4, th2.theatreId , mv2, 100);
		
		th2.addShow(sh7);
		th2.addShow(sh8);
		
		
		
//		Show(int showId, Screen screen, int theatreId, Movie movie, int startTime)
		
		


	}

}
