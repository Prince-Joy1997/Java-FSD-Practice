package com.topjobs.topjob_authentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Username already exists")

public class DuplicateUsernameException extends Exception {

	private static final long serialVersionUID = 1L;

}
