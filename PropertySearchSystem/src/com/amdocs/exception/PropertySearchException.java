package com.amdocs.exception;

public class PropertySearchException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L; //serialVersionUID must be static,final and of type long. 

	public PropertySearchException(String message) {
        //super(message);
        System.out.println("This requirement is unavailable");
    }
}

