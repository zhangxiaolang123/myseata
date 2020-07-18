package com.zxl;

import com.zxl.entity.Good;
import com.zxl.entity.Order;


import com.zxl.feign.AccountClient;
import com.zxl.feign.GoodClient;
import com.zxl.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author zxl
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {
    /**
     * 账户服务接口
     */
    @Autowired
    private AccountClient accountClient;
    /**
     * 商品服务接口
     */
    @Autowired
    private GoodClient goodClient;
    /**
     * 订单业务逻辑
     */
    @Autowired
    private OrderService orderService;

    /**
     * 通过{@link GoodClient#reduceStock(Integer, int)}方法减少商品的库存，判断库存剩余数量
     * 通过{@link AccountClient#deduction(Integer, Double)}方法扣除商品所需要的金额，金额不足由account-service抛出异常
     *
     * @param goodId    {@link Good#getId()}
     * @param accountId
     * @param buyCount  购买数量
     * @return
     */
    @PostMapping
    @GlobalTransactional
    public String submitOrder(
            @RequestParam("goodId") Integer goodId,
            @RequestParam("accountId") Integer accountId,
            @RequestParam("buyCount") int buyCount) {

        Good good = goodClient.findById(goodId);
        Double orderPrice = buyCount * good.getPrice();
        goodClient.reduceStock(goodId, buyCount);
        accountClient.deduction(accountId, orderPrice);
        Order order = toOrder(goodId, accountId, orderPrice);
        orderService.addOrder(order);
        return "下单成功.";
    }

    private Order toOrder(Integer goodId, Integer accountId, Double orderPrice) {
        Order order = new Order();
        order.setGoodId(goodId);
        order.setAccountId(accountId);
        order.setPrice(orderPrice);
        return order;
    }
}
