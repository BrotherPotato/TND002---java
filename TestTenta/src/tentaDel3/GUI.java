package tentaDel3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener{

	private Font myFont = new Font("SansSerif", Font.PLAIN, 20);
	private JPanel panel1, panel2;
	private JButton redPlus, redMinus, greenPlus, greenMinus, bluePlus, blueMinus;
	private JTextField redNumberField, greenNumberField, blueNumberField;
	private JLabel textLabel, redLabel, greenLabel, blueLabel;
	private int red = 0, green = 0, blue = 0;
	private Color theColor = Color.BLACK;
	public GUI() {
		
		redPlus = new JButton("+");
		redMinus = new JButton("-");
		greenPlus = new JButton("+");
		greenMinus = new JButton("-");
		bluePlus = new JButton("+");
		blueMinus = new JButton("-");
		
		redPlus.setFont(myFont);
		redMinus.setFont(myFont);
		greenPlus.setFont(myFont);
		greenMinus.setFont(myFont);
		bluePlus.setFont(myFont);
		blueMinus.setFont(myFont);
		
		redPlus.addActionListener(this);
		redMinus.addActionListener(this);
		greenPlus.addActionListener(this);
		greenMinus.addActionListener(this);
		bluePlus.addActionListener(this);
		blueMinus.addActionListener(this);
		
		redNumberField = new JTextField("0");
		greenNumberField = new JTextField("0");
		blueNumberField = new JTextField("0");
		
		redNumberField.setFont(myFont);
		greenNumberField.setFont(myFont);
		blueNumberField.setFont(myFont);
		
		redNumberField.addActionListener(this);
		greenNumberField.addActionListener(this);
		blueNumberField.addActionListener(this);
		
		textLabel = new JLabel("Text", JLabel.CENTER);
		redLabel = new JLabel("Red");
		greenLabel = new JLabel("Green");
		blueLabel = new JLabel("Blue");
		
		textLabel.setFont(myFont);
		redLabel.setFont(myFont);
		greenLabel.setFont(myFont);
		blueLabel.setFont(myFont);
		
		Container container = getContentPane();
		container.setBackground(Color.WHITE);
		container.setLayout(new GridLayout(3,1));
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.setLayout(new GridLayout(2,3));
		panel2.setLayout(new GridLayout(2,3));
		
		panel1.add(redLabel);
		panel1.add(greenLabel);
		panel1.add(blueLabel);
		panel1.add(redNumberField);
		panel1.add(greenNumberField);
		panel1.add(blueNumberField);
		
		panel2.add(redPlus);
		panel2.add(greenPlus);
		panel2.add(bluePlus);
		panel2.add(redMinus);
		panel2.add(greenMinus);
		panel2.add(blueMinus);
		
		container.add(textLabel);
		container.add(panel1);
		container.add(panel2);
		
		setVisible(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == redPlus) {
			red += 15;
			checkValues();
		}
		if(e.getSource() == greenPlus) {
			green += 15;
			checkValues();
		}
		if(e.getSource() == bluePlus) {
			blue += 15;
			checkValues();
		}
		if(e.getSource() == redMinus) {
			red -= 5;
			checkValues();
		}
		if(e.getSource() == greenMinus) {
			green -= 5;	
			checkValues();
		}
		if(e.getSource() == blueMinus) {
			blue -= 5;
			checkValues();
		}
		
		if(e.getSource() == redNumberField) {
			textFieldUpdate();
		}
		if(e.getSource() == greenNumberField) {
			textFieldUpdate();
		}
		if(e.getSource() == blueNumberField) {
			textFieldUpdate();
		}
		
	}
	
	private void textFieldUpdate() {
		try {
			int tempR, tempG, tempB;
			tempR = Integer.parseInt(redNumberField.getText());
			tempG = Integer.parseInt(greenNumberField.getText());
			tempB = Integer.parseInt(blueNumberField.getText());
			
			if(tempR >= 0 && tempR <= 255) {
				red = tempR;
			}
			if(tempG >= 0 && tempG <= 255) {
				green = tempG;
			}
			if(tempB >= 0 && tempB <= 255) {
				blue = tempB;
			}
			
			textLabel.setForeground(new Color(red, green, blue));

			
		} catch (NumberFormatException ignore) { 
			
			
		}
		redNumberField.setText(Integer.toString(red));
		greenNumberField.setText(Integer.toString(green));
		blueNumberField.setText(Integer.toString(blue));
		
	}

	public void checkValues() {
		if(red < 0) {
			red += 255;
		}
		if(green < 0) {
			green += 255;
		}
		if(blue < 0) {
			blue += 255;
		}
		if(red > 255) {
			red -= 255;
		}
		if(green > 255) {
			green -= 255;
		}
		if(blue > 255) {
			blue -= 255;
		}
		System.out.println(red + " " + green + " " + blue);
		textLabel.setForeground(new Color(red, green, blue));
		redNumberField.setText(Integer.toString(red));
		greenNumberField.setText(Integer.toString(green));
		blueNumberField.setText(Integer.toString(blue));
	}
		
	
	public static void main(String[] args) {
		GUI myGUI = new GUI();

	}

	
}
