package com.bashkarsampath.eventcollector.avro.serde;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import com.bashkarsampath.eventcollector.avro.EventCollector;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EventCollectorSerde implements Serde<EventCollector> {
	@Override
	public Serializer<EventCollector> serializer() {
		return new EventCollectorSerializer();
	}

	@Override
	public Deserializer<EventCollector> deserializer() {
		return new EventCollectorDeserializer();
	}
}