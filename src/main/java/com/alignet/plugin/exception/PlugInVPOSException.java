package com.alignet.plugin.exception;

public class PlugInVPOSException extends RuntimeException {
	private static final long serialVersionUID = 0L;

	public PlugInVPOSException(String s) {
		super(s);
	}

	public PlugInVPOSException(String s, Throwable throwable) {
		super(s);
	}
}
