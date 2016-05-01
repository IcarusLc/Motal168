package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBUtil.DBUtil;
import DTO.ThingDTO;

public class ThingDAO {
	public int Store(ThingDTO record)
	   {
	   	Connection conn=null;
	   	PreparedStatement state=null;
	   	ResultSet rs=null;
	   	try{
	   	  conn=DBUtil.getConnection();
	   	  state=conn.prepareStatement("Insert into T_Thing values (?,?,?)");
	   	  state.setString(1,record.getF_Name());
	   	  state.setString(2,record.getF_Room());
	   	  state.setString(3,record.getF_PWD());
	   	  int a  = state.executeUpdate();
	   	  if(a > 0)
	   	  {
	   		state=conn.prepareStatement("Select MAX(F_ID) from T_Thing");  
	   			rs = state.executeQuery();
	   			if(rs.next()){
		   			return rs.getInt(1);
		   		}
		   	  	return 0;
	   	  }
	   	  else{
	   	  	return 0;
	   	  }
	   	}
	   	catch(Exception e)
	   	{
	   		return 0;
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
	public boolean Get(ThingDTO thing)
	   {
		Connection conn=null;
	   	PreparedStatement state=null;
	   	ResultSet rs=null;
	   	try{
	   	  conn=DBUtil.getConnection();
	   	  state=conn.prepareStatement("Select * from T_Thing where F_ID = ? and F_PWD = ?");
	   	  state.setInt(1,thing.getF_ID());
	   	  state.setString(2,thing.getF_PWD());
	   	  rs=state.executeQuery();
	   	  if(rs.next())
	   	  {
	   		state=conn.prepareStatement("Delete from T_Thing where F_ID = ?");
	   		state.setInt(1,thing.getF_ID());
	   		state.executeUpdate();
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
}
