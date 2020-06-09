package com.novel.controller;

import com.novel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * user的接口层
 * Description: <br/>
 * date: 2020/5/20 14:59<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@RestController("/login")
@ResponseBody
public class UserController {
    @Autowired
    UserService userSercive;
}
