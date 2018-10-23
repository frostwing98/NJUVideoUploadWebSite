package cn.edu.nju.videoupload.Dao;

import cn.edu.nju.videoupload.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author lzb
 * @date 2018/10/20 17:36
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserDaoTest {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Test
//    public void testDao(){
//        User user = new User();
//        user.setUserID("testid");
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("hello","hello");
//        map.put("key","value");
//        user.setPropertyMap(map);
//        User resultUser = this.userDao.getOne("testid");
//        assert resultUser!=null;
//        System.out.println(user);
//    }
//
//}