package cn.edu.nju.videoupload.BL.user;

import cn.edu.nju.videoupload.BLService.user.UserBLService;
import cn.edu.nju.videoupload.entity.UserVO;
import cn.edu.nju.videoupload.utils.BadExcelFileException;
import cn.edu.nju.videoupload.utils.ExcelHelper;
import cn.edu.nju.videoupload.utils.LogInFailedException;
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

    @Autowired
    private UserBLHelper userBLHelper;

    @Autowired
    private ExcelHelper excelHelper;

    @Override
    public void importUsersByExcel(MultipartFile excelFile) throws BadExcelFileException {

    }

    @Override
    public UserVO login(String userID, String password) throws LogInFailedException {
        return null;
    }

    @Override
    public Set<String> getUsersProperties() {
        return null;
    }
}
