package com.home.rest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class CityDao{
	 
	private static final String update = "UPDATE city SET name=?, CountryCode=?, district=?, population=? WHERE id=?";
    
	private Connection getConnection()
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/WORLD","root","root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public List<City> getCities(){
	      List<City> cityList = null;
	      Connection con = null;
			try{
			    Statement stmt=getConnection().createStatement();
				ResultSet rs=stmt.executeQuery("select * from city");
				cityList = new ArrayList<City>();
				
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
					City city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					cityList.add(city);
				}
				con.close();
	            return cityList;
			}catch(Exception e){ 
				System.out.println(e);
			}
			return cityList;
	   }
   public List<City> getCity(String id){
	      List<City> cityList = null;
	      Connection con = null;
			try{
				System.out.println("id value in getCity():::" + id);
				con = getConnection();
			    Statement stmt= con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from city where id=" + Integer.parseInt(id));
				cityList = new ArrayList<City>();
				
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
					City city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					cityList.add(city);
				}
				con.close();
	            return cityList;
			}catch(Exception e){ 
				System.out.println(e);
			}
			return cityList;
	   }
	   public int updateCity(City city){
		   int result = 0;
		   Connection con = null;
        System.out.println("updateCity in CityDao");
        System.out.println("getCountryCode:" + city.getCountryCode() 
             + "--getPopulation---::" + city.getPopulation() 
             +	"--getId::" + city.getId());
		   
		   try {
        		con = getConnection();
				PreparedStatement ps = con.prepareStatement(update);
	            ps.setString(1, city.getName()); 
	            ps.setString(2, city.getCountryCode()); 
	            ps.setString(3, city.getDistrict());
	            ps.setString(4, city.getPopulation());
	            ps.setInt(5, city.getId());
	            result = ps.executeUpdate(); // Execute Query
	            System.out.println("result::::" + result);
	           // con.commit();
	            ps.close();
	            con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        return result;
	}
}