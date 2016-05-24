package com.papercut.service;
/**
* PriceExecutable provides a medium that defines the type of pricing calculator
* to be applied to print job(s)
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/
import java.util.List;

import com.papercut.model.Money;
import com.papercut.model.PrintJob;

public interface PriceExecutable {
	
	Money getTotalPrice(PrintJob printJob) throws Exception;
	Money getTotalPrice(List<PrintJob> printJobs) throws Exception;
}
