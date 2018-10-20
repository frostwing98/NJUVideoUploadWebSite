package cn.edu.nju.videoupload.entity;

import cn.edu.nju.videoupload.utils.PropNotExistsException;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Map;

/**
 * @author lzb
 * @date 2018/10/16 19:02
 */
@Data
public class User {

    @Id
    private String userID ;
    private String password;
    @ManyToMany
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

    public boolean setProperty(String key, String value) throws PropNotExistsException{
        return false;
    }

    public String getPropertyByKey(String key) throws PropNotExistsException{

        if (!this.propertyMap.containsKey(key)){
            throw new PropNotExistsException();
        }
        return this.propertyMap.get(key);
    }


}
