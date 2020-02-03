package top.aftery.rabbitmq.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName Customer1
 * @Description 直连模式获取消息
 * @Author Aftery
 * @Date 2020/2/2 12:27
 * @Version 1.0
 */
@Slf4j
@Component
@RabbitListener(queues = "top")
public class Customer1 {

    @RabbitHandler
    public void  showMessage(String msg){
      log.info("top----------------;;;"+msg);
    }


}
