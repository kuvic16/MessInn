package com.vagabondlab.messinn.util.properties;

/**
 * @author Shaiful Islam palash | <kuvic16@gmail.com>
 * @since version 0.0.1
 */
public class PropertyExcetion extends RuntimeException {

	private static final long serialVersionUID = -7137921619885853703L;

	public PropertyExcetion() {
		super();
	}

	public PropertyExcetion(String message, Throwable cause) {
		super(message, cause);
	}

	public PropertyExcetion(String message) {
		super(message);
	}

	public PropertyExcetion(Throwable cause) {
		super(cause);
	}
}
