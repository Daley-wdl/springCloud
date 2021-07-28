package com.dylan.account.feign;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(contextId = "TccRemoteAccountService", value = "account-service-nacos")
@LocalTCC
public interface TccRemoteAccountService {

    @PostMapping("account/prepare")
    @TwoPhaseBusinessAction(name = "tccRemoteAccount", commitMethod = "commit", rollbackMethod = "cancel")
    public boolean prepare(
                            @BusinessActionContextParameter(paramName = "params") Map<String, Object> params);

    @PostMapping("account/commit")
    public boolean commit(@RequestBody BusinessActionContext actionContext);

    @PostMapping("account/cancel")
    public boolean cancel(@RequestBody BusinessActionContext actionContext);
}
