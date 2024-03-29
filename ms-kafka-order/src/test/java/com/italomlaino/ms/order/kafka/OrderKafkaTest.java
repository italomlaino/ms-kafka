package com.italomlaino.ms.order.kafka;

import com.italomlaino.ms.order.OrderApp;
import com.italomlaino.ms.order.OrderTestDataGenerator;
import com.italomlaino.ms.order.logic.OrderService;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApp.class, webEnvironment = WebEnvironment.NONE)
@ActiveProfiles("test")
public class OrderKafkaTest {

	public static Logger logger = LoggerFactory.getLogger(OrderKafkaTest.class);

	@ClassRule
	public static EmbeddedKafkaRule embeddedKafka = new EmbeddedKafkaRule(1, false, "order");

	@Autowired
	private KafkaListenerBean kafkaListenerBean;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderTestDataGenerator orderTestDataGenerator;

	@BeforeClass
	public static void setUpBeforeClass() {
		System.setProperty("spring.kafka.bootstrap-servers", embeddedKafka.getEmbeddedKafka().getBrokersAsString());
	}

	@Test
	public void orderCreatedSendsKafkaMassage() throws Exception {
		int receivedBefore = kafkaListenerBean.getReceived();
		orderService.order(orderTestDataGenerator.createOrder());
		int i = 0;
		while (kafkaListenerBean.getReceived() == receivedBefore && i < 10) {
			Thread.sleep(1000);
			i++;
		}
		assertThat(kafkaListenerBean.getReceived(), is(greaterThan(receivedBefore)));
	}

}
