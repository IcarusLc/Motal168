package com.happy.dao;
import java.sql.*;
import com.happy.util.*;
import com.happy.dto.*;

public class UserInfoDAO {
   public boolean findUser(UserInfoDTO user)
   {
   	Connection conn=null;
   	PreparedStatement state=null;
   	ResultSet rs=null;
   	try{
   	  conn=DBUtil.getConnection();
   	  state=conn.prepareStatement("select * from UserInfo where userID=? and userPassword=?");
   	  state.setString(1,user.getUserID());
   	  state.setString(2,user.getUserPassword());
   	  rs=state.executeQuery();
   	  if(rs.next())
   	  {
   	  	return true;
   	  }
   	  else{
   	  	return false;
   	  }
   	}
   	catch(Exception e)
   	{
   		return false;
   	}
   	finally
   	{
   		try
   		{
   		  rs.close();
   		  state.close();
   	      conn.close();	
   		}
        catch(Exception e)
        { }
   	}
   	  
   } 
   public int addUser(UserInfoDTO user)
   {
   	Connection conn=null;
   	PreparedStatement state=null;
   	int flag=0;
   	try{
   		conn=DBUtil.getConnection();
   		state=conn.prepareStatement("insert into UserInfo values(?,?,?,?,?,?,?)");
   		state.setString(1,user.getUserID());
   		state.setString(2,user.getUserPassword());
   		state.setString(3,user.getUserSex());
   		state.setInt(4,user.getUserAge());
   		state.setString(5,user.getUserProvince());
   		state.setString(6,user.getUserHabit());
   		state.setString(7,user.getUserIntro());;
   		flag=state.executeUpdate();
   		return flag;
   	}
   	catch(Exception e)
   	{
   		return 0;
   	}
   	finally{
   		try{
   			state.close();
   			conn.close();
   		}
   		catch(Exception e)
   		{
   		}
   	}
   }
   
   public int removeUser(String id)
   {
   	Connection conn=null;
   	PreparedStatement state=null;
   	return 0;
   }
   
   public int updateUser(UserInfoDTO user)
   {
   	return 0;
   }
    
}