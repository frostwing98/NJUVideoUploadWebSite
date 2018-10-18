package cn.edu.nju.videoupload.BLService.user;

import cn.edu.nju.videoupload.entity.UserVO;
import cn.edu.nju.videoupload.utils.BadExcelFileException;
import cn.edu.nju.videoupload.utils.LogInFailedException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

/**
 * this class is for user registration ,
 * @author lzb
 * @date 2018/10/16 18:58
 */
public interface UserBLService {

    /**
     * 用于从Excel文件中导入数据，
     * @param excelFile
     * @throws BadExcelFileException Excel文件的格式不符合要求
     */
    void importUsersByExcel(MultipartFile excelFile) throws BadExcelFileException;

    /**
     * 用于普通用户登录
     * @param userID 用户ID
     * @param password 用户密码
     * @return UserVO
     * @throws LogInFailedException 登录失败
     */
    UserVO login(String userID,String password)throws LogInFailedException;


    /**
     *
     * @return 返回用户的属性列表，即Excel文件的表头
     */
    Set<String> getUsersProperties();


}
