package com.example.avia.controllers;

import com.example.avia.models.Cars;
import com.example.avia.repositories.CarsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class DataPageController {
    private static final Logger logger = LogManager.getLogger(DataPageController.class);

    @Autowired
    CarsRepository carsRepository;

    @GetMapping("/avia/datapage")
    public String dataPageController(Model model) {
        logger.info("DataPageController - OK");
        Iterable<Cars> cars = carsRepository.findAll();
        model.addAttribute("cars", cars);
        return "DataPage";
    }
    @GetMapping("/avia/datapage/add")
    public String addPageController(Model model) {
        logger.info("DataPageController + add - OK");
        Iterable<Cars> cars = carsRepository.findAll();
        model.addAttribute("cars", cars);
        return "DataPage-add";
    }
    @PostMapping("/avia/datapage/add")
    public String buttonAddPageController(@RequestParam String brand,
                                          @RequestParam String model,
                                          @RequestParam String transmission,
                                          @RequestParam Integer year,
                                          @RequestParam String price,
                                          @RequestParam String description,
                                          @RequestParam("imagefile") MultipartFile imageFile,
                                          @RequestParam String pdfId,
                                          Model _model) throws IOException {
        logger.info("DataPageController + add + button - OK");
        Cars car = new Cars(brand, model, transmission, year, price, description, imageFile.getBytes(), pdfId);
        logger.info("Successfully added!");
        carsRepository.save(car);
        return "redirect:/avia/datapage";
    }
    @GetMapping("/avia/datapage/edit")
    public String editPageController(Model model) {
        logger.info("DataPageController + edit - OK");
        Iterable<Cars> cars = carsRepository.findAll();
        model.addAttribute("cars", cars);
        return "DataPage-edit";
    }
    @PostMapping("/avia/datapage/edit")
    public String buttonEditPageController(@RequestParam long id,
                                          @RequestParam String brand,
                                          @RequestParam String model,
                                          @RequestParam String transmission,
                                          @RequestParam Integer year,
                                          @RequestParam String price,
                                           @RequestParam String pdfId,
                                          @RequestParam String description,
                                          Model _model) {
        logger.info("DataPageController + edit + button - OK");
        Cars car = carsRepository.findById(id).orElseThrow();
        car.setBrand(brand);
        car.setModel(model);
        car.setTransmission(transmission);
        car.setYear(year);
        car.setPrice(price);
        car.setPdf(pdfId);
        car.setDescription(description);
        carsRepository.save(car);
        logger.info("Successfully edited!");
        return "redirect:/avia/datapage";
    }
    @GetMapping("/avia/datapage/remove")
    public String removePageController(Model model) {
        logger.info("DataPageController + remove - OK");
        Iterable<Cars> cars = carsRepository.findAll();
        model.addAttribute("cars", cars);
        return "DataPage-remove";
    }
    @PostMapping("/avia/datapage/remove")
    public String buttonRemovePageController(@RequestParam long id,
                                           Model _model) throws IOException {
        logger.info("DataPageController + remove + button - OK");
        Cars car = carsRepository.findById(id).orElseThrow();
        carsRepository.delete(car);
        logger.info("Successfully removed!");
        return "redirect:/avia/datapage";
    }
}
