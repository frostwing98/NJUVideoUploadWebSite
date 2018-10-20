package cn.edu.nju.videoupload.Dao;

import cn.edu.nju.videoupload.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

/**
 * @author lzb
 * @date 2018/10/16 19:37
 */
@Repository
@Table(name = "user")//这里表名要统一
public interface UserDao extends JpaRepository<User,String> {




}
