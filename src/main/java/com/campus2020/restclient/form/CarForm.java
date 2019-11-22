package com.campus2020.restclient.form;

/**
 *
 */
public class CarForm {
 
	private String id;
    private String brand;
    private String version;

    public CarForm(){}

    public CarForm(String brand, String version){
        this.brand = brand;
        this.version = version;
    }

    public String getId() {
    	return id;
    }

    public void setId(String id) {
    	this.id = id;
    }

    public String getBrand() {
        return brand;
    }
 
    public void setBrand(String brand) {
        this.brand = brand;
    }
 
    public String getVersion() {
        return version;
    }
 
    public void setVersion(String version) {
        this.version = version;
    }
    
}
     