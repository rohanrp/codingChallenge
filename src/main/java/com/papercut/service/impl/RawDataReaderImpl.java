package com.papercut.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.papercut.exception.CSVDataConversionException;
import com.papercut.model.PaperSide;
import com.papercut.model.PrintJob;
import com.papercut.service.CSVPrintJobReadeable;

/**
 * @author Rohan Pereira
 * 
 */
 
@Service
public class RawDataReaderImpl implements CSVPrintJobReadeable {
 
	public List<PrintJob> readCSVFile(String fileName) throws CSVDataConversionException, IOException {
		BufferedReader br = getFile(fileName);
		
		List<PrintJob> persons = null;
		try {
			persons = br.lines()
			    .map(mapToPrintJob)
			    .collect(Collectors.toList());
		} catch (Exception e) {
			throw new CSVDataConversionException("Unable to parse CSV file into a a print job object");
		} finally {
			br.close();
		}
		
		return persons;
	}
 
	
	public static Function<String, PrintJob> mapToPrintJob = (line) -> {
		  String[] p = line.split(", ");
		   PrintJob printJob = new PrintJob(0, Integer.parseInt(p[0]), Integer.parseInt(p[1]), PaperSide.getPaperSideByBoolean(Boolean.parseBoolean(p[2])));
		   return printJob;
	};
	
	
	public BufferedReader getFile(String fileName) throws FileNotFoundException {
		InputStream is = RawDataReaderImpl.class.getResourceAsStream("/" + fileName);
		
		if(is == null)
        {
            throw new FileNotFoundException("Resource file not found. Note that the current directory is the source folder!");
        }
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		
		return br;
		
	}
		
		
}