package cn.edu.nju.videoupload.BL.user;

import cn.edu.nju.videoupload.Dao.UserDao;
import cn.edu.nju.videoupload.entity.User;
import cn.edu.nju.videoupload.utils.BadUserFormatException;
import cn.edu.nju.videoupload.utils.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lzb
 * @date 2018/10/16 19:22
 */
@Service
public class UserBLHelperImpl implements UserBLHelper{

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByID(String userID) throws UserNotExistException {
        return null;
    }

    @Override
    public User updateUser(User updatedUser) throws UserNotExistException {
        return null;
    }

    @Override
    public User createUser(User user) throws BadUserFormatException {
        return null;
    }

    @Override
    public boolean deleteUserByID(String userID) throws UserNotExistException {
        return false;
    }

    @Override
    public boolean ifUserIDExists(String userID) throws UserNotExistException {
        return false;
    }
}
