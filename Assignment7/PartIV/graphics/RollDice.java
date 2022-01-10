package graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RollDice extends JFrame {

	
	public RollDice() {
		Panel p1 = new Panel();
		p1.setLayout(new BorderLayout());
		p1.add(new ImagePanel("PartIV/die1.png"));
		
		Panel p2 = new Panel();
		p2.setLayout(new BorderLayout());
		p2.add(new ImagePanel("PartIV/die2.png"));
		
		add(p1, BorderLayout.LINE_START);
		add(p2, BorderLayout.LINE_END);
		
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		RollDice rollDice = new RollDice();
	
	}
}
