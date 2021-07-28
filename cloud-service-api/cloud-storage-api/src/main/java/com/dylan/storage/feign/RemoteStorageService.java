package com.dylan.storage.feign;

import com.dylan.storage.entity.Storage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "RemoteStorageService", value = "storage-service")
public interface RemoteStorageService {

    @GetMapping("storage/getById")
    Storage getById(@RequestParam(value = "id") Integer id);

    @PostMapping("storage/update")
    public boolean update(@RequestBody Storage storage);
}
