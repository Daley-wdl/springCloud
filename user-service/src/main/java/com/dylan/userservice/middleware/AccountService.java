package com.dylan.userservice.middleware;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dylan.account.entity.Account;
import com.dylan.userservice.service.IAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wudelong
 * @Date 2021/6/14 21:15
 */
@Slf4j
@AllArgsConstructor
@Service
public class AccountService {

    private final IAccountService accountService;



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
