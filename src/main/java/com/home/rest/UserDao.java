package com.home.rest;

import java.io.File;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
   public List<User> getAllUsers(){
      List<User> userList = null;
      try {
            User user = new User(1, "Mahesh", "Teacher");
            userList = new ArrayList<User>();
            userList.add(user);
      } catch (Exception e) {
         e.printStackTrace();
      } 	
      return userList;
   }   
}