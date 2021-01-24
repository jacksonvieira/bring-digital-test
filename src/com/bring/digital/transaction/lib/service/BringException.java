package com.bring.digital.transaction.lib.service;

public class BringException extends Exception {

	private static final long serialVersionUID = 1L;

	public BringException(String message) {
		super(message);
	}

	public BringException(Throwable cause) {
		super(cause);
	}

	public BringException(String message, Throwable cause) {
		super(message, cause);
	}
}
