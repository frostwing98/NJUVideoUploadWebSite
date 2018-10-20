package cn.edu.nju.videoupload.Dao;

import cn.edu.nju.videoupload.utils.DatabaseErrorException;

import java.util.Set;

/**
 * @author lzb
 * @date 2018/10/20 17:03
 */
public interface UserPropDao {

    Set<String> getUserProps() throws DatabaseErrorException;
}
