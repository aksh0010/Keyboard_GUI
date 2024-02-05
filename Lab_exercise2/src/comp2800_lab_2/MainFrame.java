package comp2800_lab_2;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;


public class MainFrame  {
	// creating private instances of components for our applications 
	private JFrame frame;
	private JPanel panel;
	private JPanel panel_display;
	private GridBagConstraints constraints;
	private JButton button;
	
	private JLabel instructions;
	private JTextArea display_area;
	
	
	public MainFrame() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Calculator");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLocation(100, 100);
		
		//Creating String array to store keyboard values
		String[] keys = {"~","1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "Backspace",
                "Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\",
                "CAPS", "A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "*", "Enter",
                "Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?","↑","SPACE",
                "←", "↓", "→"};
		
		// uncomment below code if you want to see index of keys becauses thats how I refereneced 
		// it later in my for loops below
//		for (int i=0;i<keys.length;i++) {
//			System.out.println(i+"  | "+keys[i]);
//		}
//			
		
		//Creating new JPanel with GridBagLayout where we will store the keyboard value
		panel = new JPanel(new GridBagLayout());
		frame.add(panel,BorderLayout.SOUTH);
		
		
		//CReating display panel to with border layout to store instructions and Blank area for outout
		panel_display= new JPanel(new BorderLayout());
		frame.add(panel_display,BorderLayout.NORTH);
		
		
		//Creating Label and creating display region
		instructions= new JLabel("Type text using your keyboard. The key you press will be highlighted and text will be displayed.");
		display_area = new JTextArea("");
		make_display(display_area);
		
		// Simply adding instruction to north of the panel and display to center of the panel
		
		panel_display.add(instructions,BorderLayout.NORTH);
		panel_display.add(display_area,BorderLayout.CENTER);
		
		// Now creating constraints for GridBagLayout.
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		
		//Now in this for loop there are 14 element added from the first row of calculator
		for(int i =0;i <=13;i++) {
			button = new JButton(keys[i]); // Creating the Button with symbol/name from our string array
			button_prop(button);
			if (i==13) {
				// here i =13 meaning it is "Backspace" bar so assigning it 2 gridwidth and filling it Horizontally
				constraints.gridx=13;
				constraints.gridy=0;
				constraints.gridwidth = 2;
				constraints.fill = GridBagConstraints.HORIZONTAL;
			} else {
				
				// For the remaining buttons we simple add them in gridY=0 and for gridx we simply use 1 ,2 ,3 and so on for buttons
			constraints.gridx=i;
			constraints.gridy=0;
			constraints.gridwidth = 1;
			constraints.fill = GridBagConstraints.NONE;
			}
		
	      
			
			panel.add(button,constraints); // simply adding each button to panel with GridBagLayout.
		}
		
		//Here in this for loop there are 14 element but we need to use correct  
		//symbol from our array so using i =14 and for its condition we simply make it i<=13+14

		for(int i =14;i <=13+14;i++) { 
			button = new JButton(keys[i]);  // Creating the Button with symbol/name from our string array
			button_prop(button);
			if (i==14) { 
				// here i =14 meaning it is "Tab" bar so assigning it 2 gridwidth and filling it Horizontally
				constraints.gridx=0;
				constraints.gridy=1;
				constraints.gridwidth = 2;
				 constraints.fill = GridBagConstraints.HORIZONTAL;
			} else {
				// Generic constraints for all other button
			constraints.gridx=i-13;
			constraints.gridy=1;
			constraints.gridwidth = 1;
			constraints.fill = GridBagConstraints.NONE;
				
			}
			
	       
			panel.add(button,constraints); // simply adding each button to panel with GridBagLayout.
		}
		//Here in this for loop there are 13 element but we need to use correct  
		//symbol from our array so using i =28 and for its condition we simply make it i<=12+28

		
		for(int i =28;i <=12+28;i++) {
			button = new JButton(keys[i]);
			button_prop(button);
			if (i==28) { // here i =28 meaning it is "Caps" bar so assigning it 2 gridwidth and filling it Horizontally
				constraints.gridx=0;
				constraints.gridy=2;
				constraints.gridwidth = 2;
				 constraints.fill = GridBagConstraints.HORIZONTAL;
			}else if(i==12+28) { // here i =12+28 meaning it is "ENTER" bar so assigning it 2 gridwidth and filling it Horizontally
				
				constraints.gridx=1+i-28; // Caps bar takes too much grid width so we have to add 1 to our other buttons gridx to make it visibile
				constraints.gridy=2;
				constraints.gridwidth = 2;
				constraints.fill = GridBagConstraints.HORIZONTAL;
				
			}else {
			// Caps bar takes too much grid width so we have to add 1 to our other buttons gridx to make it visibile
			constraints.gridx=1+i-28;
			constraints.gridy=2;
			constraints.gridwidth = 1;
			constraints.fill = GridBagConstraints.NONE;
				
			}
			
	       
			panel.add(button,constraints); // simply adding each button to panel with GridBagLayout.
		}
		
		//Here in this for loop there are 12 element but we need to use correct  
		//symbol from our array so using i =41 and for its condition we simply make it i<=11+41
		
		for(int i =41;i <=11+41;i++) {
			button = new JButton(keys[i]);
			button_prop(button);
			if (i==41) { // here i =28 meaning it is "Shift" bar so assigning it 2 gridwidth and filling it Horizontally
				constraints.gridx=0;
				constraints.gridy=3;
					constraints.gridwidth = 2;
				 constraints.fill = GridBagConstraints.HORIZONTAL;
			}else {
				// Shift bar takes too much grid width so we have to add 1 to our other buttons gridx to make it visibile
			constraints.gridx=1+i-41;
			constraints.gridy=3;
			constraints.gridwidth = 1;
			constraints.fill = GridBagConstraints.NONE;
				
			}
			
	       
			panel.add(button,constraints);// simply adding each button to panel with GridBagLayout.
		}
		
		//Here in this for loop there are 4 element but we need to use correct  
		//symbol from our array so using i =53 and for its condition we simply make it i<=3+53
		
		for(int i =53;i <=3+53;i++) {
			button = new JButton(keys[i]);
			button_prop(button);
			if (i==53) { // here i =53 meaning it is "Space" bar so assigning it 6 gridwidth and filling it Horizontally
				constraints.gridx=4;
				constraints.gridy=4;
					constraints.gridwidth = 6;
				 constraints.fill = GridBagConstraints.HORIZONTAL;
			}else {
				// Space bar takes too much grid width and is already on 4th element so we have to add 10 to our other buttons gridx to make it visibile
			constraints.gridx=10+i-53;
			constraints.gridy=4;
			constraints.gridwidth = 1;
			constraints.fill = GridBagConstraints.NONE;
				
			}
			
	       
			panel.add(button,constraints);// simply adding each button to panel with GridBagLayout.
		}
		
	frame.pack();
	}
	
	// Just a internal function to set display properties for looks and adding border
	private void make_display(JTextArea display) {
		// TODO Auto-gen	display_area.setEditable(false);
		display.setRows(15);
		display.setEditable(false);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		display.setBorder(border);
		
	}
	// Internal function to set button properties.
	private void button_prop(JButton Button) {
		button.setFocusable(false);
		button.setMargin(new Insets(0,20,0,20));	
	}
	
	// show method just sets the visibility of frame to be true
	public void show() {
		this.frame.setVisible(true);
	}
}