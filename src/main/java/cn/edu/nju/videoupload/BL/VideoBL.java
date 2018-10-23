package cn.edu.nju.videoupload.BL;

import cn.edu.nju.videoupload.entity.Message;
import cn.edu.nju.videoupload.utils.CallbackUtil;
import cn.edu.nju.videoupload.utils.Policy;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Yang Yuqing
 * @Description:
 * @Date: Created in 10:19 AM 10/23/18
 * @Modifiedby:
 */

public class VideoBL {

    @RequestMapping(value = "/api/video/testCallback", method = {RequestMethod.POST,RequestMethod.GET})
    public String callback(@RequestBody String ossCallbackBody,
                           @RequestHeader("Authorization") String authorization,
                           @RequestParam("callback") String callbackMethodName,
                           @RequestHeader("x-oss-pub-key-url") String publicKeyUrlBase64,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        System.out.println("testCallback invoked, verifying oss callback details");
        boolean isOssCallback = CallbackUtil.verifyOSSCallbackRequest(authorization
                , publicKeyUrlBase64
                , ossCallbackBody
                , request.getQueryString()
                , request.getRequestURI());

        if (isOssCallback) {
            response.setStatus(HttpServletResponse.SC_OK);
            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("success",true);
            jsonObject.put("code",Message.SUCCESS);
            return jsonObject.toString();
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("success",false);
            jsonObject.put("code",Message.GENERAL_FAIL);
            return jsonObject.toString();
        }
    }

//    @RequestMapping(value = "oss/policy")
    @RequestMapping(value = "/api/video/testGetFile")
    @ResponseBody
    public String createPolicy(@RequestBody JSONObject jsonObject){
        String dir=jsonObject.getString("uploadpath");
        System.out.println("testGetFile invoked, creating policy of directory "+dir);
        return Policy.createPolicy(dir).toJSONString();

    }

}
