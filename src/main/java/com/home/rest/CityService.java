package com.home.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/CityService")
public class CityService {

   CityDao cityDao = new CityDao();

   @GET
   @Path("/cities")
   @Produces(MediaType.APPLICATION_JSON)
   public List<City> getCities(){
      return cityDao.getCities();
   }	
   @GET
   @Path("/city/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public List<City> getCity(@PathParam("id") String ids){
	   System.out.println("id value in CityService getCity():::" + String.valueOf(ids));
      return cityDao.getCity(ids);
   }
   @PUT
   @Consumes({MediaType.APPLICATION_JSON})
   @Produces({MediaType.TEXT_PLAIN})
   @Path("/city/update")
   public String updateCity(City city) throws Exception{
	   cityDao.updateCity(city);
       System.out.println(" city.getName() in SERVICE PUT = " + city.getName());       
       return "ok";
   }

}