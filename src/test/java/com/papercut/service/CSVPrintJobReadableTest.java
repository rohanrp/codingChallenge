package com.papercut.service;
/**
* Tests for mapping of csv files into valid/invalid print jobs
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.papercut.TestApplicationConfig;
import com.papercut.exception.CSVDataConversionException;
import com.papercut.model.PrintJob;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestApplicationConfig.class)
public class CSVPrintJobReadableTest {

	@Autowired
	CSVPrintJobReadeable fileReader;
	
    @Test
    public void readCSVFile_willTestSuccess() throws Exception {
    	 
    	 List<PrintJob> printJobs = fileReader.readCSVFile("printjobs.csv");
    	
    	 assertTrue("There should be more than one pront job", printJobs.size() > 0);
    	 
    }
    
    @Test(expected=CSVDataConversionException.class)
    public void readCSVFile_willTestFailureWhenDataCannotBeMapped() throws Exception {
    	 
    	 fileReader.readCSVFile("invalid_printjobs.csv");
    	
    }

}

