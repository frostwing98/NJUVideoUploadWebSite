package cn.edu.nju.videoupload.BL.user;

import cn.edu.nju.videoupload.BLService.user.UserBLService;
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

    @Override
    public void importUsersByExcel(MultipartFile excelFile) throws BadExcelFileException {

    }

    @Override
    public UserVO login(String userID, String password) throws LogInFailedException {
        return null;
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
        return null;
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
        return null;
    }

    @Override
    public Set<String> getUsersProperties() {
        return null;
    }
}
