package com.papercut.service;

import java.util.List;

import com.papercut.model.Money;
import com.papercut.model.PrintJob;

public interface PriceExecutable {
	
	Money getTotalPrice(PrintJob printJob) throws Exception;
	Money getTotalPrice(List<PrintJob> printJobs) throws Exception;
}
