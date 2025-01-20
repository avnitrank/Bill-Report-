package com.example.Bill_Generation.Service;

import com.example.Bill_Generation.Model.Product;
import com.example.Bill_Generation.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class ReportService {

    @Autowired
    ProductRepository productRepository;

    public void generateReport() throws IOException {
        List<Product> products = productRepository.findAll();
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String filePath = "src/main/resources/reports/products_inventory_report_" + date + ".csv";

        try (ICsvBeanWriter beanWriter = new CsvBeanWriter(new FileWriter(filePath), CsvPreference.STANDARD_PREFERENCE)) {
            String[] header = {"ProductId", "ProductName", "Price", "Inventory"};
            beanWriter.writeHeader(header);

            for (Product product : products) {
                beanWriter.write(product, header);
            }
        }
    }
}
