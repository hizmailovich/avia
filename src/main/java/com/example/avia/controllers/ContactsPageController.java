package com.example.avia.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactsPageController {
    private static final Logger logger = LogManager.getLogger(ContactsPageController.class);

    @GetMapping("/avia/contactspage")
    public String contactsController(Model model) {
        logger.info("ContactsController - OK");
        return "ContactsPage";
    }
}
