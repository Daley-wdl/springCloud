package com.dylan.userservicenacos.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dylan.storage.entity.Storage;
import com.dylan.userservicenacos.mapper.StorageMapper;
import com.dylan.userservicenacos.service.IStorageService;
import org.springframework.stereotype.Service;

/**
 * @author wudelong
 * @Date 2021/6/8 16:18
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements IStorageService {
}
