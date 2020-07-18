
package com.zxl.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
/*
*/
/**
 * @author zxl
 *//*

@Data
@Table(name = "seata_good")
public class Good {

    @Id(generatorType = KeyGeneratorTypeEnum.AUTO)
    @Column(name = "g_id")
    private Integer id;

    @Column(name = "g_name")
    private String name;

    @Column(name = "g_stock")
    private Integer stock;

    @Column(name = "g_price")
    private Double price;
}
*/



@Data
@TableName(value = "seata_good")
public class Good {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "g_name")
    private String name;
    @TableField(value = "g_stock")
    private Integer stock;
    @TableField(value = "g_price")
    private Double price;
}

