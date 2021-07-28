package com.dylan.accountservicenacos.controller;

import com.dylan.account.entity.Account;
import com.dylan.accountservicenacos.middleware.AccountService;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author wudelong
 * @Date 2021/6/8 20:37
 */
@RestController
@RequestMapping("account")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("getByUserId")
    public Account getByUserId(Integer userId) throws InterruptedException {
        return accountService.getByUserId(userId);
    }

    @PostMapping("updateByUserId")
    boolean updateByUserId(@RequestBody Account account) {
        return accountService.updateByUserId(account);
    }


    /**
     * TCC
     */

    @PostMapping("prepare")
    public boolean prepare(@RequestBody Map<String, String> params) {
        return accountService.prepare(params);
    }

    @PostMapping("commit")
    public boolean commit(@RequestBody BusinessActionContext actionContext) {
        return accountService.commit(actionContext);
    }

    @PostMapping("cancel")
    public boolean cancel(@RequestBody BusinessActionContext actionContext) {
        return accountService.cancel(actionContext);
    }


}
