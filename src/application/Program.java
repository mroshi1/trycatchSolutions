package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Numero do quarto: ");
		int number = sc.nextInt();
		System.out.println("Data de check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());

		System.out.println("Data de check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva, data de check-out precisa ser posterior ao check-in");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println("Entre com as datas para atualizar: ");
			System.out.println("Data de check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data de check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			Date now = new Date();
			System.out.println(now);
			sc.next();
			if(checkIn.before(now)||checkOut.before(now)) {
				System.out.println("Atualizações precisam ser para datas futuras !!");
				
			}else if(!checkOut.after(checkIn)) {
				System.out.println("Data de check-out precisa ser posterior ao check-in");
			}else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);

			}
			System.out.println("Reservation: " + reservation);
			
		}
		sc.close();
	}
}
