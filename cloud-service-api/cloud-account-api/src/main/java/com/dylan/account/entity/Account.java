package com.dylan.account.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 账户表
 *
 * @author wudelong
 * @Date 2021/6/8 17:00
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("account")
public class Account extends Model<Account> {

    private Integer id;

    private String userId;

    private Integer money;
}
