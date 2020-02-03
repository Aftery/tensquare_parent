package top.aftery.sms.utils;


import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @ClassName SendSms
 * @Description SendSms
 * @Author Aftery
 * @Date 2020/2/3 17:32
 * @Version 1.0
 */
@Component
public class SendSmsUtils {


    /**
     * 短信签名名称
     */
    @Value("${aliyun.sms.SignName}")
    private String SignName;

    /**
     * 短信模板id
     */
    @Value("${aliyun.sms.TemplateCode}")
    private String TemplateCode;


    /**
     * @param accessKeyId  阿里云安全key
     * @param accessSecret 访问密钥密钥
     * @param PhoneNumbers 手机号码
     * @param chechCode    验证码
     * @return 短信发送返回结果
     */
    public String sendSms(String accessKeyId, String accessSecret, String PhoneNumbers, String chechCode) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", PhoneNumbers);
        request.putQueryParameter("SignName", "十次方验证码");
        request.putQueryParameter("TemplateCode", "SMS_183155363");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + chechCode + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            return response.getData();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }

}
