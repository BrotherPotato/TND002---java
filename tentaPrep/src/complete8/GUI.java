package complete8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
	private JButton greenplus, greenminus, blueplus, blueminus, redplus, redminus;
	private Font theFont;
	private JPanel myPanel1, myPanel2;
	private JTextField myTextField1, myTextField2, myTextField3;
	private JLabel myMainLabel, myGreenLabel, myRedLabel, myBlueLabel;
	private int red = 0, green = 0, blue = 0;
	private Color theColor = Color.BLACK;
	
	public GUI(){
		theFont = new Font("SansSerif", Font.PLAIN, 20);
				
		greenplus = new JButton("+"); 
		greenplus.setFont(theFont); 
		greenplus.addActionListener(this);
		greenminus = new JButton("-"); 
		greenminus.setFont(theFont); 
		greenminus.addActionListener(this);
		
		redplus = new JButton("+"); 
		redplus.setFont(theFont); 
		redplus.addActionListener(this);
		redminus = new JButton("-"); 
		redminus.setFont(theFont); 
		redminus.addActionListener(this);
		
		blueplus = new JButton("+"); 
		blueplus.setFont(theFont); 
		blueplus.addActionListener(this);
		blueminus = new JButton("-"); 
		blueminus.setFont(theFont); 
		blueminus.addActionListener(this);
		
		myTextField1 = new JTextField(String.valueOf(red)); 
		myTextField1.setFont(theFont); 
		myTextField1.addActionListener(this);
		myTextField2 = new JTextField(String.valueOf(green)); 
		myTextField2.setFont(theFont); 
		myTextField2.addActionListener(this);
		myTextField3 = new JTextField(String.valueOf(blue)); 
		myTextField3.setFont(theFont); 
		myTextField3.addActionListener(this);
		
		myPanel1 = new JPanel(new GridLayout(2,3));
		myPanel2 = new JPanel(new GridLayout(2,3));

		myMainLabel = new JLabel("Text",JLabel.CENTER); 
		myMainLabel.setFont(theFont);
		myRedLabel = new JLabel("Red "); 
		myRedLabel.setFont(theFont);
		myGreenLabel = new JLabel("Green "); 
		myGreenLabel.setFont(theFont);
		myBlueLabel = new JLabel("Blue "); 
		myBlueLabel.setFont(theFont);
		
		myPanel1.add(myRedLabel); 
		myPanel1.add(myGreenLabel);
		myPanel1.add(myBlueLabel); 
		myPanel1.add(myTextField1);
		myPanel1.add(myTextField2); 
		myPanel1.add(myTextField3);
		myPanel2.add(redplus); 
		myPanel2.add(greenplus);
		myPanel2.add(blueplus); 
		myPanel2.add(redminus);
		myPanel2.add(greenminus); 
		myPanel2.add(blueminus);
		Container c = getContentPane(); 
		c.setBackground(Color.WHITE);
		c.setLayout(new GridLayout(3,1));
		c.add(myMainLabel); 
		c.add(myPanel1); 
		c.add(myPanel2);
		
		setVisible(true); 
		pack(); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == myTextField1){ textFieldUpdate();}
		if (e.getSource() == myTextField2){ textFieldUpdate();}
		if (e.getSource() == myTextField3){ textFieldUpdate();}
				
		if (e.getSource() == redplus){red = red + 15; incrementalUpdate();}
		if (e.getSource() == redminus){red = red - 15; incrementalUpdate();}
		if (e.getSource() == greenplus){green = green + 15; incrementalUpdate();}
		if (e.getSource() == greenminus){green = green - 15; incrementalUpdate();}
		if (e.getSource() == blueplus){blue = blue + 15; incrementalUpdate();}
		if (e.getSource() == blueminus){blue = blue - 15; incrementalUpdate();}
		
	}
	
	public void textFieldUpdate(){
		try {
			int dummyR, dummyG, dummyB;
			dummyR = Integer.valueOf(myTextField1.getText());
			dummyG = Integer.valueOf(myTextField2.getText());
			dummyB = Integer.valueOf(myTextField3.getText());
			System.out.println(dummyR);
			if (dummyR > -1 && dummyR < 256) red = dummyR;
			if (dummyG > -1 && dummyG < 256) green = dummyG;
			if (dummyB > -1 && dummyB < 256) blue = dummyB;
			myMainLabel.setForeground(new Color(red, green, blue));
		}
		catch (NumberFormatException ierr){}
	}
	
	public void incrementalUpdate(){
		if (red > 255) red = red - 255;
		if (red < 0) red = red + 255;
		if (green > 255) green = green - 255;
		if (green < 0) green = green + 255;
		if (blue > 255) blue = blue - 255;
		if (blue < 0) blue = blue + 255;
		myMainLabel.setForeground(new Color(red, green, blue));
		myTextField1.setText(String.valueOf(red));
		myTextField2.setText(String.valueOf(green));
		myTextField3.setText(String.valueOf(blue));
	}
	
	public static void main(String[] args) {
		GUI myGUI = new GUI();
	}

}
