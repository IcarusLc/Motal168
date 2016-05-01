package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import DBUtil.DBUtil;
import DTO.CustomerDTO;

public class CoustomerDAO {
	 public static CustomerDTO findAll(CustomerDTO cDto)
	   {
	   	Connection conn2=null;
	   	PreparedStatement state2=null;
	   	ResultSet rs2=null;
	   	try{
	   	  conn2 = DBUtil.getConnection();
	   	  state2=conn2.prepareStatement("Select top 1 * from T_Customer where F_Num = ?");
	   	  state2.setString(1,cDto.getF_Num().trim());
	   	  rs2=state2.executeQuery();
	   	
	   	  if(rs2.next())
	   	  {
	   	  	cDto.setF_Name(rs2.getString("F_Name"));
	   	  	cDto.setF_Sex(rs2.getString("F_Sex"));
	   	  	cDto.setF_IDNum(rs2.getString("F_IDNum"));
	   	  	cDto.setF_Type(rs2.getString("F_Type"));
	   	  	cDto.setF_Num(rs2.getString("F_Num"));
	   	  	cDto.setF_Recharge(rs2.getString("F_Recharge"));
	   	  	
	   	  	return cDto;
	   	  }

	   	}
	   	catch(Exception e)
	   	{
	   		
	   		JOptionPane.showMessageDialog(null, "findall没有数据");
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
	   	
	   	return cDto;
	   }
	 
 public static int setAll(CustomerDTO cDto)
	   {
	 		Connection conn=null;
		   	PreparedStatement state=null;
		   	int flag=0;
		   	try{
		   		conn=DBUtil.getConnection();
		   		state=conn.prepareStatement("insert into T_Customer values(?,?,?,?,?,?)  update T_Room set F_State = '入住' where F_Num = ?  Insert into T_LaundryList(F_Name,F_Num,F_Type,F_Money,F_Time,F_Ps) values (?,?,'开房',?,GETDATE(),'消费')");
		   		state.setString(1,cDto.getF_Name());
		   		state.setString(2,cDto.getF_Sex());
		   		state.setString(3,cDto.getF_IDNum());
		   		state.setString(4,cDto.getF_Type());
		   		state.setString(5,cDto.getF_Num());
		   		state.setString(6,cDto.getF_Recharge());
		   		state.setString(7,cDto.getF_Num());
		   		
		   		
			   	 state.setString(8,cDto.getF_Name());
			   	 state.setString(9,cDto.getF_Num());
			   	 int i=Integer.valueOf(cDto.getF_Num()).intValue();
			   	 if(i/1000<3){
			   		 state.setString(10,"120");
			   	 }
			   	 else 
			   		 state.setString(10,"180");
			   		 
			   	 


		   		flag=state.executeUpdate();
		   		return flag;
		 	}
	   	catch(Exception e)
	   	{
	   		JOptionPane.showMessageDialog(null, "setall没有数据");
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
	 public  int AddVIP(CustomerDTO user)

	   {
	   	Connection conn=null;
	   	PreparedStatement state=null;
	   	ResultSet rs=null;
	   	try{
	   	  conn=DBUtil.getConnection();
	   	  state=conn.prepareStatement("Select F_Type from T_Customer where F_IDNum =?");
	   	  state.setString(1,user.getF_IDNum());
	   	  rs = state.executeQuery();
	   	  if(rs.next()){
	   		  if(rs.getString(1).trim().equals("会员"))
	   		  {
	   			  return 1;
	   		  }
	   		  else{
	   		  state=conn.prepareStatement("Update  T_Customer set F_Type = '会员' where F_IDNum = ? ");
		   	  state.setString(1,user.getF_IDNum());
		   	  int a = state.executeUpdate();
		   	  if(a>0)
		   	  {
		   	  	return 2;
		   	  }
		   	  else{
		   	  	return 0;
		   	  }
	   		  }
	   	  }
	   	  else{
	   	  state=conn.prepareStatement("Insert into T_Customer (F_Name,F_IDNum,F_Sex,F_Type) values (?,?,?,'会员') ");
	   	  state.setString(1,user.getF_Name());
	   	  state.setString(2,user.getF_IDNum());
	   	  state.setString(3,user.getF_Sex());
	   	  int a = state.executeUpdate();
	   	  if(a>0)
	   	  {
	   	  	return 3;
	   	  }
	   	  else{
	   	  	return 0;
	   	  }
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
	   		  state.close();
	   	      conn.close();	
	   		}
	        catch(Exception e)
	        { }
	   	}
}
	
}
