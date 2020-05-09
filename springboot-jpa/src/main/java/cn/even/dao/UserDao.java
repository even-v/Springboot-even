package cn.even.dao;

import cn.even.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName: UserDao
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/26 9:31
 * Description:
 */
public interface UserDao extends JpaRepository<User,Long> {
}
