package cn.edu.nju.videoupload.entity;

import cn.edu.nju.videoupload.utils.PropNotExistsException;
import lombok.Data;

import java.util.Map;

/**
 * @author lzb
 * @date 2018/10/16 19:02
 */
@Data
public class User {

    private String userID , password;
    private Map<String ,String> propertyMap;



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
