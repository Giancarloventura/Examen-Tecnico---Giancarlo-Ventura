package com.spring.fullstack.test.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@AllArgsConstructor @NoArgsConstructor
public class Response {
	private StatusSpring status;
	private String message;
	private Object body;
	
	public Response(StatusSpring status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public Response(StatusSpring status, Object body) {
		this.status = status;
		this.body = body;
	}
}
