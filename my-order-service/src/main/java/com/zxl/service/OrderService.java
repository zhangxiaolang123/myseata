package com.zxl.service;

import com.zxl.entity.Order;
import com.zxl.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zxl
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService {

    @Autowired
    private OrderMapper mapper;
    /*private EnhanceMapper<Order, Integer> mapper;*/


    public void addOrder(Order order) {
        mapper.insert(order);
    }
}
