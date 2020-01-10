package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		
		
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Scanner sc = new Scanner(System.in);
	
		try {
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("check-In date: (dd/mm/yyyy) ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("check-Out date: (dd/mm/yyyy) ");
		Date checkOut = sdf.parse(sc.next());;
		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println("Reservation: " + reservation);
		System.out.println();
		System.out.println("Enter to update the Reserve: ");
		System.out.print("check-In date: (dd/mm/yyyy) ");
		checkIn = sdf.parse(sc.next());
		System.out.print("check-Out date: (dd/mm/yyyy) ");
		checkOut = sdf.parse(sc.next());
		
		reservation.UpdateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
		}
		catch(ParseException e) {
			System.out.println("Invalid date form;");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
	    catch(RuntimeException e) {
	    	System.out.println("unexpected error: ");
	    }
		sc.close();
	}
}
