package com.papercut.exception;

/**
* An exception to be thrown when a print job contains missing or invalid data
* that will produce an invalid price
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/
public class InvalidPrintJobException extends Exception {

	private static final long serialVersionUID = 7114179734791244446L;

    public InvalidPrintJobException() {

    }

    public InvalidPrintJobException(String msg) {
        super(msg);
    }
}