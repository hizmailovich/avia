package com.example.avia;


import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ExcelFile {
    public static final File sheet = new File("Sheet.xls");
}
