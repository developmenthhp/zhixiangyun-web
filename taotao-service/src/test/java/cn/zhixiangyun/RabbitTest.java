package cn.zhixiangyun;

import cn.zhixiangyun.component.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class RabbitTest {

	@Autowired
	private Sender sender;

	@Test
	public void sendTest() throws Exception {
		for (int i = 0; i < 3; i++) {
			//String msg = new Date().toString();
			sender.send("消息发送测试");
			//Thread.sleep(2000);
		}
	}
}
