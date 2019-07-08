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

    @GetMapping("/list/page")
    @CrossOrigin
    public ResponseEntity<orderResult<Order>> selectOrder(
            /**
            * @methodName: selectOrder
            * @Description: 查询订单
            * @Param: [page, rows, sortBy, desc]
            * @return: org.springframework.http.ResponseEntity<com.clement.domain.orderResult<com.clement.domain.Order>>
            * @Author: KeXin Xu
            * @Date: 2019/7/8
            */


            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc
    ) {
        orderResult<Order> result = this.orderService.selectOrder(page, rows, sortBy, desc);
        return ResponseEntity.ok(result);

    }

    @GetMapping()
    @CrossOrigin
    public void saleOrder(@RequestParam String baskets, @RequestParam Float total, @RequestParam String message)  {
        /**
        * @methodName: saleOrder
        * @Description: 购物车
        * @Param: [baskets, total, message]
        * @return: void
        * @Author: KeXin Xu
        * @Date: 2019/7/8
        */
        orderService.saleOrder(new Order(baskets,total,message));

    }

}

