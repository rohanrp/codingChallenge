package com.papercut.service;

import java.io.IOException;
import java.util.List;

import com.papercut.exception.CSVDataConversionException;
import com.papercut.model.PrintJob;

public interface CSVPrintJobReadeable {
	
	List<PrintJob> readCSVFile(String fileName) throws CSVDataConversionException, IOException;
}
