package com.zxl.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 账户服务接口
 *
 * @author zxl
 */
@FeignClient(name = "my-account-service")
@RequestMapping(value = "/account")
public interface AccountClient {
    /**
     * 扣除指定账户金额
     *
     * @param accountId 账户编号
     * @param money     金额
     */
    @PostMapping
    void deduction(@RequestParam("accountId") Integer accountId, @RequestParam("money") Double money);
}
