package com.dylan.userservicenacos.middleware;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dylan.account.entity.Account;
import com.dylan.order.entity.Orders;
import com.dylan.storage.entity.Storage;
import com.dylan.userservicenacos.service.IAccountService;
import com.dylan.userservicenacos.service.IOrderService;
import com.dylan.userservicenacos.service.IStorageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wudelong
 * @Date 2021/6/13 20:59
 */
@Slf4j
//@AllArgsConstructor
@Service
public class LocalBusinessService {

    private final IOrderService orderService;
    private final IStorageService storageService;
    private final IAccountService accountService;

    public LocalBusinessService(IOrderService orderService, IStorageService storageService, IAccountService accountService) {
        this.orderService = orderService;
        this.storageService = storageService;
        this.accountService = accountService;
    }

    @Autowired
    private LocalBusinessService localBusinessService;


    /**
     * 本地事务
     *
     * @param userId
     * @param productId
     * @return
     */
    @Transactional
    public boolean localPurchase(Integer userId, Integer productId) {

        Storage storage = storageService.getById(productId);
        log.info("storage =========> {}", JSONUtil.toJsonStr(storage));

        Orders orders = new Orders();
        orders.setUserId(userId);
        orders.setMoney(100);
        orders.setCommodityCode(storage.getCommodityCode());
        orders.setCount(1);
        orderService.save(orders);


        Storage storageForUpdate = new Storage();
        storageForUpdate.setId(storage.getId());
        storageForUpdate.setCount(storage.getCount() - 1);
        storageService.updateById(storageForUpdate);

        this.deduceAccount(userId);

//        localBusinessService.deduceAccount(userId);

        boolean flag =false;
        if (flag) {
            int i = 1 / 0;
        }

        return Boolean.TRUE;
    }



    @Transactional
    public void deduceAccount(Integer userId) {

        Account account = accountService.getOne(new LambdaQueryWrapper<Account>().eq(Account::getUserId, userId));
        log.info("account =========> {}", JSONUtil.toJsonStr(account));
        if (account.getMoney() < 100) {
            throw new RuntimeException("账户余额不足");
        }

        Account accountForUpdate = new Account();
        accountForUpdate.setUserId(userId.toString());
        accountForUpdate.setMoney(account.getMoney() - 100);
        accountService.update(accountForUpdate, new LambdaQueryWrapper<Account>().eq(Account::getUserId, userId));

        boolean flag =false;
        if (flag) {
            int i = 1 / 0;
        }
    }
}
