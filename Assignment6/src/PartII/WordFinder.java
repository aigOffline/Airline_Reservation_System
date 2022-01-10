package PartII;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WordFinder extends JFrame {

	JFileChooser jFileChooser;
	private JPanel topPanel; // the top line of objects is going to go here
	WordList wordList;
	private JTextArea wordsBox; // results of the search go in heer.
	String searchingWord;
	public WordFinder() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set the size correctly
		this.setSize(500, 300);
		jFileChooser = new JFileChooser(".");
		wordList = new WordList();

		JTextField tf = new JTextField(15);
		tf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				searchingWord = tf.getText();
				find();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				
			}
		});
		JButton btn = new JButton("Find");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				searchingWord = tf.getText();
				find();
				
				
			}
		});	

	
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.setSize(400, 180);
		topPanel.add(new JLabel("Find: "));
		topPanel.add(tf);
		topPanel.add(btn);

		createMenus();

		wordsBox = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(wordsBox);

		add(topPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);


	}

	/**
	 * Creates the File->Exit menu item and sets its action listener.
	 * 
	 * @return the menu item
	 */
	public JMenuItem createFileExitItem() {
		JMenuItem item = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		}
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}

	private void createMenus() {
		/*
		 * add a "File" menu with: "Open" item which allows you to choose a new file
		 * "Exit" item which ends the process with System.exit(0); Key shortcuts are
		 * optional
		 */

		JMenuItem item = new JMenuItem("Open");
		/* OpenActionListener that will open the file chooser */
		class OpenActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				OpenFileListener myFileListener = new OpenFileListener();
				myFileListener.actionPerformed(e);
			}
		}
		ActionListener listener = new OpenActionListener();
		item.addActionListener(listener);

		JMenu menu = new JMenu("File");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menu.add(createFileExitItem());
		menu.add(item);

		menuBar.add(menu);

	}

	private void find() {
		if(wordList.getWords()!=null) {
			List searchResult = wordList.find(searchingWord); // figure out from WordList how to get this
			fillTextArea(searchResult);
		
		}else {
			
			JOptionPane.showMessageDialog(this, "You should select a file at first", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	}

	class OpenFileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int returnVal = jFileChooser.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					System.out.println(
							"You chose to open this file: " + jFileChooser.getSelectedFile().getAbsolutePath());

					InputStream in = new FileInputStream(jFileChooser.getSelectedFile().getAbsolutePath());
					wordList.load(in);
					fillTextArea(wordList.getWords());

					List searchResult = null; // figure out from WordList how to get this
					// because you will load in a wordlist and there
					// might be data in the search box

				} catch (IOException error) {
					error.printStackTrace();
				}
			}
		}
	}
	public void fillTextArea(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		wordsBox.setText(sb.toString());
	}

	public static void main(String[] args) {

		WordFinder wordFinder = new WordFinder();
		wordFinder.setVisible(true);
	}
}
