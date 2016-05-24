package com.papercut.exception;

/**
 * The {@code InvalidInputException} class used to indicate that an exceptional
 * condition has occurred in the Values Input to print system. Created by
 * nareshm on 4/09/2015.
 */
public class CSVDataConversionException extends Exception {

	private static final long serialVersionUID = 7314179734791244446L;

	/**
     * Constructs a new {@code InvalidInputException} object without a detail
     * message.
     */
    public CSVDataConversionException() {

    }

    /**
     * Constructs a new {@code InvalidInputException} object with the specified
     * detail message.
     *
     * @param msg the message to generate when a {@code InvalidInputException}
     * is thrown
     */
    public CSVDataConversionException(String msg) {
        super(msg);
    }
}