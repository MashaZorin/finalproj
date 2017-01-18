import java.lang.Math.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WolframAlpha extends JFrame implements ActionListener{
    private Container pane;
    private JLabel name = new JLabel("Wolfram Alpha");
    private JLabel intro = new JLabel("Enter what you want to calculate or know about:");
    private JTextField userInput = new JTextField(10);
    private JLabel tester = new JLabel();

    public WolframAlpha() {
	this.setTitle("Wolfram Alpha");
	this.setSize(500,250);
	this.setLocation(250,250);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	//TODO MAKE KEYBOARD SHORTCUT WORK
	JButton ent = new JButton("Enter");
        getRootPane().setDefaultButton(ent);
	ent.addActionListener(this);
	ent.setActionCommand("Start");
	pane.add(name);
	pane.add(intro);
	pane.add(userInput);
	pane.add(ent);
	pane.add(tester);

	userInput.setMaximumSize(new Dimension(600, 30));
    }

    /* Already Written
     * Arithmetic, as long as length is right
     * Add and Subtract Polynomials
     * Prime Factorize
     * Convert Base
     */

    //TODO try block here
    public void actionPerformed(ActionEvent e) {
	String event = e.getActionCommand();
	if(event.equals("Start")) {
	    String user = userInput.getText();
	    //System.out.println(user);
	    if(user.length() > 16 && user.substring(0,15).equals("prime factorize")) {
		//System.out.println("true");
		tester.setText(Numbers.primeFactorize(user.substring(16,user.length())));
		//System.out.println("set text");
	    }
	    else if(user.length() > 13 && user.substring(0,12).equals("convert base")) {
	    	String nums = user.substring(13,user.length());
		String[] terms = nums.split("\\s+");
		tester.setText(Numbers.convertBase(terms[0], terms[1], terms[2]));
	    }
	    else if(user.length() > 11 && user.substring(0,10).equals("arithmetic")){
		tester.setText(Numbers.arithmetic(user.substring(11,user.length())));	   
	    }
	    else if(user.length() > 9 && user.substring(0,8).equals("add poly")) {
		System.out.println("recog");
		String eqns = user.substring(9, user.length());
		System.out.println(eqns);
		tester.setText(Numbers.poly(eqns, 0));
	    }
	    else if(user.length() > 13 && user.substring(0,12).equals("subtract poly")) {
		String eqns = user.substring(9, user.length());
		Numbers.poly(eqns, 1);
	    }
	    else {
		tester.setText("Check your input to make sure you have correct spelling etc.");
	    }
	}
    }
    public static void main(String[]args){
	WolframAlpha g = new WolframAlpha();
	g.setVisible(true);
    }
	
}
