package com.novel.mapper;

import com.novel.po.vo.UserVO;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * UserMapper接口
 * Description: <br/>
 * date: 2020/5/20 14:59<br/>
 *
 * @author zuo<br />
 * @since JDK 1.8
 */
public interface UserMapper extends UserDetailsManager {
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
     * 根据id删除接口
     * @return
     */
    int getDeleteById();

    /**
     * 根据用户名查询
     * @param username 用户名
     * @return
     */
    UserVO getSelectByName(String username);
}
