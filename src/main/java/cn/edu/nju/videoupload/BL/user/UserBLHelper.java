package cn.edu.nju.videoupload.BL.user;

import cn.edu.nju.videoupload.entity.User;
import cn.edu.nju.videoupload.entity.UserVO;
import cn.edu.nju.videoupload.utils.BadUserFormatException;
import cn.edu.nju.videoupload.utils.BadUserVOFormatException;
import cn.edu.nju.videoupload.utils.UserNotExistException;

/**
 * 用户模块的基础操作接口，封装与Dao的操作
 *
 * @author lzb
 * @date 2018/10/16 19:23
 */
public interface UserBLHelper {


    User getUserByID(String userID) throws UserNotExistException;

    User updateUser(User updatedUser) throws UserNotExistException;

    User createUser(User user) throws BadUserFormatException;

    boolean deleteUserByID(String userID) throws UserNotExistException;

    boolean ifUserIDExists(String userID) throws UserNotExistException;

    UserVO userToVo(User user);

    User voToUser(UserVO vo) throws BadUserVOFormatException;

}
