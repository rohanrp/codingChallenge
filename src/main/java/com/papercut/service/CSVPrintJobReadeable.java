package com.papercut.service;
/**
* A class to help read a CSV file into a list of print job objects
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/
import java.io.IOException;
import java.util.List;

import com.papercut.exception.CSVDataConversionException;
import com.papercut.model.PrintJob;

public interface CSVPrintJobReadeable {
	
	List<PrintJob> readCSVFile(String fileName) throws CSVDataConversionException, IOException;
}
