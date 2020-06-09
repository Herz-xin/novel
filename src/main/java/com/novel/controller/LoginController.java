package com.novel.controller;

import com.novel.po.User;
import com.novel.po.dto.UserDTO;
import com.novel.po.vo.UserVO;
import com.novel.service.LoginUserService;
import com.novel.until.ResResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 登录接口
 * Description: <br/>
 * date: 2020/5/20 16:17<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
@CrossOrigin
@RestController
@RequestMapping("/api/novel")
@Slf4j
@Api(tags = "登录")
public class LoginController {



    @Secured("USER_ROLE_SELECT")
    @RequestMapping(value = "/Login")
    @ApiOperation(value = "登录")
    public ResResult<UserVO> login(@RequestBody UserDTO userDTO, HttpServletResponse response, HttpServletRequest request) {
        UserVO userVO = new UserVO();
        User user = new User();
        user.setUserName(userDTO.getUsername());
        user.setUserPassword(userDTO.getPassword());
//        loginUserService.loadUserByUsername(user.getUsername());
        return ResResult.success(userVO);
    }
}