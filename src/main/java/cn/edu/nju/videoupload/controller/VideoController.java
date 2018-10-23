package cn.edu.nju.videoupload.controller;

import cn.edu.nju.videoupload.entity.Message;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Yang Yuqing
 * @Description:
 * @Date: Created in 10:04 AM 10/23/18
 * @Modifiedby:
 */
@Controller
public class VideoController {

    String accessId = "<yourAccessKeyId>";      // 请填写您的AccessKeyId。
    String accessKey = "<yourAccessKeySecret>"; // 请填写您的AccessKeySecret。
    String endpoint = "oss-cn-hangzhou.aliyuncs.com"; // 请填写您的 endpoint。
    String bucket = "bucket-name";                    // 请填写您的 bucketname 。
    String host = "http://" + bucket + "." + endpoint; // host的格式为 bucketname.endpoint

    // callbackUrl为 上传回调服务器的URL，请将下面的IP和Port配置为您自己的真实信息。
    String callbackUrl = "http://88.88.88.88:8888";
    String dir = "user-dir-prefix/"; // 用户上传文件时指定的前缀。

    @RequestMapping(value = "/api/video/testGetFile")
    @ResponseBody
    public int testGetFile(@RequestBody JSONObject jsonObject){
        System.out.println("method testGetFile invoked");
        return Message.SUCCESS;
    }
    @RequestMapping(value = "testCallback")
    @ResponseBody
    public int testCallback(@RequestBody JSONObject jsonObject){
        System.out.println("callback json is "+jsonObject);
        return Message.SUCCESS;
    }
}
