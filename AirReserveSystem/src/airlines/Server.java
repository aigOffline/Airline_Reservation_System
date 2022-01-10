package airlines;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class Server {
	private int port=2456;
	private Object locker = new Object();
	private Executor executor;
	private List<Flight> availableFlights = new ArrayList<>();
	private List<Account> accounts = new ArrayList<>();
	private String flightPath="flights.txt";
	private String accountsPath="accounts.txt";
	public Server() {
		loadAccounts();
		loadFlights();
		executor = Executors.newFixedThreadPool(8);
		
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server is started");
			while(true) {
				System.out.println("server waiting new client connection");
				Socket clientSocket = serverSocket.accept();
				System.out.println("conected");
				executor.execute(new Task(clientSocket));
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Server();
	}

	private void loadAccounts() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(accountsPath));
			accounts = (List<Account>)ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadFlights() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(flightPath));
			List<Flight> flightList = (List<Flight>)ois.readObject();
			availableFlights.addAll(flightList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Flight parseFlightFromFile(String flightInfo) {
		String[] arr = flightInfo.split(";");
		LocalDate date = LocalDate.parse(arr[4], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		return new Flight(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], date, Integer.parseInt(arr[5]), Integer.parseInt(arr[6]));
	}
	public static Flight parseFlightFromClient(String flightInfo) {
		String[] arr = flightInfo.split(";");
		LocalDate date = LocalDate.parse(arr[4], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		return new Flight(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], date);
	}
	
	class Task implements Runnable{
		Socket socket;
		
		public Task(Socket socket) {
			this.socket = socket;
			
		}
		
		@Override
		public void run() {
			try {
//				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

				System.out.println("before red");
				String requestType = ois.readObject().toString();
				System.out.println("readed: "+requestType);
				if(requestType.equals("auth")) {
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//					String login = br.readLine();
//					String pass = br.readLine();
					String login = ois.readObject().toString();
					String pass = ois.readObject().toString();
					int index = accounts.indexOf(new Account(login, pass));
					if(index!=-1){
						Account acc = accounts.get(index);
						oos.writeObject(acc);
					}else {
						Account acc = new Account(null, null);
						oos.writeObject(acc);
					}
					oos.reset();
					oos.close();
					
				}else if(requestType.equals("refresh")) {
					StringBuilder sb = new StringBuilder();
					
					synchronized (locker) {
						
						/*sb.append(availableFlights.size());
						for(Flight flight : availableFlights) {
							sb.append(flight.toString()).append("\n");
						}*/
					}
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				
					synchronized(locker) {
						List<Flight> list = new ArrayList();
						for(Flight f : availableFlights) {
							if(f.getAvailableCount() > 0) {
								list.add(f);
							}
						}
						oos.writeObject(list);
					}
					oos.reset();
					oos.close();
				}
				else {
					System.out.println("tst");
					//ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					System.out.println("reading read object");
					String login = ois.readObject().toString();
					String password = ois.readObject().toString();
					Flight selectedFlight = (Flight)ois.readObject();
					System.out.println("one: "+selectedFlight);
					boolean answer = false;
					Flight reservedFlight = null;
					synchronized(locker) {
						int index = availableFlights.indexOf(selectedFlight);
						if(index!=-1 && availableFlights.get(index).getAvailableCount()>0) {
							reservedFlight = availableFlights.get(index);
							availableFlights.get(index).reserve();
							answer = true;
							accounts.get(accounts.indexOf(new Account(login, password))).getFlights().add(availableFlights.get(index));
						}
					}
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					if(answer) {
						System.out.println("two: "+reservedFlight);
						oos.writeObject(reservedFlight);
						
					}else {
						
						oos.writeObject(new Flight(-1));
						
					}
					oos.reset();
					//ois.reset();
					oos.close();
					ois.close();

					if(answer) {
						synchronized (locker) {
							save(availableFlights, flightPath);
							save(accounts, accountsPath);
						}
					}
				}
				ois.close();
				/*else {
					String reserve = br.readLine();
					
					PrintStream pw = new PrintStream(socket.getOutputStream());
					Flight flight = parseFlightFromClient(reserve);
					synchronized (locker) {
					
						int index = availableFlights.indexOf(flight);
						
						
						if(availableFlights.get(index).getAvailableCount()>0) {
							availableFlights.get(index).reserve();
							pw.println("ok");
							System.out.println("Remain "+availableFlights.get(index).getAvailableCount());
						}
						else {
							pw.println("error");
						}
						pw.close();
						
					}
					
				}*/
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void save(Object objectToSave, String filePath) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
		oos.writeObject(objectToSave);
		oos.close();
	}
}

