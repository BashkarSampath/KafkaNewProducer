package demo.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.common.errors.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bashkarsampath.eventcollector.avro.EventCollector;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo.configuration.SwaggerDocumentation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@SwaggerDocumentation
public class ProducerController {
	@Autowired
	private KafkaTemplate<String, EventCollector> kafkaTemplate;

	class FCallBack implements ListenableFutureCallback<Object> {
		@Override
		public void onSuccess(Object result) {
			log.info("Success : Result => " + result.toString());
		}

		@Override
		public void onFailure(Throwable ex) {
			log.error("Failure: " + ex.toString());
			ex.printStackTrace();
		}
	}

	@PostMapping(value = "/event", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> doIt(@RequestBody(required = true) EventCollector json)
			throws JsonProcessingException, InterruptedException, ExecutionException, TimeoutException, Exception {
		try {
			log.info(new ObjectMapper().writeValueAsString(json));
			kafkaTemplate.send("event", json).get(2200, TimeUnit.MILLISECONDS);			 
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
