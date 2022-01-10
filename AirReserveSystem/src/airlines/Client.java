package airlines;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Client extends JFrame{
	private int port=2456;
	private String address="127.0.0.1";
	private boolean isAuth = false;
	private Account account;
	
	public Client() {
		setSize(500, 400);
		setTitle("Air reservation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		if(!isAuth) {
			JDialog dialog = new JDialog(this, true);
			Authorisation auth = new Authorisation(dialog);
			dialog.setLocationRelativeTo(null);
			dialog.setSize(300, 150);
			dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			dialog.getContentPane().add(auth);
			
			dialog.setVisible(true);
			System.out.println("test");
			account = auth.account;
			//if(auth.status) {
			//	isAuth  =true;
			//}
		}
		if(account == null){
			System.out.println("dispose");
			this.dispose();
		}
		System.out.println(account.getName());

		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel lbUser = new JLabel("User name: "+account.getName());
		lbUser.setAlignmentX(Component.CENTER_ALIGNMENT);
		JList<Flight> reservedFlightsJList = new JList<Flight>();
		reservedFlightsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<Flight> reservedModel = new DefaultListModel<Flight>();
		JList<Flight> availFlightsJList = new JList<Flight>();
		availFlightsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		for(Flight flight : account.getFlights()) {
			reservedModel.addElement(flight);
		}
		
		
		DefaultListModel<Flight> availModel = new DefaultListModel<Flight>();
		refreshFlights(availModel);
		
		reservedFlightsJList.setModel(reservedModel);
		availFlightsJList.setModel(availModel);
		JScrollPane pane = new JScrollPane(reservedFlightsJList);
		pane.setPreferredSize(new Dimension(300, 100));
		JScrollPane pane2 = new JScrollPane(availFlightsJList);
		pane2.setPreferredSize(new Dimension(300, 100));
		JButton btnReserve = new JButton("Reserve");
		JButton btnRefresh = new JButton("Refresh");
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new FlowLayout());
		panelButtons.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelButtons.add(btnReserve);
		panelButtons.add(btnRefresh);
		JLabel lbReserved = new JLabel("Reserved flights");
		lbReserved.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel lbAvailable = new JLabel("Available flights");
		lbAvailable.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lbUser);
		panel.add(lbReserved);
		panel.add(pane);
		panel.add(lbAvailable);
		panel.add(pane2);
		panel.add(panelButtons);
		
		btnRefresh.addActionListener(e->refreshFlights(availModel));
		btnReserve.addActionListener(e->reserve(availFlightsJList, reservedModel));
		
		add(panel);
		setVisible(true);
		
		
		
	}
	public void refreshFlights(DefaultListModel model) {
		List<Flight> list = new ArrayList<>();
		model.clear();
		try {
			Socket socket = new Socket(address, port);
			//PrintStream pw = new PrintStream(socket.getOutputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject("refresh");
			oos.flush();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			list = (List<Flight>)ois.readObject();
			for(Flight flight : list) {
				model.addElement(flight);
			}
			oos.close();
			//ois.reset();
			ois.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	
	
	public void reserve(JList<Flight> availFlightJList, DefaultListModel<Flight> reservedModel) {
		try {
			
			Socket socket = new Socket(address, port);
			Flight selectedFlight = availFlightJList.getSelectedValue();
			System.out.println(selectedFlight);
			if(selectedFlight == null) return;
			//PrintStream pw = new PrintStream(socket.getOutputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject("reserve");
			oos.writeObject(account.getLogin());
			oos.writeObject(account.getPassword());
			oos.writeObject(selectedFlight);
			oos.flush();
			System.out.println("sended");
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Flight f = (Flight)ois.readObject();
			if(f.getNumber()==-1) {
				JOptionPane.showMessageDialog(null, "The flights is unavailable");
			}else {
				reservedModel.addElement(f);
			}
			refreshFlights((DefaultListModel)availFlightJList.getModel());
			oos.reset();
			//ois.reset();
			oos.close();
			ois.close();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void insertReservedFlightsToJList(DefaultListModel<Flight> flightModel){
		flightModel.addAll(account.getFlights());
	}
	
	public static void main(String[] args) {
		
			
		
			new Client();
		
	}
	
	

}
