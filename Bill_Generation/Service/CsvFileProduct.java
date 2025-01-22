package com.example.Bill_Generation.Service;

import com.example.Bill_Generation.Model.Product;
import com.example.Bill_Generation.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;
import java.io.IOException;





import java.util.List;

@Service
public class CsvFileProduct {

    @Autowired
    private ProductRepository productRepository;

    @Scheduled(fixedRate = 6000) // Adjust this rate as needed
    public String exportToCsv() {
        String desktopPath = System.getProperty("user.home") + "/Desktop/product.csv";

        // Fetch all products from the repository
        List<Product> products = productRepository.findAll();

        try (ICsvBeanWriter writer = new CsvBeanWriter(new FileWriter(desktopPath), CsvPreference.STANDARD_PREFERENCE)) {
            // Write header row (matching the field names in the Product class)
            String[] header = {"productId", "productName", "price", "inventory"};
            writer.writeHeader(header);

            // Write each product's data
            for (Product product : products) {
                writer.write(product, header);
            }

            System.out.println("CSV file created successfully at: " + desktopPath);
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
            return "Failed to generate CSV file.";
        }

        return "CSV file created successfully at: " + desktopPath;
    }
}
