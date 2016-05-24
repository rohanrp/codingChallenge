package com.papercut;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.papercut.model.PrintJob;
import com.papercut.service.CSVPrintJobReadeable;
import com.papercut.service.PriceExecutable;
import com.papercut.service.PricingRulesEngine;

@Component
public class PrintJobConsoleRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(PrintJobConsoleRunner.class);
	
	@Autowired
	PriceExecutable priceExecutor;
	
	@Autowired
	PricingRulesEngine rulesEngine;
	
	@Autowired
	CSVPrintJobReadeable fileReader;
	
	@Override
	public void run(String... arg0) throws Exception {
		
        
		List<PrintJob> printJobs = fileReader.readCSVFile("printjobs.csv");

        //register the pricing rules
        rulesEngine.executeRules(printJobs);
        
        // print results
        logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info("Total Cost of All Print JOBS+++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info("+++ " + priceExecutor.getTotalPrice(printJobs).toString());
        
        
        logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info("Breakdown of costs by job+++++++++++++++++++++++++++++++++++++++++++++++++");
        
        for (PrintJob printJob : printJobs) {
        	logger.info("+++ " + priceExecutor.getTotalPrice(printJob).toString());
        }
        
        
        
        
		
	}
	
}