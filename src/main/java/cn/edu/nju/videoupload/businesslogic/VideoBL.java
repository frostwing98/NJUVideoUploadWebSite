package cn.edu.nju.videoupload.businesslogic;

import cn.edu.nju.videoupload.entity.Message;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;

import java.io.IOException;

/**
 * @Author: Yang Yuqing
 * @Description:
 * @Date: Created in 21:08 14.10.18
 * @Modifiedby:
 */

public class VideoBL {
    private static String endpoint = "oss-cn-shanghai.aliyuncs.com";
    private static String accessKeyId = "LTAIKHMNHtT6um1j";
    private static String accessKeySecret = "DXyIGAddKMVBTVUUhSx9xgFBoDH3Do";
    private static String bucketName = "videouploaddemo";
    private static String key = "test/file/1.flv";
    private static String uploadFile = "/home/allen/Films/1.flv";

    public int upload(){

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            ListMultipartUploadsRequest listMultipartUploadsRequest=new ListMultipartUploadsRequest(bucketName);
            MultipartUploadListing multipartUploadListing=ossClient.listMultipartUploads(listMultipartUploadsRequest);
            System.out.println("result:"+multipartUploadListing.getNextUploadIdMarker());
//            ListPartsRequest listPartsRequest=new ListPartsRequest(bucketName,key,listMultipartUploadsRequest.);


            UploadFileRequest uploadFileRequest = new UploadFileRequest(bucketName, key);
            // The local file to upload---it must exist.
            uploadFileRequest.setUploadFile(uploadFile);
            // Sets the concurrent upload task number to 5.
            uploadFileRequest.setTaskNum(1);
            // Sets the part size to 1MB.
            uploadFileRequest.setPartSize(1024 * 1024 * 1);
            // Enables the checkpoint file. By default it's off.
            uploadFileRequest.setEnableCheckpoint(true);

            UploadFileResult uploadResult = ossClient.uploadFile(uploadFileRequest);

            CompleteMultipartUploadResult multipartUploadResult =
                    uploadResult.getMultipartUploadResult();
//            System.out.println(multipartUploadResult.getETag());

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message: " + oe.getErrorCode());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ce.getMessage());
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
        return Message.SUCCESS;
    }
}
