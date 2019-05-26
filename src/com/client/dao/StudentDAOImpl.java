package com.client.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.client.pojos.StudentPojo;
import com.client.utility.MyConnection;


public class StudentDAOImpl implements StudentDAO {
	public static Connection conn=null;
	
	@Override
	public boolean addStudent(StudentPojo student) {
		// TODO Auto-generated method stub
		conn = MyConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("Insert into student(first_name,last_name,password,dob,address,user_name) values(?,?,?,?,?,?)");
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setString(3, student.getPassword());
			ps.setString(4, student.getDob());
			ps.setString(5, student.getAddress());
			ps.setString(6, student.getUserName());
			int i = ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<StudentPojo> getAllStudents() {
		conn = MyConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select stud.*,att.ip_aadress,att.attendance_date from student stud,attendance att where stud.user_name=att.user_name and att.is_online='Yes'");
			ResultSet rs = ps.executeQuery();
			
			List<StudentPojo> studentList = new ArrayList<StudentPojo>();
			while(rs.next())
			{
				StudentPojo student = new StudentPojo();
				student.setId(rs.getLong("id"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setDob(rs.getString("dob"));
				student.setAddress(rs.getString("address"));
				student.setPassword(rs.getString("password"));
				student.setUserName(rs.getString("user_name"));
				student.setIp_address(rs.getString("ip_aadress"));
				student.setLast_login_on(rs.getString("attendance_date"));
				studentList.add(student);
				
			}
			return studentList;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean login(String userName, String password) {
		conn = MyConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from student where user_name=? and password=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
					
			if(rs.next())
			{
				return true;
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isOnline(String user_name) {
		conn = MyConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from attendance where user_name=? and is_online='Yes'");
			ps.setString(1, user_name);
			
			ResultSet rs = ps.executeQuery();
					
				if(rs.next())
				{
					return true;
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		

	}

	@Override
	public boolean setOnline(String user_name) {
		conn = MyConnection.getConnection();
		try {
			
			PreparedStatement ps = conn.prepareStatement("update attendance set is_online=? where user_name=?");
			ps.setString(2, user_name);
			ps.setString(1,"No");
			
			int i = ps.executeUpdate();
			
			PreparedStatement ps1 = conn.prepareStatement("update attendance set is_online=? where user_name=? ORDER BY id DESC LIMIT 1");
			ps1.setString(2, user_name);
			ps1.setString(1,"Yes");
			
			i = ps1.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean markAttendance(String user_name, String ip_aadress,
			String host_name, String is_online) {
		// TODO Auto-generated method stub
				conn = MyConnection.getConnection();
				try {
					PreparedStatement ps = conn.prepareStatement("Insert into attendance(user_name,ip_aadress,host_name,is_online,attendance_date) values(?,?,?,?,?)");
					ps.setString(1, user_name);
					ps.setString(2, ip_aadress);
					ps.setString(3, host_name);
					ps.setString(4, is_online);
					ps.setDate(5, new Date(System.currentTimeMillis()));
				
					int i = ps.executeUpdate();
					
					if(i>0)
					{
						return true;
					}
					else
					{
						return false;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return true;
				
	}

	@Override
	public boolean markPendrive(String user_name, String ip_aadress,
			String host_name, String is_pendrive) {
		// TODO Auto-generated method stub
		conn = MyConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("Insert into attendance(user_name,ip_aadress,host_name,is_online,attendance_date) values(?,?,?,?,?)");
			ps.setString(1, user_name);
			ps.setString(2, ip_aadress);
			ps.setString(3, host_name);
			ps.setString(4, is_pendrive);
			ps.setDate(5, new Date(System.currentTimeMillis()));
		
			int i = ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean addSystemInformation(String ipaddress, String username) {
		conn = MyConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("Insert into system_information(ipaddress,user_name) values(?,?)");
			ps.setString(1, ipaddress);
			ps.setString(2, username);
		
			int i = ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addUserRoles(String role, String username) {
		conn = MyConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("Insert into system_information(role_name,user_name) values(?,?)");
			ps.setString(1, role);
			ps.setString(2, username);
		
			int i = ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	

}
