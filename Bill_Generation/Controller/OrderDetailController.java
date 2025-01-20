package com.example.Bill_Generation.Controller;

import com.example.Bill_Generation.Model.OrderDetail;
import com.example.Bill_Generation.Model.ResponseDTO;
import com.example.Bill_Generation.Repository.OrderDetailRepository;
import com.example.Bill_Generation.Service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderDetailRepository orderDetail;

    @PostMapping("placeOrder")
    public ResponseDTO<OrderDetail> placeOrder(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.placeOrder(orderDetail);
    }

    @GetMapping("getAll")
    public List<OrderDetail> getAllOrders() {
        return orderDetail.findAll();
    }

}
