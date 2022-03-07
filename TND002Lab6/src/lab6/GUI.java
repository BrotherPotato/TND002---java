package lab6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class GUI extends JFrame implements ActionListener {

	private JButton loadButton, saveButton, searchButton, nextButton, addButton, deleteButton;

	private JTextField searchField, nameField, numberField;
	
	private PhoneBook phoneBook = new PhoneBook();
	
	private ArrayList<Person> listOfPeople = new ArrayList<Person>();
	private int personCounter = 0;
	private boolean readAddPersonInput = false;
	
	public GUI() {
		setTitle("Interactive phonebook");
		Font theFont = new Font("SansSerif",Font.PLAIN,20);
		
		loadButton = new JButton("Load phonebook"); 
		loadButton.setFont(theFont);
		loadButton.addActionListener(this);
		
		saveButton = new JButton("Save phonebook"); 
		saveButton.setFont(theFont);
		saveButton.addActionListener(this);
		
		searchButton = new JButton("Search"); 
		searchButton.setFont(theFont);
		searchButton.addActionListener(this);
		
		nextButton = new JButton("Next name"); 
		nextButton.setFont(theFont);
		nextButton.addActionListener(this);
		
		addButton = new JButton("Add person"); 
		addButton.setFont(theFont);
		addButton.addActionListener(this);
		
		deleteButton = new JButton("Delete person"); 
		deleteButton.setFont(theFont);
		deleteButton.addActionListener(this);
		
		loadButton.setEnabled(true); // irrelevant
		saveButton.setEnabled(false);
		searchButton.setEnabled(false);
		nextButton.setEnabled(false);
		addButton.setEnabled(false);
		deleteButton.setEnabled(false);
		
		searchField = new JTextField();
		searchField.setFont(theFont);
		searchField.addActionListener(this);
		
		nameField = new JTextField();
		nameField.setFont(theFont);
		nameField.addActionListener(this);
		
		numberField = new JTextField();
		numberField.setFont(theFont);
		numberField.addActionListener(this);
		
		searchField.setEditable(true); // irrelevant
		nameField.setEditable(false);
		numberField.setEditable(false);
		
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
		
		setVisible(true); 
		pack(); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == loadButton || ae.getSource() == searchField) {
			String searchText = searchField.getText();
			searchField.setText("");
			nameField.setText(phoneBook.load(searchText));
			loadButton.setEnabled(true); // irrelevant
			saveButton.setEnabled(true);
			searchButton.setEnabled(true);
			nextButton.setEnabled(false); // irrelevant
			addButton.setEnabled(true);
			deleteButton.setEnabled(true);
		}
		
		if(ae.getSource() == saveButton) {
			String searchText = searchField.getText();
			if(searchText.isBlank() || searchText.equals("PhoneList.txt")) {
				nameField.setText("Provide a file name");
			} else {
				searchField.setText("");
				nameField.setText(phoneBook.save(searchText));
			}
		}
		
		if(ae.getSource() == searchButton) {
			String searchText = searchField.getText();
			searchField.setText("");
			listOfPeople = phoneBook.search(searchText);
			if(listOfPeople.size() < 1) {
				nameField.setText("Provide a surname or phonenumber");
				numberField.setText("");
			} else if(listOfPeople.size() == 1) {
				nameField.setText(listOfPeople.get(0).getFullName());
				try {
					numberField.setText(Integer.toString(listOfPeople.get(0).getPhoneNumber()));
				} catch (Exception ignore) {
					numberField.setText("Could not add number");
				}
			} else {
				personCounter = 0;
				nameField.setText(listOfPeople.get(personCounter).getFullName());
				try {
					numberField.setText(Integer.toString(listOfPeople.get(personCounter).getPhoneNumber()));
				} catch (Exception ignore) {
					numberField.setText("Could not add number");
				}
				nextButton.setEnabled(true); 
			}
		}
		
		if(ae.getSource() == nextButton) {
			personCounter++;
			nameField.setText(listOfPeople.get(personCounter).getFullName());
			numberField.setText(Integer.toString(listOfPeople.get(personCounter).getPhoneNumber()));
			if(personCounter >= listOfPeople.size() - 1) {
				personCounter = 0;
				nextButton.setEnabled(false);
			}
		}
		
		if(ae.getSource() == addButton) {
			if(!readAddPersonInput) {
				searchField.setText("Type in name and phonenumber");
				nameField.setEditable(true);
				numberField.setEditable(true);
				nameField.setText("");
				numberField.setText("");
				readAddPersonInput = true;
			} else {
				try {
					int phoneNumber = Integer.parseInt(numberField.getText());
					boolean personAdded = phoneBook.addPerson(nameField.getText(), phoneNumber);
					nameField.setText("");
					numberField.setText("");
					nameField.setEditable(false);
					numberField.setEditable(false);
					if(personAdded) {
						searchField.setText("Person added");
					} else {
						searchField.setText("Person could not be added");
					}
					readAddPersonInput = false;
				} catch (Exception ignore) {
					searchField.setText("Person could not be added");
				}
			}
		}
		
		if(ae.getSource() == deleteButton) {
			try {
				searchField.setText(phoneBook.deletePerson(nameField.getText(), Integer.parseInt(numberField.getText())));
			} catch (Exception ignore) {

				searchField.setText("The person/number does not exist");
			}
		}
	}
		
	public static void main(String[] args) {
		GUI myGUI = new GUI();
	}
}
