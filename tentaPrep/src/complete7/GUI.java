package complete7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
	private JButton assemble, content, reset, book, bluray;
	private Font theFont; 
	private JPanel panel1, panel2, panel3;
	private JTextField myTextField1, myTextField2;
	private int books;
	private int blurays;
		
	public GUI(){
		theFont = new Font("SansSerif", Font.PLAIN, 20);
		
		setTitle("Graphical user interface");
		books = 0; blurays = 0;
		
		assemble = new JButton("Assemble"); assemble.setFont(theFont); assemble.addActionListener(this);
		content = new JButton("Content"); content.setFont(theFont); content.setEnabled(false); content.addActionListener(this);
		reset = new JButton("Reset"); reset.setFont(theFont);reset.setForeground(Color.red); reset.addActionListener(this);
		book = new JButton("Book"); book.setFont(theFont);book.setForeground(Color.blue); book.addActionListener(this);
		bluray = new JButton("BluRay"); bluray.setFont(theFont);bluray.setForeground(Color.blue); bluray.addActionListener(this);
		panel1 = new JPanel(); panel1.setLayout(new GridLayout(1,3));
		panel1.add(assemble); panel1.add(content); panel1.add(reset);
		panel2 = new JPanel(); panel2.setLayout(new GridLayout(2,1));
		panel2.add(bluray); panel2.add(book);
		
		myTextField1 = new JTextField(); myTextField1.setFont(theFont); myTextField1.setText("Blurays: " + String.valueOf(blurays));
		myTextField1.addActionListener(this);
		myTextField2 = new JTextField(); myTextField2.setFont(theFont); myTextField2.setText("Books: " + String.valueOf(books));
		myTextField2.addActionListener(this);
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2,1));
		panel3.add(myTextField1); panel3.add(myTextField2);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(panel1, BorderLayout.SOUTH);
		c.add(panel2, BorderLayout.EAST);
		c.add(panel3, BorderLayout.CENTER);
		setVisible(true); pack(); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == assemble){
			String[] dummy = myTextField1.getText().split(" +");
			blurays = Integer.valueOf(dummy[1]);
			myTextField1.setEditable(false); 
			dummy = myTextField2.getText().split(" +");
			books = Integer.valueOf(dummy[1]);
			myTextField2.setEditable(false); 
			content.setEnabled(true);
			assemble.setEnabled(false);
		}
		if (e.getSource() == reset){
			books = 0; blurays = 0;
			myTextField1.setEditable(true); myTextField1.setText("Blurays: " + String.valueOf(blurays));
			myTextField2.setEditable(true); myTextField2.setText("Books: " + String.valueOf(books));
			content.setEnabled(false); assemble.setEnabled(true);
		}
		if (e.getSource() == content){
			myTextField1.setText("The parcel contains");
			myTextField2.setText(String.valueOf(blurays) + " blu rays and " + String.valueOf(books) + " books.");
		}
		if (e.getSource() == book){
			books = books + 1;
			myTextField2.setText("Books: " + String.valueOf(books));
		}
		if (e.getSource() == bluray){
			blurays = blurays + 1;
			myTextField1.setText("Blurays: " + String.valueOf(blurays));
		}
		if (e.getSource() == myTextField1) {
			String dummy = myTextField1.getText();
			String[] dummy2 = dummy.split(" +");
			try {
				blurays = Integer.valueOf(dummy2[1]);
			}catch(NumberFormatException ierr) {}
		}
		if (e.getSource() == myTextField2) {
			String dummy = myTextField2.getText();
			String[] dummy2 = dummy.split(" +");
			try {
				books = Integer.valueOf(dummy2[1]);
			}catch(NumberFormatException ierr) {}
		}
	}
	
	
	public static void main(String[] args) {
		GUI myGUI = new GUI();
	}

}
