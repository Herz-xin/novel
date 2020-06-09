package com.novel.service;

import com.novel.po.vo.UserVO;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/5/20 15:01<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */

public interface UserService {
    /**
     * 查询所有
     * @return
     */
    UserVO getSelect();

    /**
     * 根据id查询
     * @return
     */
    UserVO getSelectById();

    /**
     * 根据id更新
     * @return
     */
    int getUpdateById();

    /**
     * 添加数据
     * @return
     */
    int getInsert();

    /**
     * 根据id删除
     * @return
     */
    int getDeleteById();
}
