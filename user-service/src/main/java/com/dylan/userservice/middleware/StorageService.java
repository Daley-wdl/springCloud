package com.dylan.userservice.middleware;

import cn.hutool.json.JSONUtil;
import com.dylan.storage.entity.Storage;
import com.dylan.userservice.service.IStorageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wudelong
 * @Date 2021/6/14 21:13
 */
@Slf4j
@AllArgsConstructor
@Service
public class StorageService {

    private final IStorageService storageService;

    @Transactional
    public void deduceStorage(Integer productId){

        Storage storage = storageService.getById(productId);
        log.info("storage =========> {}", JSONUtil.toJsonStr(storage));

        Storage storageForUpdate = new Storage();
        storageForUpdate.setId(storage.getId());
        storageForUpdate.setCount(storage.getCount() - 1);
        storageService.updateById(storageForUpdate);

        boolean flag =false;
        if (flag) {
            int i = 1 / 0;
        }
    }


}
