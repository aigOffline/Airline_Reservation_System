
package airlines;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) throws Exception{

		//1;line1;Canada;USA;20.12.2021;10;4
		//2;line2;Russia;Canada;19.12.2021;12;3
		//3;line1;Russia;USA;26.11.2021;6;4
		//createFlights();
		createAccounts();
	}

	public static void createFlights() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("flights.txt"));
		List<Flight> flights = List.of(new Flight(1, "line1", "Canada", "USA", LocalDate.of(2021, 12, 20), 10, 4),
				new Flight(2, "line2", "Russia", "Canada", LocalDate.of(2021, 12, 19), 12, 3),
				new Flight(3, "line1", "Russia", "USA", LocalDate.of(2021, 11, 26), 6, 4));

		oos.writeObject(flights);
		oos.close();
	}

	public static void createAccounts() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("accounts.txt"));
		List<Account> list = Arrays.asList(new Account("user1", "login1", "pass1"), new Account("user2", "login2", "pass2"));
		oos.writeObject(list);
		oos.close();
	}
}
