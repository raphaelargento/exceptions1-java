package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
    public static void main(String[] args) {
        
        Scanner dataInput = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            System.out.print("Room number: ");
            int room = dataInput.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(dataInput.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(dataInput.next());
            
            Reservation reservation = new Reservation(room, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            
            System.out.println("\nEnter data to update reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(dataInput.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(dataInput.next());

            // In this version the validation occurs inside the updateDates method
            // which returns a string with the error or null if everything is running correctly
            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch(ParseException e){
            System.out.println("Invalid date format");
        }
        catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Unexpected error!");
        }
        dataInput.close();
    }
}