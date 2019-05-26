package com.client.system;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CheckSystemProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		    String line;
		    
		    // String findProcess = "chrome.exe";
		    //  String filenameFilter = "/nh /fi \"Imagename eq "+findProcess+"\"";
		    // String tasksCmd = System.getenv("windir") +"/system32/tasklist.exe "+filenameFilter;
		    // Process p = Runtime.getRuntime().exec("ps -e");
		    Process p = Runtime.getRuntime().exec
		    	    (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
		    
		   
		    BufferedReader input =
		            new BufferedReader(new InputStreamReader(p.getInputStream()));
		    while ((line = input.readLine()) != null) {
		        System.out.println(line);
		        
		      /* if(line.contains("chrome.exe"))
			    {
			    	System.out.println("chrome ############");
			    }*/
		        
		        //<-- Parse data here.
		    }
		    input.close();
		} catch (Exception err) {
		    err.printStackTrace();
		}

	}

}
