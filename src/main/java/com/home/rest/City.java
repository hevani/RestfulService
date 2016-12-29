package com.home.rest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "city")
public class City implements Serializable {

private static final long serialVersionUID = 1L;
   private int id;
   private String name;
   private String countryCode;
   private String district;
   private String population;

   public City(){}
   
   public City(int id,String name, String countryCode, String district, String population){
      this.id = id;
	  this.name = name;
      this.countryCode = countryCode;
      this.district = district;
      this.population = population;
   }

   public int getId() {
		return id;
   }
   //@XmlElement
   public void setId(int id) {
		this.id = id;
   }
   public String getName() {
      return name;
   }
   //@XmlElement
   public void setName(String name) {
      this.name = name;
   }
   
	public String getCountryCode() {
		return countryCode;
	}
	
	//@XmlElement
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getDistrict() {
		return district;
	}
	//@XmlElement
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getPopulation() {
		return population;
	}
	//@XmlElement
	public void setPopulation(String population) {
		this.population = population;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}		
}
