package cn.edu.nju.videoupload.BL.user;

import cn.edu.nju.videoupload.entity.User;
import cn.edu.nju.videoupload.utils.UserNotExistException;

/**
 * 用户模块提供给BL层中其他模块的接口
 *
 * @author lzb
 * @date 2018/10/16 19:33
 */
public interface UserBLInterface {
    User fetchUserInfo(String userID) throws UserNotExistException;
}
