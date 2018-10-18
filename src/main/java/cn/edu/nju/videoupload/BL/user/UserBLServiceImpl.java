package cn.edu.nju.videoupload.BL.user;

import cn.edu.nju.videoupload.BLService.UserBLService;
import cn.edu.nju.videoupload.entity.User;
import cn.edu.nju.videoupload.entity.UserVO;
import cn.edu.nju.videoupload.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

/**
 * @author lzb
 * @date 2018/10/16 19:21
 */
@Service
public class UserBLServiceImpl implements UserBLService {

    private final UserBLHelper userBLHelper;
    private final ExcelHelper excelHelper;

    @Autowired
    public UserBLServiceImpl(UserBLHelper userBLHelper, ExcelHelper excelHelper) {
        this.userBLHelper = userBLHelper;
        this.excelHelper = excelHelper;
    }

    /**
     * 用于从Excel文件中导入数据，
     *
     * @param excelFile excel文件的MultipartFile
     * @throws BadExcelFileException Excel文件的格式不符合要求
     */
    @Override
    public void importUsersByExcel(MultipartFile excelFile) throws BadExcelFileException {

    }

    /**
     * 用于普通用户登录
     *
     * @param userID   用户ID
     * @param password 用户密码
     * @return UserVO
     * @throws LogInFailedException 登录失败
     */
    @Override
    public UserVO login(String userID, String password) throws LogInFailedException {
        try {
            User user = userBLHelper.getUserByID(userID);
            if (user.getPassword().equals(password)) {
                //登陆成功
                return userBLHelper.userToVo(user);
            } else {
                //登录失败
                throw new LogInFailedException("用户名或密码错误");
            }
        } catch (UserNotExistException e) {
            throw new LogInFailedException("用户不存在");
        }
    }

    /**
     * 调取用户信息
     *
     * @param userID 用户ID
     * @return UserVO
     * @throws UserNotExistException 用户不存在
     */
    @Override
    public UserVO fetchUserInfo(String userID) throws UserNotExistException {
        User user = userBLHelper.getUserByID(userID);
        return userBLHelper.userToVo(user);
    }

    /**
     * 更新用户信息
     *
     * @param newUserVO 新的用户信息
     * @return UserVO
     * @throws UserNotExistException    用户不存在
     * @throws BadUserVOFormatException 参数错误
     */
    @Override
    public UserVO updateUseInfo(UserVO newUserVO) throws UserNotExistException, BadUserVOFormatException {
        User user = userBLHelper.voToUser(newUserVO);
        userBLHelper.updateUser(user);
        return fetchUserInfo(user.getUserID());
    }

    @Override
    public Set<String> getUsersProperties() {
        return null;
    }
}
