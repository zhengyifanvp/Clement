package com.clement.controller;

import com.clement.domain.Order;
import com.clement.domain.orderResult;
import com.clement.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @GetMapping()
    @CrossOrigin
    public void saleOrder(@RequestParam String baskets, @RequestParam Float total, @RequestParam String message)  {
        orderService.saleOrder(new Order(baskets,total,message));

    }
    @GetMapping("/list")
    @CrossOrigin
    public ResponseEntity<orderResult<Order>> selecrOrder() {

        orderResult<Order> result =orderService.selectOrder();

        return ResponseEntity.ok(result);

    }
}

