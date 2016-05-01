package DAO;

import DTO.MangerDTO;
import DBUtil.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MangerDAO {
	 public boolean findUser(MangerDTO user)
	   {
	   	Connection conn=null;
	   	PreparedStatement state=null;
	   	ResultSet rs=null;
	   	try{
	   	  conn=DBUtil.getConnection();
	   	  state=conn.prepareStatement("select * from T_Manger where F_UserID=? and F_PWD=?");
	   	  state.setString(1,user.getF_UserID());
	   	  state.setString(2,user.getF_PWD());
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
}}
