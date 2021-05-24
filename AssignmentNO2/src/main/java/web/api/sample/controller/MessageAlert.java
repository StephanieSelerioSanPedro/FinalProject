package web.api.sample.controller;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.stream.Stream;

public enum MessageAlert {

	RECORD_NOT_FOUND("Record not found."),
	RECORD_DELETED("Record has been deleted."),
	INSERT_SUCCESS("Record has been inserted."),
	INTERNAL_ERROR("Internal service error. Please check with the web admin."),
	UPDATE_ONLY("You can only Update here. No record found!"),
	RECORD_EXIST("Record already exists."),
	User_Exist("This person record id is existing");

	
	private String code;
	
	private MessageAlert(String code) {
		this.code = code;
	}
	
	public static MessageAlert decode(final String error) {		
		return Stream.of(MessageAlert.values())
				.filter(e -> e.code.equals(error))
				.findFirst().orElse(null);
	}
	
	@JsonValue
	public String getCode() {
		return code;
	}
}