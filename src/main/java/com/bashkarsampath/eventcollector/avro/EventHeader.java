
package com.bashkarsampath.eventcollector.avro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "source_event_id",
    "source_application_code",
    "source_system_name",
    "event_timestamp",
    "event_channel_type",
    "event_activity_type"
})
@Data @ToString
public class EventHeader {

    @JsonProperty("source_event_id")
    private String sourceEventId;
    @JsonProperty("source_application_code")
    private String sourceApplicationCode;
    @JsonProperty("source_system_name")
    private String sourceSystemName;
    @JsonProperty("event_timestamp")
    private String eventTimestamp;
    @JsonProperty("event_channel_type")
    private String eventChannelType;
    @JsonProperty("event_activity_type")
    private String eventActivityType;

    @JsonProperty("source_event_id")
    public String getSourceEventId() {
        return sourceEventId;
    }

    @JsonProperty("source_event_id")
    public void setSourceEventId(String sourceEventId) {
        this.sourceEventId = sourceEventId;
    }

    public EventHeader withSourceEventId(String sourceEventId) {
        this.sourceEventId = sourceEventId;
        return this;
    }

    @JsonProperty("source_application_code")
    public String getSourceApplicationCode() {
        return sourceApplicationCode;
    }

    @JsonProperty("source_application_code")
    public void setSourceApplicationCode(String sourceApplicationCode) {
        this.sourceApplicationCode = sourceApplicationCode;
    }

    public EventHeader withSourceApplicationCode(String sourceApplicationCode) {
        this.sourceApplicationCode = sourceApplicationCode;
        return this;
    }

    @JsonProperty("source_system_name")
    public String getSourceSystemName() {
        return sourceSystemName;
    }

    @JsonProperty("source_system_name")
    public void setSourceSystemName(String sourceSystemName) {
        this.sourceSystemName = sourceSystemName;
    }

    public EventHeader withSourceSystemName(String sourceSystemName) {
        this.sourceSystemName = sourceSystemName;
        return this;
    }

    @JsonProperty("event_timestamp")
    public String getEventTimestamp() {
        return eventTimestamp;
    }

    @JsonProperty("event_timestamp")
    public void setEventTimestamp(String eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public EventHeader withEventTimestamp(String eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
        return this;
    }

    @JsonProperty("event_channel_type")
    public String getEventChannelType() {
        return eventChannelType;
    }

    @JsonProperty("event_channel_type")
    public void setEventChannelType(String eventChannelType) {
        this.eventChannelType = eventChannelType;
    }

    public EventHeader withEventChannelType(String eventChannelType) {
        this.eventChannelType = eventChannelType;
        return this;
    }

    @JsonProperty("event_activity_type")
    public String getEventActivityType() {
        return eventActivityType;
    }

    @JsonProperty("event_activity_type")
    public void setEventActivityType(String eventActivityType) {
        this.eventActivityType = eventActivityType;
    }

    public EventHeader withEventActivityType(String eventActivityType) {
        this.eventActivityType = eventActivityType;
        return this;
    }

}
