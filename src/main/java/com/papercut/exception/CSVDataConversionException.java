package com.papercut.exception;

/**
* An exception to be thrown when a CSV file cannot be mapped to a defined object
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/
public class CSVDataConversionException extends Exception {

	private static final long serialVersionUID = 7314179734791244446L;

    public CSVDataConversionException() {

    }

    public CSVDataConversionException(String msg) {
        super(msg);
    }
}