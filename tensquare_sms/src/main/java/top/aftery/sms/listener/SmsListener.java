package top.aftery.sms.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import top.aftery.sms.utils.SendSmsUtils;

import java.util.Map;

/**
 * @ClassName SmsListener
 * @Description SmsListener
 * @Author Aftery
 * @Date 2020/2/2 18:57
 * @Version 1.0
 */
@Slf4j
@Component
@RabbitListener(queues = "sms")
public class SmsListener {


    @Value("${aliyun.sms.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.sms.accessSecret}")
    private String accessSecret;

    @Autowired
    private SendSmsUtils smsUtils;

    /**
     * 获取消息队列中的数据发送短信验证码
     *
     * @param map
     */
    @RabbitHandler
    public void sendSms(Map<String, String> map) {

        String checkCode = map.get("code");
        String mobile = map.get("mobile");
        String dataSms = smsUtils.sendSms(accessKeyId, accessSecret, mobile, checkCode);

        log.info("发送给:{}的验证码是{},返回结果:{}", mobile, checkCode, dataSms);

    }
}
