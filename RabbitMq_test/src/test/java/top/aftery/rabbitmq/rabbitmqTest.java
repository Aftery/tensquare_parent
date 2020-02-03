package top.aftery.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName rabbitmqTest
 * @Description rabbitmqTest
 * @Author Aftery
 * @Date 2020/2/2 11:58
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RqbbitMqApplication.class)
public class rabbitmqTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * Direct模式
     */
    @Test
    public void sendMes() {
        rabbitTemplate.convertAndSend("top", "ss");
    }

    /**
     * Fanout 分列模式
     */
    @Test
    public void sendMes2() {
        rabbitTemplate.convertAndSend("chuanzhi","", "分列模式走起");

    }

    /**
     * topic 主题模式
     * top会接收到消息（规则：goods.#）
     */
    @Test
    public void testSendTopic1() {
        rabbitTemplate.convertAndSend("toptest","goods.aaa","主题模式");
    }

    /**
     * topic 主题模式
     * aftery会接收到消息（规则：#.log）
     */
    @Test
    public void testSendTopic2() {
        rabbitTemplate.convertAndSend("toptest","article.content.log","主题模式");
    }

    /**
     * topic 主题模式
     * 三个都会接受到消息（规则：goods.#,goods.log,#.log）
     */
    @Test
    public void testSendTopic3(){
        rabbitTemplate.convertAndSend("toptest","goods.log","主题模式");
    }

}
