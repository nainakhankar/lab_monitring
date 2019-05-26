package com.client.desktop;



import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.net.Socket;

class Authenticate extends JFrame implements ActionListener{
			private Socket cSocket = null;
			DataOutputStream psswrchk = null;
			DataInputStream verification = null;
			String verify ="";
			JButton SUBMIT;
			JPanel panel;
			JLabel label, label1;
			String width="",height="";

public Authenticate(Socket cSocket){
				
				this.cSocket = cSocket;
		



				
				
				try{
				psswrchk= new DataOutputStream(cSocket.getOutputStream());
				verification= new DataInputStream(cSocket.getInputStream());
				psswrchk.writeUTF("vilas");
				verify=verification.readUTF();
	
				}catch (IOException e){
				e.printStackTrace();
				}

				if(verify.equals("valid")){
				try{
				width = verification.readUTF();
				height = verification.readUTF();
		
				}catch (IOException e){
				e.printStackTrace();		
				}
				CreateFrame abc= new CreateFrame(cSocket,width,height);
				//dispose();
				}
				else {
				System.out.println("enter the valid password");
				JOptionPane.showMessageDialog(this, "Incorrect  password", "Error", JOptionPane.ERROR_MESSAGE);
				//dispose();
				}

				
				}


public void actionPerformed(ActionEvent ae){}
			
	}

