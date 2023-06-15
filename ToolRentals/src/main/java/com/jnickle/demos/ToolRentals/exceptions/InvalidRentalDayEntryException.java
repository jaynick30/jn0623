package com.jnickle.demos.ToolRentals.exceptions;

public class InvalidRentalDayEntryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4522515274939132209L;

	public InvalidRentalDayEntryException(String errorMessage) {
		super(errorMessage);
	}
	
}
