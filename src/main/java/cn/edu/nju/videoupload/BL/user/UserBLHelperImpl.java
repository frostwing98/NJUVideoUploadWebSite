package cn.edu.nju.videoupload.BL.user;

import cn.edu.nju.videoupload.Dao.UserDao;
import cn.edu.nju.videoupload.entity.User;
import cn.edu.nju.videoupload.entity.UserVO;
import cn.edu.nju.videoupload.utils.BadUserFormatException;
import cn.edu.nju.videoupload.utils.BadUserVOFormatException;
import cn.edu.nju.videoupload.utils.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author lzb
 * @date 2018/10/16 19:22
 */
@Service
public class UserBLHelperImpl implements UserBLHelper {

    private final UserDao userDao;

    @Autowired
    public UserBLHelperImpl(UserDao userDao) {
        this.userDao = userDao;
    }

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

    @Override
    public UserVO userToVo(User user) {
        UserVO vo = new UserVO();
        vo.setUserID(user.getUserID());
        vo.setPassword(user.getPassword());
        if (user.getPropertyMap() != null) {
            vo.setPropertyMap(new HashMap<>(user.getPropertyMap()));
        } else {
            vo.setPropertyMap(new HashMap<>());
        }
        return vo;
    }

    @Override
    public User voToUser(UserVO vo) throws BadUserVOFormatException {
        if (vo.getPassword() == null || vo.getUserID() == null) {
            throw new BadUserVOFormatException("缺少用户名或密码");
        }
        User user = new User();
        user.setUserID(vo.getUserID());
        user.setPassword(vo.getPassword());
        if (vo.getPropertyMap() == null) {
            user.setPropertyMap(new HashMap<>());
        } else {
            user.setPropertyMap(new HashMap<>(vo.getPropertyMap()));
        }
        return user;
    }
}
