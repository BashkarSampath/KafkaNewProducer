package com.bashkarsampath.eventcollector.avro.serde;

import org.apache.kafka.common.serialization.Serializer;

import com.bashkarsampath.eventcollector.avro.EventCollector;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EventCollectorSerializer implements Serializer<EventCollector> {

    @Override
    public byte[] serialize(String s, EventCollector quote) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.addMixIn(EventCollector.class, IgnoreSchemaProperty.class);
        try {
            retVal = objectMapper.writeValueAsString(quote).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }
}