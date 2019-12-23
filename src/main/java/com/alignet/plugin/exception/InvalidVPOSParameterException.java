package com.alignet.plugin.exception;

public class InvalidVPOSParameterException extends PlugInVPOSException {
	private static final long serialVersionUID = 0L;

	public InvalidVPOSParameterException(String s) {
		super(s);
	}

	public InvalidVPOSParameterException(String s, Throwable throwable) {
		super(s, throwable);
	}
}
