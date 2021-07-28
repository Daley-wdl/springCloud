package com.dylan.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dylan.account.entity.Account;
import com.dylan.userservice.mapper.AccountMapper;
import com.dylan.userservice.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @author wudelong
 * @Date 2021/6/8 20:48
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {
}
