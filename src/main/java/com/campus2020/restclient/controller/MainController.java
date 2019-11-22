package com.campus2020.restclient.controller;

import com.campus2020.restclient.form.CarForm;
import com.campus2020.restclient.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private static List<Car> cars = new ArrayList<Car>();

    @Autowired
    RestClientController restClientController;

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    /**
     * @param model
     * @return
     */
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    /**
     * @param model
     * @return
     */
    @RequestMapping(value = {"/carList"}, method = RequestMethod.GET)
    public String carList(Model model) {

        model.addAttribute("cars", restClientController.getCars());

        return "carList";
    }

    @RequestMapping(value = "/carList/{id}", method = RequestMethod.GET)
    public String showCar(@PathVariable Integer id, Model model) {
        model.addAttribute("car", restClientController.getCar(id));

        return "carPage";
    }

    /**
     * @param model
     * @return
     */
    @RequestMapping(value = {"/addCar"}, method = RequestMethod.GET)
    public String showAddCarPage(Model model) {

        CarForm carForm = new CarForm();
        model.addAttribute("carForm", carForm);

        return "addCar";
    }

    /**
     * @param model
     * @param carForm
     * @return
     */
    @RequestMapping(value = {"/addCar"})
    public String saveCar(Model model, //
                          @ModelAttribute("carForm") CarForm carForm, BindingResult result) {
        String brand = carForm.getBrand();
        String version = carForm.getVersion();

        if (brand != null && brand.length() > 0 //
                && version != null && version.length() > 0) {
            Car newCar = new Car(brand, version);
            restClientController.saveCar(newCar);

            return "redirect:/carList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCar";
    }


    /**
     * @param model
     * @return
     */
    @RequestMapping(value = {"/editCar/{id}"}, method = RequestMethod.GET)
    public String showEditCarPage(@PathVariable Integer id, Model model) {
        Car car = restClientController.getCar(id);
        String brand = car.getBrand();
        String version = car.getVersion();
        CarForm carForm = new CarForm(brand, version);
        model.addAttribute("carForm", carForm);
        model.addAttribute("id", id);
        model.addAttribute("errorMessage", errorMessage);
        return "editCar";
    }

    /**
     * @param model
     * @param carForm
     * @return
     */
    @RequestMapping(value = {"/editCar/{id}"}, method = RequestMethod.POST)
    public String editCar(Model model, @PathVariable Integer id, //
                          @ModelAttribute("carForm") CarForm carForm, BindingResult result) {
        String brand = carForm.getBrand();
        String version = carForm.getVersion();
        Car editedCar = new Car();
        if(brand != null && brand.length() > 0) {
            editedCar.setBrand(brand);
        }
        if(version != null && version.length() > 0) {
            editedCar.setVersion(version);
        }

        restClientController.editCar(id, editedCar);

        return "redirect:/carList";

    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteCar(@PathVariable Integer id) {
        restClientController.deleteCar(id);
        return "carList";
    }


}