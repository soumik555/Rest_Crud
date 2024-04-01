package org.jsp.rest_crud.helper;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@Data

public class ResponseStructure <T> {
	String message;
	int status;
	T data;;

}
