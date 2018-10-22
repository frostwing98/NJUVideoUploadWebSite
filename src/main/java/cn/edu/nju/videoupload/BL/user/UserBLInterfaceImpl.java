package cn.edu.nju.videoupload.BL.user;

import cn.edu.nju.videoupload.entity.User;
import cn.edu.nju.videoupload.utils.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Shuaiyu Yao
 * @create 2018-10-18 11:11
 */
@Service
public class UserBLInterfaceImpl implements UserBLInterface {

    private final UserBLHelper userBLHelper;

    @Autowired
    public UserBLInterfaceImpl(UserBLHelper userBLHelper) {
        this.userBLHelper = userBLHelper;
    }

    @Override
    public User fetchUserInfo(String userID) throws UserNotExistException {
        return userBLHelper.getUserByID(userID);
    }
}
