package com.test.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.DB.DB;
import com.test.model.User;

public class UserDaoImp implements UserDao{

	@Override
	public void signup(User user) {
		
		String sql="insert into user(fname,lname,username,password)values(?,?,?,?)";
		try {
			PreparedStatement pstm=DB.getDb().prepareStatement(sql);
			
			pstm.setString(1, user.getFname());
			pstm.setString(2, user.getLname());
			pstm.setString(3, user.getUsername());
			pstm.setString(4, user.getPassword());
			pstm.execute();
			System.out.println("Insert data successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean login(String un, String psw) {
		String sql="select *from user where username='"+un+"'and password='"+psw+"' ";
		try {
			Statement st=DB.getDb().createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			if(rs.next())
			{
			return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<User> getAllUser() {

		List<User> ulist=new ArrayList<>(); 
		  String sql="SELECT * FROM user";
		  try {
			Statement stm=DB.getDb().createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				
				ulist.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return ulist;
	}

}
