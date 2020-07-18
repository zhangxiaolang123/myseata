package com.zxl;


import com.zxl.feign.AccountClient;
import com.zxl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户接口实现
 *
 * @author zxl
 */
@RestController
public class AccountController implements AccountClient {
    /**
     * 账户业务逻辑
     */
    @Autowired
    private AccountService accountService;

    @Override
    public void deduction(Integer accountId, Double money) {
        accountService.deduction(accountId, money);
    }
}
