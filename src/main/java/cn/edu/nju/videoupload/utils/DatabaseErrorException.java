package cn.edu.nju.videoupload.utils;

/**
 * @author lzb
 * @date 2018/10/20 17:20
 */
public class DatabaseErrorException extends Exception {
    public DatabaseErrorException() {
    }

    public DatabaseErrorException(String message) {
        super(message);
    }
}
