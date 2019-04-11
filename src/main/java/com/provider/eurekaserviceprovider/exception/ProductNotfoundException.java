package com.provider.eurekaserviceprovider.exception;

public class ProductNotfoundException extends RuntimeException {
	public ProductNotfoundException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 1L;
}
