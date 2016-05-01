package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DBUtil.DBUtil;
import DTO.LaundryListDTO;

public class LaundryListDAO {
		 public static LaundryListDTO findTP(LaundryListDTO lDto)
		   {
		   	Connection conn2=null;
		   	PreparedStatement state2=null;
		   	ResultSet rs2=null;
		   	try{
		   	  conn2 = DBUtil.getConnection();
		   	  state2=conn2.prepareStatement("Select * from T_LaundryList where F_Num = ? and F_Type = '开房'");
		   	  state2.setString(1,lDto.getF_Num().trim());
		   	 
		   	  rs2=state2.executeQuery();
		   	  if(rs2.next())
		   	  {
//		   		lDto.setF_Money(rs2.getDouble("F_Money"));
		   		lDto.setF_Time(rs2.getString("F_Time"));
		   		lDto.setF_Type(rs2.getString("F_Type"));		   		
		   	  	return lDto;
		   	  }

		   	}
		   	catch(Exception e)
		   	{
		   		JOptionPane.showMessageDialog(null, "TP没有数据");
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
		   	
		   	return lDto;
	}
		 public static LaundryListDTO findSum(LaundryListDTO lDto)
		   {
		   	Connection conn2=null;
		   	PreparedStatement state2=null;
		   	ResultSet rs2=null;
		   	try{
		   	  conn2 = DBUtil.getConnection();
		   	  state2=conn2.prepareStatement("Select SUM(F_Money) from T_LaundryList where F_num = ? and F_Ps = '消费'" );
		   	  state2.setString(1,lDto.getF_Num().trim());
		   	  rs2=state2.executeQuery();
		   	
		   	  if(rs2.next())
		   	  {
		   		lDto.setF_Money(rs2.getDouble(1));
		   	  	return lDto;
		   	  }
		   	}
		   	catch(Exception e)
		   	{
		   		//JOptionPane.showMessageDialog(null, "没有数据");
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
		   	
		   	return lDto;
	}
			public boolean Add(LaundryListDTO record)
			   {
			   	Connection conn=null;
			   	PreparedStatement state=null;
			   	try{
			   	  conn=DBUtil.getConnection();
			   	  state=conn.prepareStatement("Insert into T_LaundryList(F_Name,F_Num,F_Type,F_Money,F_Time,F_Ps) values (?,?,?,?,GETDATE(),?)");
			   	  state.setString(1,record.getF_Name());
			   	  state.setString(2,record.getF_Num());
			   	  state.setString(3,record.getF_Type());
			   	  state.setDouble(4,record.getF_Money());
			   	  state.setString(5,record.getF_Ps());
			   	  int a  = state.executeUpdate();
			   	  if(a > 0)
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


			//查询所有用户，返回一个ArrayList
			public ArrayList LaundryRoom(String str)
			{
				Connection conn=null;
				//Statement statement=null;
				PreparedStatement statement=null;
		   		ResultSet rs=null;
		   		ArrayList list=new ArrayList();
		   		try
		   		{
		   			String sql;
		   			conn=DBUtil.getConnection();
		   			//... statment好像没有实例化啊
		   			
		   			if (str == null){
		   				sql = "select * from T_LaundryList where F_Ps = \'消费\'";
		   				
		   			 
		   			 }
		   			else {
		   				sql = "select * from T_LaundryList where F_Num = \'"+str+"\' and F_Ps = \'消费\'";
		   			}

		   			//rs=statement.executeQuery("select * from T_LaundryList where F_Num = ?");
		   			statement = conn.prepareStatement(sql); //你刚刚没有这一句  所以statement其实没有实例化
		   			System.out.println("====="+sql+"====");
		   			// statement.setString(1,str);
		   			 rs= statement.executeQuery();
		   			//statement.setString(1,"001"); //获得文本框里的 line.getF_Room() 这个就是你从外面传入的参数 所以传进来的就是Null
		   			while(rs.next())
		   			{
		   				//创建一个DTO对象用于存储和传输数据
		   				LaundryListDTO line1 =new LaundryListDTO();
		   				
		   				//通过set方法给DTO对象属性赋值	
		   				line1.setF_Name(rs.getString(2));
		   				line1.setF_Num(rs.getString(3));
		   				line1.setF_Money(rs.getDouble(4));
		   				line1.setF_Type(rs.getString(5));
		   				line1.setF_Time(rs.getString(6));
		   				line1.setF_Ps(rs.getString(7));
		   				
		   				
		   				//将DTO对象增加到集合中
		   				list.add(line1);
		   			}
		   			//返回集合
		   			return list;
		   		}
			catch(Exception ex)
				{
				System.out.println(ex);
						System.out.println("数据库操作失败！");
						return null;
				}
				finally
				{
				 try
				  {
					rs.close();
					statement.close();
				    conn.close();	
					}
					catch(Exception ex1)
					{
						System.out.println(ex1);
					System.out.println("数据库关闭失败！");
					}
				}
			}
			
			//修改用户信息方法，返回一个boolean类型的变量
			//在实际开发时，建议大家返回一个整数，表示受影响的行数
			
			public boolean Cancel(String a)
			   {
			   	Connection conn=null;
			   	PreparedStatement state=null;
			   	try{
			   	  conn=DBUtil.getConnection();
			   	  state=conn.prepareStatement("Update  T_LaundryList set F_Ps = '已付款' where F_Ps = '消费' and F_Num =\'"+a+"\'    Update T_Room set F_State ='空闲' where F_Num =\'"+a+"\'");
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

			public double getsum(String str){
				
				Connection conn=null;
				//Statement statement=null;
				PreparedStatement statement=null;
				ResultSet rs=null;
				double a;
				
				try
		   		{
					
		   			String sql;
		   			conn=DBUtil.getConnection();
		   			
		   			sql = "SELECT SUM(F_Money) FROM T_LaundryList WHERE   F_Num = \'"+str+"\' and F_Ps ='消费'";
		   			statement = conn.prepareStatement(sql); 
		   			rs = statement.executeQuery();
		   			if(rs.next())
		   			{
		   				a = rs.getDouble(1);
		   				return a;
		   			}
		   			else {
		   				return 0;
		   			}
		   			
		   		}
			catch(Exception ex)
				{
				System.out.println(ex);
						System.out.println("数据库操作失败！");
						return 0;
				}
				finally
				{
				 try
				  {
					
					statement.close();
				    conn.close();	
					}
					catch(Exception ex1)
					{
						System.out.println(ex1);
					System.out.println("数据库关闭失败！");
					}
				}
			}
		
}



