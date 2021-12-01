package com.example.avia.controllers;

import com.example.avia.exception.BadRequestException;
import com.example.avia.exception.InternalServerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    private static final Logger logger = LogManager.getLogger(HomePageController.class);

    @GetMapping("/avia/homepage")
    public String homePageController(Model model) {
        try {
            logger.info("HomePageController - OK");
            return "HomePage";
        } catch (NumberFormatException ex) {
            throw new BadRequestException();
        } catch (InternalServerException ex) {
            throw new InternalServerException();
        }
    }
}
