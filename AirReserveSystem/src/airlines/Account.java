package airlines;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable{
	private static final long serialVersionUID = 1l;
	private String name;
	private String login;
	private String password;
	private List<Flight> flights = new ArrayList<>();
	public Account(String name, String login, String password, List<Flight> flights) {
		this(login, password);
		this.name = name;
		this.flights = flights;
	}
	public Account(String login, String password) {
		this.login = login;
		this.password = password;
		
	}
	public Account(String name, String login, String password) {
		this(login, password);
		this.name = name;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		Account ac = (Account)obj;
		return login.equals(ac.login) && password.equals(ac.password);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	
}
