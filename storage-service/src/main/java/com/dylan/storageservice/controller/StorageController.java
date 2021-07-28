package com.dylan.storageservice.controller;

import com.dylan.storage.entity.Storage;
import com.dylan.storageservice.middleware.StorageService;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author wudelong
 * @Date 2021/6/8 16:21
 */
@RestController
@RequestMapping("storage")
@AllArgsConstructor
public class StorageController {

    private final StorageService storageService;

    @RequestMapping("save")
    public Integer save() {
        return storageService.save();
    }

    @GetMapping("getById")
    public Storage getById(@RequestParam("id") Integer id) {
        return storageService.getById(id);
    }

    @PostMapping("update")
    public boolean update(@RequestBody Storage storage) {
        return storageService.update(storage);
    }

    @PostMapping("prepare")
    public boolean prepare(@RequestBody Map<String, String> params) {
        return storageService.prepare( params);
    }

    @PostMapping("commit")
    public boolean commit(@RequestBody BusinessActionContext actionContext) {
        return storageService.commit(actionContext);
    }

    @PostMapping("cancel")
    public boolean rollback(@RequestBody BusinessActionContext actionContext) {
        return storageService.rollback(actionContext);
    }


}
