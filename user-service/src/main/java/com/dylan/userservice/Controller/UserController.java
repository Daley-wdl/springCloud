package com.dylan.userservice.Controller;

import com.dylan.userservice.VO.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author wudelong
 * @Date 2021/3/29 14:44
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserController {


    @GetMapping("get/{id}")
    public User get(@PathVariable("id") Integer id) {
        log.info("rpc requst id:{}", id);
        User user = new User();
        user.setId(id);
        user.setName("dylan-" + id);
        return user;
    }

}
