package com.dylan.account.feign;

import com.dylan.account.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "RemoteAccountService", value = "account-service-nacos")
public interface RemoteAccountService {

    @GetMapping("account/getByUserId")
    Account getByUserId(@RequestParam(value = "userId") Integer userId);

    @PostMapping("account/updateByUserId")
    boolean updateByUserId(@RequestBody Account account);
}
