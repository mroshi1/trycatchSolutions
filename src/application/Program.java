package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			System.out.println("Numero do quarto: ");
			int number = sc.nextInt();
			System.out.println("Data de check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Data de check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println("Reservation: " + reservation);
			System.out.println("Entre com as datas para atualizar: ");
			System.out.println("Data de check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data de check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			sc.close();
		}
		catch(ParseException e) {
			System.out.println("Data fora do formato correto (dd/MM/yyyy)");
		}
		catch(DomainException e ) {
			System.out.println("Erro na reserva: "+e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Erro não esperado");
		}
	}
}
