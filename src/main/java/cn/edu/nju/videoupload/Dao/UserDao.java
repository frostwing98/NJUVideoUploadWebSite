package cn.edu.nju.videoupload.Dao;

import cn.edu.nju.videoupload.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lzb
 * @date 2018/10/16 19:37
 */
public interface UserDao extends JpaRepository<User,String> {
}
