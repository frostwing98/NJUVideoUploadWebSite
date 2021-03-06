package cn.edu.nju.videoupload.entity;

import cn.edu.nju.videoupload.utils.PropNotExistsException;
import lombok.Data;

import java.util.Map;

/**
 * @author lzb
 * @date 2018/10/16 19:11
 */
@Data
public class UserVO {
    private String userID , password;
    private Map<String ,String> propertyMap;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, String> getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(Map<String, String> propertyMap) {
        this.propertyMap = propertyMap;
    }

    public boolean setProperty(String key, String value) throws PropNotExistsException {
        return false;
    }

    public String getPropertyByKey(String key) throws PropNotExistsException{

        if (!this.propertyMap.containsKey(key)){
            throw new PropNotExistsException();
        }
        return this.propertyMap.get(key);
    }

}
