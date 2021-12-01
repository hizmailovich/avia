package com.example.avia.controllers;

import com.example.avia.models.Cars;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminPageController {
    private static final Logger logger = LogManager.getLogger(AdminPageController.class);

    @GetMapping("/avia/adminpage")
    public String adminPageController(Model model) {
        logger.info("AdminPageController - OK");
        return "AdminPage";
    }

    @PostMapping("/avia/adminpage")
    public String buttonPageController(@RequestParam String login,
                                          @RequestParam String password,
                                          Model model) {
        String _login = "Adminavia585";
        String _password = "Adminlogpassword123";
        logger.info("AdminPageController + login - OK");
        if (_login.equals(login) && _password.equals(password)) {
            logger.info("Successfully LogIn!");
            return "redirect:/avia/datapage";
        }
        return "AdminPage";
    }
}
