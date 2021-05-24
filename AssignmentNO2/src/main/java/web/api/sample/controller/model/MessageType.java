package web.api.sample.controller.model;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.stream.Stream;

public enum MessageType {

	RECORD_NOT_FOUND("Record not found."),
	RECORD_DELETED("Record has been deleted."),
	INSERT_SUCCESS("Record has been inserted."),
	INTERNAL_ERROR("Internal service error. Please check with the web admin.");
	
	private String code;
	
	private MessageType(String code) {
		this.code = code;
	}
	
	public static MessageType decode(final String error) {		
		return Stream.of(MessageType.values())
				.filter(e -> e.code.equals(error))
				.findFirst().orElse(null);
	}
	
	@JsonValue
	public String getCode() {
		return code;
	}
}