package com.example.avia.controllers;

import com.example.avia.Client;
import com.example.avia.ClientList;
import com.example.avia.ExcelBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DrivePageController {
    @Autowired
    private ExcelBuilder excelBuilder;
    @Autowired
    private ClientList clientList;
    private static final Logger logger = LogManager.getLogger(DrivePageController.class);

    @GetMapping("/avia/drivepage")
    public String drivePageController(Model model) {
        logger.info("DrivePageController - OK");
        return "DrivePage";
    }

    @PostMapping("/avia/drivepage")
    public String buttonPageController(@RequestParam String name,
                                       @RequestParam String phone,
                                       Model model) {
        logger.info("DrivePageController + test-drive - OK");
        Client client = new Client(name, phone, "Test-Drive");
        clientList.addClient(client);
        excelBuilder.buildExcel(clientList.getClientList());
        logger.info("Successfully added to excel!");
        return "SuccessfulRequest";
    }
}
