package airlines;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Flight implements Serializable{
	private static final long serialVersionUID = 1l;
	private static int currentNumber=1;
	private int number;
	private String airline;
	private String from;
	private String to;
	private LocalDate date;
	private int amount;
	private int reserveCount;
	
	public Flight(int number, String airline, String from, String to, LocalDate date, int amount, int reserveCount) {
		this.number = number;
		this.airline = airline;
		this.from = from;
		this.to = to;
		this.date = date;
		this.amount = amount;
		this.reserveCount = reserveCount;
	}

	public Flight(int number, String airline, String from, String to, LocalDate date) {
		this.number = number;
		this.airline = airline;
		this.from = from;
		this.to = to;
		this.date = date;
	}
	public Flight(int number) {
		this.number = number;
	}

	
	public int getAvailableCount() {
		return amount - reserveCount;
	}
	
	public void reserve() {
		reserveCount++;
	}
	
	public String toString() {
		return String.format("%d %s %s %s %s %d", number, airline, from,to, date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), getAvailableCount());
	}
	
	public boolean equals(Object o) {
		Flight f = (Flight)o;
		return number == f.number;
		
	}
	public int getNumber()
	{
		return number;
	}
	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getReserveCount() {
		return reserveCount;
	}

	public void setReserveCount(int reserveCount) {
		this.reserveCount = reserveCount;
	}
	
	

	
	
	
	
	

}

