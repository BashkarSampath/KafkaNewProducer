package demo.serde;

import com.fasterxml.jackson.annotation.JsonIgnore;

// create this class to ignore one or more fields
public abstract class IgnoreSchemaProperty {
	@JsonIgnore
	abstract void getSchema();
}