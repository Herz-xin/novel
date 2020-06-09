package com.novel.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/5/25 18:28<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
public interface LoginUserService extends UserDetailsService {
}