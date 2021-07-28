package com.dylan.userservicenacos.middleware;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.dylan.account.entity.Account;
import com.dylan.account.feign.RemoteAccountService;
import com.dylan.account.feign.TccRemoteAccountService;
import com.dylan.order.entity.Orders;
import com.dylan.order.feign.RemoteOrderService;
import com.dylan.storage.entity.Storage;
import com.dylan.storage.feign.RemoteStorageService;
import com.dylan.storage.feign.TccRemoteStorageService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wudelong
 * @Date 2021/6/8 20:25
 */
@Service
@Slf4j
@AllArgsConstructor
public class BusinessService {

    private final RemoteAccountService remoteAccountService;
    private final RemoteStorageService remoteStorageService;
    private final RemoteOrderService remoteOrderService;

    private final TccRemoteStorageService tccRemoteStorageService;
    private final TccRemoteAccountService tccRemoteAccountService;

    @GlobalTransactional
    public boolean purchase(Integer userId, Integer productId) {

        Account account = remoteAccountService.getByUserId(userId);
        log.info("account =========> {}", JSONUtil.toJsonStr(account));

        Storage storage = remoteStorageService.getById(productId);
        log.info("storage =========> {}", JSONUtil.toJsonStr(storage));

        Orders orders = new Orders();
        orders.setUserId(userId);
        orders.setMoney(100);
        orders.setCommodityCode(storage.getCommodityCode());
        orders.setCount(1);
        remoteOrderService.create(orders);


        Storage storageForUpdate = new Storage();
        storageForUpdate.setId(storage.getId());
        storageForUpdate.setCount(storage.getCount() - 1);
        remoteStorageService.update(storageForUpdate);

        Account accountForUpdate = new Account();
        accountForUpdate.setUserId(userId.toString());
        accountForUpdate.setMoney(account.getMoney() - 100);
        remoteAccountService.updateByUserId(accountForUpdate);

        return Boolean.TRUE;

    }


    /**
     * 增加库存
     *
     * @param id
     * @return
     */
    @GlobalTransactional
    public boolean tccTransaction(Integer id) {
        Storage storage = remoteStorageService.getById(id);
        storage.setCount(storage.getCount() + 100);
        boolean prepare = tccRemoteStorageService.prepare(BeanUtil.beanToMap(storage));

        Account account = remoteAccountService.getByUserId(1);
        account.setMoney(account.getMoney() + 1000);
        boolean prepare1 = tccRemoteAccountService.prepare( BeanUtil.beanToMap(account));

        Boolean flag = Boolean.TRUE;
        if (flag) {
            throw new RuntimeException("TCC 回滚");
        }
        return Boolean.TRUE;
    }


    /**
     * rpc 调用 ribbon feign
     *
     * {@link HystrixPropertiesManager}
     *
     * 默认值:
     *  一个滑动窗口内最小的请求数 : 20
     *  错误比率阈值            : 50%
     *  断路多久后开始恢复       : 5s
     *  一个滑动窗口的时间长度    : 10s
     *  一个滑动窗口被划分的数量  : 10
     *
     *  线程池核心线程数 ：hystrix.threadpool.default.coreSize ： 10
     *  最大排队长度：hystrix.threadpool.default.maxQueueSize ： 默认-1，使用SynchronousQueue。其他值则使用 LinkedBlockingQueue。
     *                                                        如果要从-1换成其他值则需重启，即该值不能动态调整，若要动态调整，需要使用到下边这个配置
     *
     *  排队线程数量阈值 ： queueSizeRejectionThreshold ：5  达到时拒绝，如果配置了该选项，队列的大小是该队列
     *
     *  超时时间 ：timeoutInMilliseconds ：1000 ms， 在调用方配置，被该调用方的所有方法的超时时间都是该值，优先级低于下边的指定配置
     *
     *  超时时间 ： timeoutInMilliseconds ：在调用方配置，被该调用方的指定方法（HystrixCommandKey方法名）的超时时间是该值
     */
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
//
//            // 一个滑动窗口内最小的请求数
//             @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
//
//            // 错误比率阈值
//             @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
//
//            // 断路多久后开始恢复
//             @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
//
//            // 一个滑动窗口的时间长度
//             @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000"),
//
//            // 一个滑动窗口被划分的数量
//             @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "10"),
//    })
    public int healthGet() {

        Account account = remoteAccountService.getByUserId(1);
        log.info(JSONUtil.toJsonStr(account));
        return 123;
    }
}
