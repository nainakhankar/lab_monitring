package com.server.desktop;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class SetPassword extends JFrame {
	static String port="4907";
	JButton SUBMIT;
	JPanel panel;
	JLabel label1,label2;
	JTextField text1,text2;
	String value1;
	String value2;
	JLabel label;
	
   public SetPassword(){
	   new InitConnection(Integer.parseInt(port),"vilas");
	
	}
	
	
	public String getValue1(){

		return "vilas";
	}
	

	public static void main(String[] args){

		SetPassword frame1= new SetPassword();
	    frame1.setSize(300,80); 				
	    frame1.setLocation(500,300);
		frame1.setVisible(true);	 
		
		}

}
