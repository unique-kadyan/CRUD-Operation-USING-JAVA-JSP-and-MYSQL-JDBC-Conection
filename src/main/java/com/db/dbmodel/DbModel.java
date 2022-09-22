package com.db.dbmodel;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.db.User.User;

import jakarta.servlet.ServletResponse;

@SuppressWarnings("unused")
public class DbModel {
	public List<User> display(DataSource dataSource){
		Connection conn = null;
		ResultSet res = null;
		Statement st = null;
		List<User> list = new ArrayList<>();
		try {
			conn = dataSource.getConnection();
			String query = "SELECT * FROM USERS";
			st = conn.createStatement();
			res = st.executeQuery(query);
			//PrintWriter out = ServletResponse.getWriter();
			while(res.next())
			{
				//out.print("<br/>"+res.getString("email"));
				list.add(new User(res.getInt("idusers"), res.getString("name"),res.getString("email"),  res.getString("mobile")));
			}
		}
		catch(SQLException err)
		{
			err.printStackTrace();
		}
		return list;
	}
	public boolean adding(DataSource ds, User newuser)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ds.getConnection();
			String username = newuser.getName();
			String email = newuser.getEmail();
			String mob = newuser.getMob();
			String query = "INSERT INTO USERS(name,email,mobile) values (?,?,?)";
			ps =  conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, mob);
			return ps.execute();
		}
		catch(SQLException err){
			err.printStackTrace();
			return false;
		}
		
	}
	public boolean updating(DataSource ds, User upuser)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ds.getConnection();
			String username = upuser.getName();
			String email = upuser.getEmail();
			String mob = upuser.getMob();
			int id = upuser.getIdusers(); 
			String query = "UPDATE USERS SET name=? ,email = ? ,mobile = ? where idusers = ? ";
			ps =  conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, mob);
			ps.setInt(4, id);
			return ps.execute();
		}
		catch(SQLException err){
			err.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("null")
	public boolean deleting(DataSource ds, int id)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ds.getConnection();
			//String username = deluser.getName();
			//String email = deluser.getEmail();
			//String mob = deluser.getMob();
			//int id = deluser.getIdusers(); 
			String query = "DELETE FROM USERS where idusers = ? ";
			ps =  conn.prepareStatement(query);
//			ps.setString(1, username);
//			ps.setString(2, email);
//			ps.setString(3, mob);
			ps.setInt(1, id);
			return ps.execute();
		}
		catch(SQLException err){
			err.printStackTrace();
			return false;
		}
	}
	
}
