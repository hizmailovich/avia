package com.example.avia.controllers;

import com.example.avia.repositories.CarsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class BrandsPageController {
    private static final Logger logger = LogManager.getLogger(BrandsPageController.class);

    @Autowired
    CarsRepository carsRepository;

    @GetMapping("/avia/brandspage")
    public String brandsPageController(Model model) {
        logger.info("BrandsPageController - OK");
        return "BrandsPage";
    }

    @GetMapping("/avia/brandspage/mersedes")
    public String mersedesPageController(Model model) {
        logger.info("BrandsPageController + Mersedes - OK");
        model.addAttribute("cars", carsRepository.findAllByBrand("Mercedes-Benz"));
        return "MersedesPage";
    }

    @GetMapping("/avia/brandspage/audi")
    public String audiPageController(Model model) {
        logger.info("BrandsPageController + Audi - OK");
        model.addAttribute("cars", carsRepository.findAllByBrand("Audi"));
        return "AudiPage";
    }

    @GetMapping("/avia/brandspage/bmw")
    public String bmwPageController(Model model) {
        logger.info("BrandsPageController + BMW - OK");
        model.addAttribute("cars", carsRepository.findAllByBrand("BMW"));
        return "BMWPage";
    }

    @GetMapping("/avia/brandspage/jaguar")
    public String jaguarPageController(Model model) {
        logger.info("BrandsPageController + Jaguar - OK");
        model.addAttribute("cars", carsRepository.findAllByBrand("Jaguar"));
        return "JaguarPage";
    }

    @GetMapping("/avia/brandspage/landrover")
    public String landRoverPageController(Model model) {
        logger.info("BrandsPageController + Land Rover - OK");
        model.addAttribute("cars", carsRepository.findAllByBrand("Land Rover"));
        return "LandRoverPage";
    }

    @GetMapping("/avia/brandspage/lexus")
    public String lexusPageController(Model model) {
        logger.info("BrandsPageController + Lexus - OK");
        model.addAttribute("cars", carsRepository.findAllByBrand("Lexus"));
        return "LexusPage";
    }

    @GetMapping("/avia/brandspage/porsche")
    public String porschePageController(Model model) {
        logger.info("BrandsPageController + Porsche - OK");
        model.addAttribute("cars", carsRepository.findAllByBrand("Porsche"));
        return "PorschePage";
    }

//    @RequestMapping(value = "/avia/brandspage/files/{filename:.+}", method = RequestMethod.GET, produces = "text/pdf")
//    @ResponseBody
//    public FileSystemResource getFile(@PathVariable String filename) {
//        //String path = dataProvider.getFullPath(filename);
//        return new FileSystemResource(new File(filename));
//    }
    /*@GetMapping("/avia/brandspage/{id}")
    public String morePageController(@PathVariable(value = "id") Long id,
                                     Model model) {
        logger.info("BrandsPageController + More - OK");

        Optional<Cars> cars = carsRepository.findById(id);
        ArrayList<Cars> carsList = new ArrayList<>();
        cars.ifPresent(carsList::add);
        model.addAttribute("cars", carsList);
        return "MorePage";
    }*/

}
