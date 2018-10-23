package cn.edu.nju.videoupload.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Yang Yuqing
 * @Description:
 * @Date: Created in 10:26 AM 10/23/18
 * @Modifiedby:
 */

public class Policy {
    private static Logger logger = Logger.getLogger(Policy.class);

    public static JSONObject createPolicy(String dir) {
        OSSClient client = new OSSClient(Constant.ENDPOINT, Constant.ACCESS_ID, Constant.ACCESS_KEY);
        long expireTime = 30;
        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);
        String postPolicy = client.generatePostPolicy(expiration, policyConds);
        String encodedPolicy;
        String postSignature;

        try {

            byte[] binaryData = postPolicy.getBytes("utf-8");
            encodedPolicy = BinaryUtil.toBase64String(binaryData);
            postSignature = client.calculatePostSignature(postPolicy);

        } catch (Exception e) {
            logger.error(e);
            return null;
        }
        Map<String, Object> respMap = new LinkedHashMap<String, Object>();
        respMap.put("accessid", Constant.ACCESS_ID);
        respMap.put("policy", encodedPolicy);
        respMap.put("signature", postSignature);
        respMap.put("dir", dir);
        respMap.put("host", Constant.HOST);
        respMap.put("expire", String.valueOf(expireEndTime / 1000));

        JSONObject callback = new JSONObject();
        callback.put("callbackUrl",Constant.CALL_BACK_URL);
        callback.put("callbackBody","{\"mobile\":189****,\"purpose\":100");

        BASE64Encoder encoder = new BASE64Encoder();
        respMap.put("callback", encoder.encode(callback.toString().getBytes()));
        return new JSONObject(respMap);
    }
}
