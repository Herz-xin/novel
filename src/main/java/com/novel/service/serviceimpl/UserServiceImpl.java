package com.novel.service.serviceimpl;

import com.novel.mapper.UserMapper;
import com.novel.po.vo.UserVO;
import com.novel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/5/20 15:01<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserVO getSelect() {
        return userMapper.getSelect();
    }

    @Override
    public UserVO getSelectById() {
        return null;
    }

    @Override
    public int getUpdateById() {
        return 0;
    }

    @Override
    public int getInsert() {
        return 0;
    }

    @Override
    public int getDeleteById() {
        return 0;
    }

}