package com.client.desktop;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.client.utility.MyConnection;

public class BarChartExample extends JFrame {
String username;
  private static final long serialVersionUID = 1L;

  public BarChartExample(String appTitle,String username) {
    super(appTitle);
System.out.println();
    // Create Dataset
this.username=username;
    CategoryDataset dataset = createDataset();
   
    //Create chart
    JFreeChart chart=ChartFactory.createBarChart(
        "Student Attandance System"+username, //Chart Title
        "Months", // Category axis
        "No Of Days Presents", // Value axis
        dataset,
        PlotOrientation.VERTICAL,
        true,true,false
       );

    ChartPanel panel=new ChartPanel(chart);
    setContentPane(panel);
    
    addWindowListener(new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
    
    
    
  }

  private CategoryDataset createDataset() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Population in 2005
    
    
   Connection conn = MyConnection.getConnection();
	try {
		PreparedStatement ps = conn.prepareStatement("select count(*),DATE_FORMAT(attendance_date, '%Y-%m'),user_name from attendance where user_name=? group by DATE_FORMAT(attendance_date, '%Y-%m')");
		ps.setString(1, username);
		
		ResultSet rs = ps.executeQuery();
				
			while(rs.next())
			{
				float days=rs.getFloat(1);
				String date=rs.getString(2);
				System.out.println(days+" "+date.split("-")[0]+" "+ date.split("-")[1]);
				 dataset.addValue(days, ""+date.split("-")[0], date.split("-")[1]);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    
   

    return dataset;
  }

  public static void main(String[] args) throws Exception {
   
      BarChartExample example=new BarChartExample("Bar Chart Window","ram");
      example.setSize(800, 400);
      example.setLocationRelativeTo(null);
 
      example.setVisible(true);
   
  }
}