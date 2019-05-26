package com.client.dao;

import java.util.List;

import com.client.pojos.StudentPojo;

public interface StudentDAO {
	
	public boolean addStudent(StudentPojo student);
	public List<StudentPojo> getAllStudents();
	public boolean login(String userName,String password);
	public boolean isOnline(String user_name );
	public boolean setOnline(String user_name);
	public boolean markAttendance(String user_name,String ip_aadress,String host_name,String is_online);
	public boolean markPendrive(String user_name,String ip_aadress,String host_name,String is_pendrive);
	public boolean addSystemInformation(String ipaddress,String username);
	public boolean addUserRoles(String role,String username);
	
	
	
}
