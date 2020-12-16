package com.n26.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY,reason = "Transaction time is in future")
public class TransactionTimeNotValidException extends RuntimeException {

}
