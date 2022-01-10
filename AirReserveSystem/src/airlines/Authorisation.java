package airlines;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Authorisation extends JPanel{
	private int port=2456;
	private String address="127.0.0.1";
	private JTextField tfLogin;
	private JTextField tfPass;
	public Account account;
	public Authorisation(JDialog dialog) {
		setSize(300, 150);
		//setTitle("Authorisation");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		
		
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel lbLogin = new JLabel("Enter login");
		lbLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		tfLogin = new JTextField();
		tfLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		
		JLabel lbPass = new JLabel("Enter password");
		lbPass.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		tfPass = new JTextField();
		tfPass.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton btnLogin = new JButton("Enter");
		btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lbLogin);
		panel.add(tfLogin);
		panel.add(lbPass);
		panel.add(tfPass);
		panel.add(btnLogin);
		add(panel);
		setVisible(true);
		
		
		btnLogin.addActionListener(e->reserve(dialog));
		
	}
	public void reserve(JDialog dialog) {
		try {
			System.out.println("auth is started");
			Socket socket = new Socket(address, port);
//			PrintStream pw = new PrintStream(socket.getOutputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject("auth");
			oos.writeObject(tfLogin.getText());
			oos.writeObject(tfPass.getText());
			oos.flush();
			ObjectInputStream br  = new ObjectInputStream(socket.getInputStream());
			account = (Account)br.readObject();
			
			if(account.getLogin()!=null) {
				//status = true;
				dialog.dispose();
			}
			oos.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void main(String[] args) {
		
			
		
			//new Authorisation();
		
	}

}
