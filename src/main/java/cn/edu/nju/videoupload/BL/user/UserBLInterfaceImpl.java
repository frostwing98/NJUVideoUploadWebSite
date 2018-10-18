package cn.edu.nju.videoupload.BL.user;

import cn.edu.nju.videoupload.entity.User;
import cn.edu.nju.videoupload.utils.UserNotExistException;
import org.springframework.stereotype.Service;

/**
 * @author Shuaiyu Yao
 * @create 2018-10-18 11:11
 */
@Service
public class UserBLInterfaceImpl implements UserBLInterface {


    @Override
    public User fetchUserInfo(String userID) throws UserNotExistException {
        return null;
    }
}
