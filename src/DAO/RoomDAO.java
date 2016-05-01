package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import DBUtil.DBUtil;
import DTO.RoomDTO;

public class RoomDAO {
	public boolean Clear(RoomDTO room)
	   {
	   	Connection conn=null;
	   	PreparedStatement state=null;
	   	try{
	   	  conn=DBUtil.getConnection();
	   	  state=conn.prepareStatement("Update  T_Room set F_State = '空闲' where F_State = '预定'");
	
	   	  if(state.executeUpdate()>0)
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
	   		  state.close();
	   	      conn.close();	
	   		}
	        catch(Exception e)
	        { }
	   	}
}
	public static boolean[] Room()
	   {
	   	Connection conn2=null;
	   	PreparedStatement state2=null;
	   	ResultSet rs2=null;
	   	boolean[] rm = new boolean[261];
	   	for(int i = 0;i<260;i++)
	   		rm[i]=false;
	   	try{
	   	  conn2 = DBUtil.getConnection();
	   	  state2=conn2.prepareStatement("Select F_Num from T_Room where F_State = '入住'");
	   	  rs2=state2.executeQuery();
	   	  
	   	  while(rs2.next())
	   	  {
	   	  	String aString = rs2.getString(1);
	   	  	int i=Integer.parseInt(aString.trim());
	   	  	if(i/1000>2){
	   	  		i = i%1000+160;
	   	  	}
	   	  	else if(i/1000==2){
	   	  		i = i%1000+80;
	   	  	}
	   	  	else 
	   	  		i = i%1000;
	   	  	
	   	  
	   	  	rm[i] = true;
	   	  }
	   	 

	   	}
	   	catch(Exception e)
	   	{
	   		
	   		JOptionPane.showMessageDialog(null, "room没有数据");
	   	}
	   	finally{
	   		try
	   		{
	   		  rs2.close();
	   		  state2.close();
	   	      conn2.close();	
	   		}
	        catch(Exception e)
	        { }
	   	}

	   	return rm;
	   }
	public static int setState(RoomDTO rDto){
		Connection conn=null;
	   	PreparedStatement state=null;
	   	int flag=0;
	   	try{
	   		conn=DBUtil.getConnection();
	   		state=conn.prepareStatement("Update T_Room set F_State = ?  where F_Num = ?");
	   		state.setString(1,rDto.getF_State());
	   		state.setString(2,rDto.getF_Num());
	   		

	   		flag=state.executeUpdate();
	   		return flag;
	 	}
   	catch(Exception e)
   	{
   		JOptionPane.showMessageDialog(null, "没有数据");
   	}
   	finally{
   		try
   		{
   		  state.close();
   	      conn.close();	
   		}
        catch(Exception e){
        	
        }
   	}
   	
   	return 0;
   }
	
}
