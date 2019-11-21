package com.campus2020.restclient.controller;

import com.campus2020.restclient.form.CarForm;
import com.campus2020.restclient.model.Car;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@RestController
public class RestClientController {

    @Autowired
    RestTemplate newRestemplate;

    static final String restApiServer = "http://rest-api/cars";

    public List<Car> getCars(){
        List<Car> result = newRestemplate.getForObject(restApiServer, List.class);
        return result;
    }

    public void saveCar(Car newCar){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Car> request =
                new HttpEntity<Car>(newCar, headers);
        Car carAsJsonStr = newRestemplate.postForObject(restApiServer, request, Car.class);
    }

    public Car getCar(Integer id){
        Car result = newRestemplate.getForObject(restApiServer + "/" + id, Car.class);
        return result;
    }

    public void deleteCar(Integer id){
        newRestemplate.delete(restApiServer + "/" + id);
    }
}
