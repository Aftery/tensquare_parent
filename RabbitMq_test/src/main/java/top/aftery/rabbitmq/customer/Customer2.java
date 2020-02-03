package top.aftery.rabbitmq.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName Customer2
 * @Description  分列模式消息消费者
 * @Author Aftery
 * @Date 2020/2/2 12:27
 * @Version 1.0
 */
@Slf4j
@Component
@RabbitListener(queues = "aftery")
public class Customer2 {

    @RabbitHandler
    public void  showMessage(String msg){
      log.info("after----------------;"+msg);
    }


}
