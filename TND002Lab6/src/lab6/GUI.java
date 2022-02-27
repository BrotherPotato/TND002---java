package lab6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUI extends JFrame implements ActionListener {

	private JButton loadButton, saveButton, searchButton, nextButton, addButton, deleteButton;
	//private JLabel searchField, nameField, numberField;
	private JTextField searchField, nameField, numberField;
	
	public GUI() {
		
		setTitle("Interactive phonebook");
		Font theFont = new Font("SansSerif",Font.PLAIN,20);
		
		loadButton = new JButton("Load phonebook"); 
		loadButton.setFont(theFont);
		loadButton.addActionListener(this);
		
		//loadButton.setEnabled(true);
		
		saveButton = new JButton("Save phonebook"); 
		saveButton.setFont(theFont);
		saveButton.addActionListener(this);
		
		saveButton.setEnabled(false);
		
		searchButton = new JButton("Search"); 
		searchButton.setFont(theFont);
		searchButton.addActionListener(this);
		
		searchButton.setEnabled(false);
		
		nextButton = new JButton("Next name"); 
		nextButton.setFont(theFont);
		nextButton.addActionListener(this);
		
		nextButton.setEnabled(false);
		
		addButton = new JButton("Add person"); 
		addButton.setFont(theFont);
		addButton.addActionListener(this);
		
		addButton.setEnabled(false);
		
		deleteButton = new JButton("Delete person"); 
		deleteButton.setFont(theFont);
		deleteButton.addActionListener(this);
		
		deleteButton.setEnabled(false);
		
		searchField = new JTextField();
		searchField.setFont(theFont);
		searchField.addActionListener(this);
		//searchField.setEditable(true);
		
		nameField = new JTextField();
		nameField.setFont(theFont);
		nameField.addActionListener(this);
		nameField.setEditable(false);
		
		numberField = new JTextField();
		numberField.setFont(theFont);
		numberField.addActionListener(this);
		numberField.setEditable(false);
		
//		theTextField = new JTextField();
//		theTextField.setFont(theFont); 
//		theTextField.addActionListener(this);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,2));
		
		panel1.add(loadButton); 
		panel1.add(saveButton);
		panel1.add(searchButton); 
		panel1.add(nextButton); 
		panel1.add(addButton); 
		panel1.add(deleteButton); 
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,1));
		
		panel2.add(searchField);
		panel2.add(nameField);
		panel2.add(numberField);
		 
		Container c = getContentPane();
		c.setLayout(new GridLayout(1,2));
		
		c.add(panel1);
		c.add(panel2);
		
//		c.add(searchField);
//		c.add(nameField);
//		c.add(numberField);	
		
		setVisible(true); 
		pack(); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae) {
//		if (ae.getSource() == loadButton) {
//			PhoneBook.load();
//		}		
//		if (ae.getSource() == theButton || ae.getSource() == theTextField) {
//			theLabel.setText(theTextField.getText());
//			theTextField.setText("");;
//		}
	}
		
	
	public static void main(String[] args) {
		
		GUI myGUI = new GUI();

	}

}
