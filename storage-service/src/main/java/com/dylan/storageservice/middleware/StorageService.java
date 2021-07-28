package com.dylan.storageservice.middleware;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.dylan.storage.entity.Storage;
import com.dylan.storageservice.service.IStorageService;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wudelong
 * @Date 2021/6/8 16:20
 */
@Slf4j
@Service
@AllArgsConstructor
public class StorageService {

    private final IStorageService storageService;


    public Integer save() {
        return  0;
    }

    public Storage getById(Integer id) {
        return storageService.getById(id);
    }

    public boolean update(Storage storage) {
        return storageService.updateById(storage);
    }

    public boolean prepare(Map<String, String> params) {
        Storage storage = BeanUtil.toBean(params, Storage.class);
        return storageService.updateById(storage);
    }

    public boolean commit(BusinessActionContext actionContext) {
        log.info("StorageService commit, xid: {}", JSON.toJSONString(actionContext));
        return Boolean.TRUE;
    }

    public boolean rollback(BusinessActionContext actionContext) {
        log.info("StorageService cancel, xid: {}", JSON.toJSONString(actionContext));
        Object params =  actionContext.getActionContext("params");
        Storage storage = BeanUtil.toBean(params, Storage.class);
        storage.setCount(storage.getCount() - 100);
        return Boolean.TRUE;
    }
}
