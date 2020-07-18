
package com.zxl.entity;
/*
import com.gitee.hengboy.mybatis.enhance.common.annotation.Column;
import com.gitee.hengboy.mybatis.enhance.common.annotation.Id;
import com.gitee.hengboy.mybatis.enhance.common.annotation.Table;
import com.gitee.hengboy.mybatis.enhance.common.enums.KeyGeneratorTypeEnum;
import lombok.Data;

import java.sql.Timestamp;

*/
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import java.sql.Timestamp;

/**
 * 账户数据实体
 *
 * @author zxl
 *//*

@Data
@Table(name = "seata_account")
public class Account {

    @Column(name = "a_id")
    @Id(generatorType = KeyGeneratorTypeEnum.AUTO)
    private Integer id;

    @Column(name = "a_money")
    private Double money;

    @Column(name = "a_create_time")
    private Timestamp createTime;

    @Column(name = "a_mark")
    private String mark;
}
*/

@Data
@TableName(value = "seata_account")
public class Account {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "a_money")
    private Double money;
    @TableField(value = "a_create_time")
    private Timestamp createTime;
    @TableField(value = "a_mark")
    private String mark;
}
