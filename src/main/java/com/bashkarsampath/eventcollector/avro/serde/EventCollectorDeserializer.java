package com.bashkarsampath.eventcollector.avro.serde;

import org.apache.kafka.common.serialization.Deserializer;

import com.bashkarsampath.eventcollector.avro.EventCollector;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EventCollectorDeserializer implements Deserializer<EventCollector> {
	@Override
	public EventCollector deserialize(String s, byte[] bytes) {
		ObjectMapper objectMapper = new ObjectMapper();
		EventCollector object = null;
		objectMapper.addMixIn(EventCollector.class, IgnoreSchemaProperty.class);
		try {
			object = objectMapper.readValue(bytes, EventCollector.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
}