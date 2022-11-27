package application;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
    public static void main(String[] args) throws Exception {
        
        Scanner dataInput = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int room = dataInput.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(dataInput.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(dataInput.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else{
            Reservation reservation = new Reservation(room, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            
            System.out.println("\nEnter data do update reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(dataInput.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(dataInput.next());

            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("Error in reservation: Reservation dates for update must be future reservations.");
            }
            else if(!checkOut.after(checkIn)){
                    System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else {        
                reservation.updateDate(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }

        dataInput.close();
    }
}