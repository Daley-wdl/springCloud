package com.dylan.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单表
 *
 * @author wudelong
 * @Date 2021/6/8 16:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("orders")
public class Orders extends Model<Orders> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("commodity_code")
    private String commodityCode;

    @TableField("count")
    private Integer count;

    @TableField("money")
    private Integer money;

}
