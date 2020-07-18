package com.zxl.service;

import com.zxl.entity.Good;
import com.zxl.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * 商品业务逻辑实现
 *
 * @author zxl
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GoodService {

    @Autowired
    private GoodMapper mapper;

    /**
     * 查询商品详情
     *
     * @param goodId {@link Good#getId()}
     * @return {@link Good}
     */
    public Good findById(Integer goodId) {
        Good good = new Good();
        good.setId(goodId);
        return mapper.selectOne(good);
    }

    /**
     * {@link } 具体使用查看ApiBoot官网文档http://apiboot.minbox.io/zh-cn/docs/api-boot-mybatis-enhance.html
     * 扣除商品库存
     *
     * @param goodId {@link Good#getId()}
     * @param stock  扣除的库存数量
     */
    public void reduceStock(Integer goodId, int stock) {
        Good good1 = new Good();
        good1.setId(goodId);
        Good good = mapper.selectOne(good1);
        if (ObjectUtils.isEmpty(good)) {
            throw new RuntimeException("商品：" + goodId + ",不存在.");
        }
        if (good.getStock() - stock < 0) {
            throw new RuntimeException("商品：" + goodId + "库存不足.");
        }
        good.setStock(good.getStock() - stock);
        mapper.updateById(good);
        System.out.println("ddd");
    }
}
