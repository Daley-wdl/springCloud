package com.dylan.storage.feign;

import com.dylan.storage.entity.Storage;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(contextId = "TccRemoteStorageService", value = "storage-service")
@LocalTCC
public interface TccRemoteStorageService {

    @PostMapping("storage/prepare")
    @TwoPhaseBusinessAction(name = "tccRemoteStorage", commitMethod = "commit", rollbackMethod = "cancel")
    public boolean prepare(@BusinessActionContextParameter(paramName = "params") Map<String, Object> params);

    @PostMapping("storage/commit")
    public boolean commit(BusinessActionContext actionContext);

    @PostMapping("storage/cancel")
    public boolean cancel(BusinessActionContext actionContext);

}
