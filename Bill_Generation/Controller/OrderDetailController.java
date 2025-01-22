package com.example.Bill_Generation.Controller;

import com.example.Bill_Generation.Model.OrderDetail;
import com.example.Bill_Generation.Model.ResponseDTO;
import com.example.Bill_Generation.Service.CsvFileProduct;
import com.example.Bill_Generation.Service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private CsvFileProduct csvFileProduct;

    @PostMapping("placeOrder")
    public ResponseDTO<OrderDetail> placeOrder(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.placeOrder(orderDetail);
    }


    @Scheduled(fixedRate = 6000)
    public void createReport() {
        csvFileProduct.exportToCsv();
    }

    @GetMapping("file")
    public ResponseEntity<String> file() {
        String filePath = csvFileProduct.exportToCsv();
        return ResponseEntity.ok("CSV file generated at: " + filePath);
    }
}
