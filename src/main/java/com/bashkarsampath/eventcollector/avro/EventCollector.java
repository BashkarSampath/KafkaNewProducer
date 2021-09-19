
package com.bashkarsampath.eventcollector.avro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "eventHeader",
    "eventAttributes"
})
@Data @ToString
public class EventCollector {

    @JsonProperty("eventHeader")
    private EventHeader eventHeader;
    @JsonProperty("eventAttributes")
    private EventAttributes eventAttributes;

    @JsonProperty("eventHeader")
    public EventHeader getEventHeader() {
        return eventHeader;
    }

    @JsonProperty("eventHeader")
    public void setEventHeader(EventHeader eventHeader) {
        this.eventHeader = eventHeader;
    }

    public EventCollector withEventHeader(EventHeader eventHeader) {
        this.eventHeader = eventHeader;
        return this;
    }

    @JsonProperty("eventAttributes")
    public EventAttributes getEventAttributes() {
        return eventAttributes;
    }

    @JsonProperty("eventAttributes")
    public void setEventAttributes(EventAttributes eventAttributes) {
        this.eventAttributes = eventAttributes;
    }

    public EventCollector withEventAttributes(EventAttributes eventAttributes) {
        this.eventAttributes = eventAttributes;
        return this;
    }

}
