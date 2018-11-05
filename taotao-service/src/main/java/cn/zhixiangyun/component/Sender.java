package cn.zhixiangyun.component;

import cn.zhixiangyun.App;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * @author hhp
 * @Title: Sender
 * @Description: 向mq发送消息
 * @param:
 * @return:
 * @throws
 */
@Component
public class Sender implements RabbitTemplate.ConfirmCallback, ReturnCallback {

	private static Logger logger = Logger.getLogger(App.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@PostConstruct
	public void init() {
		rabbitTemplate.setConfirmCallback(this);
		rabbitTemplate.setReturnCallback(this);
	}

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		if (ack) {
			logger.info("消息发送成功:" + correlationData);
		} else {
			logger.info("消息发送失败:" + cause);
		}

	}

	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		logger.error(message.getMessageProperties().getCorrelationIdString() + " 发送失败");

	}

	// 发送消息，
	public void send(String msg) {

		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());

		logger.info("开始发送消息 : " + msg.toLowerCase());
		String response = rabbitTemplate.convertSendAndReceive("topicExchange", "key.1", msg, correlationId).toString();
		logger.info("结束发送消息 : " + msg.toLowerCase());
		logger.info("消费者响应 : " + response + " 消息处理完成");
	}
}