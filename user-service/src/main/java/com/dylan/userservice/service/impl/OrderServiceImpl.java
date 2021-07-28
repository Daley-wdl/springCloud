package com.dylan.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dylan.order.entity.Orders;
import com.dylan.userservice.mapper.OrderMapper;
import com.dylan.userservice.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * @author wudelong
 * @Date 2021/6/8 16:18
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements IOrderService {
}
