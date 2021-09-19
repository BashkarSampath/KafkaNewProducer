package demo.controller;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunilvb.demo.Order;

import demo.configuration.SwaggerDocumentation;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@SwaggerDocumentation
public class ProducerController {

	@Value("${spring.kafka.properties.bootstrap.servers}")
	private String bootstrap;
	@Value("${spring.kafka.properties.schema.registry.url}")
	private String registry;

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	class FCallBack implements ListenableFutureCallback<Object> {
		@Override
		public void onSuccess(Object result) {
			System.out.println("Success : Result => " + result);
		}

		@Override
		public void onFailure(Throwable ex) {
			System.err.println("Failure: " + ex.toString());
			ex.printStackTrace();
		}
	}

	@PostMapping("/orders")
	public String doIt(@RequestParam(defaultValue = "event") String topic) {

		String ret = topic;
//			ret += "<br>Using Bootstrap : " + bootstrap;
//			ret += "<br>Using Bootstrap : " + registry;
//
//			Properties properties = new Properties();
//			// Kafka Properties
//			properties.setProperty("bootstrap.servers", bootstrap);
//			properties.setProperty("acks", "all");
//			properties.setProperty("retries", "10");
//			// Avro properties
//			properties.setProperty("key.serializer", StringSerializer.class.getName());
//			properties.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
//			properties.setProperty("schema.registry.url", registry);

//			ret += sendMsg(properties, topic);

		Order order = Order.newBuilder().setOrderId("OId234").setCustomerId("CId432").setSupplierId("SId543")
				.setItems(4).setFirstName("Sunil").setLastName("V").setPrice(178f).setWeight(75f).build();
		ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(topic, order);
		FCallBack fcb = new FCallBack();
		kafkaTemplate.send(producerRecord).addCallback(fcb);
		return "sent async: "+ret;
	}

//	private Order sendMsg(Properties properties, String topic) {
//		Producer<String, Order> producer = new KafkaProducer<>(properties);
//
//		Order order = Order.newBuilder().setOrderId("OId234").setCustomerId("CId432").setSupplierId("SId543")
//				.setItems(4).setFirstName("Sunil").setLastName("V").setPrice(178f).setWeight(75f).build();
//
//		ProducerRecord<String, Order> producerRecord = new ProducerRecord<>(topic, order);
//
//		producer.send(producerRecord, new Callback() {
//			@Override
//			public void onCompletion(RecordMetadata metadata, Exception exception) {
//				if (exception == null) {
//					log.info(metadata + "");
//				} else {
//					log.error(exception.getMessage());
//				}
//			}
//		});
//
//		producer.flush();
//		producer.close();
//
//		return order;
//	}
}
