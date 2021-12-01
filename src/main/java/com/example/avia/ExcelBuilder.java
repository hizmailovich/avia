package com.example.avia;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ExcelBuilder {

    private static final Logger logger = LogManager.getLogger(ExcelBuilder.class);

    public void buildExcel(List<Client> clientList) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Call-Centre List");
        sheet.setDefaultColumnWidth(20);
        HSSFRow header = sheet.createRow(0);
        int rowCount = 1;

        header.createCell(0).setCellValue("Name");
        header.createCell(1).setCellValue("Phone number");
        header.createCell(2).setCellValue("Reason of the request");

        for (Client client : clientList) {
            HSSFRow row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(client.getName());
            row.createCell(1).setCellValue(client.getPhone());
            row.createCell(2).setCellValue(client.getReason());
        }
        try {
            FileOutputStream out = new FileOutputStream(ExcelFile.sheet);
            workbook.write(out);
            out.close();
            logger.info("Excel sheet is created");
        } catch (IOException e) {
            logger.error("Creating error");
            e.printStackTrace();
        }
    }
}