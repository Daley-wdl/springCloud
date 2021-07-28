package com.dylan.accountservicenacos.middleware;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dylan.account.entity.Account;
import com.dylan.accountservicenacos.service.IAccountService;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author wudelong
 * @Date 2021/6/8 20:25
 */
@Service
@Slf4j
@AllArgsConstructor
public class AccountService {

    private IAccountService accountService;

    public Account getByUserId(Integer userId) throws InterruptedException {
        long randomLong = RandomUtil.randomLong(1, 5);
        log.info("====++++++++++++===> getByUserId sleep {}", randomLong);
//        TimeUnit.SECONDS.sleep(randomLong);
        return accountService.getOne(new LambdaQueryWrapper<Account>().eq(Account::getUserId, userId));
    }

    public boolean updateByUserId(Account account) {
        if (account.getMoney() < 0) {
            throw new RuntimeException("账户余额不足");
        }
        return accountService.update(account, new LambdaQueryWrapper<Account>()
                .eq(Account::getUserId, account.getUserId()));
    }

    public boolean prepare(Map<String, Strih't'tng> params) {
        Account account = BeanUtil.toBean(params, Account.class);
        return accountService.updateById(account);
    }

    public boolean commit(BusinessActionContext actionContext) {
        log.info("AccountService commit, xid: {}", JSON.toJSONString(actionContext));
        return true;
    }

    public boolean cancel(BusinessActionContext actionContext) {
        log.info("AccountService cancel, xid: {}", JSON.toJSONString(actionContext));
        Object params =  actionContext.getActionContext("params");
        Account account = BeanUtil.toBean(params, Account.class);
        account.setMoney(account.getMoney() - 1000);
        return true;
    }
}
