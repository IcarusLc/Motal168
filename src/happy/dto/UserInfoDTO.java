package com.happy.dto;

public class UserInfoDTO {
   private String userID;
   private String userPassword;
   private String userSex;
   private int userAge;
   private String userProvince;
   private String userHabit;
   private String userIntro;
   
   public void setUserID(String userID)
   {
	this.userID=userID;
   }
   public String getUserID()
   {
	return this.userID;
   }
   
   public void setUserPassword(String userPassword)
   {
	this.userPassword=userPassword;
   }
   public String getUserPassword()
   {
   	return this.userPassword;
   }
   
   public void setUserSex(String userSex)
   {
   	this.userSex=userSex;
   }
   public String getUserSex()
   {
   	return userSex;
   }
   
   public void setUserAge(int userAge)
   {
   	this.userAge=userAge;
   }
   public int getUserAge()
   {
   	return this.userAge;
   }
   
   public void setUserProvince(String userProvince)
   {
   	this.userProvince=userProvince;
   }
   public String getUserProvince()
   {
   	return this.userProvince;
   }
   
   public void setUserHabit(String userHabit)
   {
   	this.userHabit=userHabit;
   } 
   public String getUserHabit()
   {
   	return userHabit;
   } 
   	
   public void setUserIntro(String userIntro)
   {
   	this.userIntro=userIntro;
   }
   public String getUserIntro()
   {
   	return this.userIntro;
   }
   
}