
package com.zxl.entity;
/*
import com.gitee.hengboy.mybatis.enhance.common.annotation.Column;
import com.gitee.hengboy.mybatis.enhance.common.annotation.Id;
import com.gitee.hengboy.mybatis.enhance.common.annotation.Table;
import com.gitee.hengboy.mybatis.enhance.common.enums.KeyGeneratorTypeEnum;
import lombok.Data;

*/

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * @author zxl
 *//*

@Data
@Table(name = "seata_order")
public class Order {

    @Id(generatorType = KeyGeneratorTypeEnum.AUTO)
    @Column(name = "o_id")
    private Integer id;

    @Column(name = "o_good_id")
    private Integer goodId;

    @Column(name = "o_account_id")
    private Integer accountId;

    @Column(name = "o_price")
    private Double price;
}
*/



@Data
@TableName(value = "seata_order")
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "good_id")
    private Integer goodId;
    @TableField(value = "account_id")
    private Integer accountId;
    @TableField(value = "price")
    private Double price;
}
