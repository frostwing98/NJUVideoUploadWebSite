package cn.edu.nju.videoupload.Dao;

import cn.edu.nju.videoupload.entity.User;
import cn.edu.nju.videoupload.utils.DatabaseErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author lzb
 * @date 2018/10/20 17:03
 */
@Service
public class UserPropDaoImpl implements UserPropDao {

    @Autowired
    private UserDao userDao;

    @Override
    public Set<String> getUserProps() throws DatabaseErrorException {

        Set<String> resultUserProperties = null;

        int size = 10;

        Pageable pageable = PageRequest.of(1,size);
        Page<User> users = this.userDao.findAll(pageable);
        for (User user : users) {
            if (user != null && user.getPropertyMap() != null){
                resultUserProperties = user.getPropertyMap().keySet();
            }
        }
        if (resultUserProperties == null){
            throw  new DatabaseErrorException("the use get from database is not in write format");
        }
        return resultUserProperties;
    }
}
