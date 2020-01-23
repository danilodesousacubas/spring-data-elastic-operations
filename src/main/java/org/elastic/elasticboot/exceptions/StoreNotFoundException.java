package org.elastic.elasticboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Store Not Found")
public class StoreNotFoundException extends Exception {
	private static final long serialVersionUID = 2027117996094283862L;
}