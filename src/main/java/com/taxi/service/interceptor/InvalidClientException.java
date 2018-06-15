package com.taxi.service.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Invalid API Token")
class InvalidClientException extends RuntimeException {

}
