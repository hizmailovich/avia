package com.example.avia.controllers;

import com.example.avia.models.Cars;
import com.example.avia.repositories.CarsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class SalePageController {
    private static final Logger logger = LogManager.getLogger(SalePageController.class);

    @Autowired
    CarsRepository carsRepository;

    @GetMapping("/avia/salepage")
    public String salePageController(Model model) {
        logger.info("SalePageController - OK");
        Optional<Cars> car1 = carsRepository.findById(1L);
        Optional<Cars> car2 = carsRepository.findById(2L);
        ArrayList<Cars> carsList = new ArrayList<>();
        car1.ifPresent(carsList::add);
        car2.ifPresent(carsList::add);
        model.addAttribute("cars", carsList);
        return "SalePage";
    }
}
