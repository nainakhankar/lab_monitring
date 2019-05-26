package com.client.system;


import java.io.*;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
public class USBDetection {
	public static void main(String args[])throws Exception
	{
		while(true)
		{
			
			String driveLetter = "";
			FileSystemView fsv = FileSystemView.getFileSystemView();
							
			File[] f = File.listRoots();
			for (int i = 0; i < f.length; i++) {
			  String drive = f[i].getPath();
			  String displayName = fsv.getSystemDisplayName(f[i]);
			  String type = fsv.getSystemTypeDescription(f[i]);
			  boolean isDrive = fsv.isDrive(f[i]);
			  boolean isFloppy = fsv.isFloppyDrive(f[i]);
			  boolean canRead = f[i].canRead();
			  boolean canWrite = f[i].canWrite();
			  System.out.println("	type="+type);			
			  if ((type.toLowerCase().equalsIgnoreCase("removable") || type.toLowerCase().equalsIgnoreCase("rimovibile") || type.toLowerCase().equalsIgnoreCase("USB Drive"))) {
			   System.out.println("Detected PEN Drive: " + drive + " - "+ displayName);
			   JOptionPane.showMessageDialog(null, "Detected PEN Drive: " + drive + " - "+ displayName);
			    driveLetter = drive;
			    break;
			  }						
			}
							
			if (driveLetter.equals("")) {
			  // USB Drive not found
			  // ....			
			} else {
			  // USB drive found: driveLetter
			  // ...
			}
		}
	}

}
