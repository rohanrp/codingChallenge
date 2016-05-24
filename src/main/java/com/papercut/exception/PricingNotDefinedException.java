package com.papercut.exception;

/**
* An exception to be thrown when a pricing algorithm is not defined or valid for a print job
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/
public class PricingNotDefinedException extends Exception {

	private static final long serialVersionUID = 7214179734791244446L;

	/**
     * Constructs a new {@code InvalidInputException} object without a detail
     * message.
     */
    public PricingNotDefinedException() {

    }

    /**
     * Constructs a new {@code InvalidInputException} object with the specified
     * detail message.
     *
     * @param msg the message to generate when a {@code InvalidInputException}
     * is thrown
     */
    public PricingNotDefinedException(String msg) {
        super(msg);
    }
}