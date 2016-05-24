package com.papercut.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.papercut.TestApplicationConfig;
import com.papercut.exception.InvalidPrintJobException;
import com.papercut.exception.PricingNotDefinedException;
import com.papercut.model.Money;
import com.papercut.model.PaperSide;
import com.papercut.model.PrintJob;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestApplicationConfig.class)
public class PricingRulesEngineTest {

    @Autowired
    PricingRulesEngine pricingRulesEngine;
    
    @Autowired
    PriceExecutable priceExecutor;
    
    private static final Logger logger = LoggerFactory.getLogger(PricingRulesEngineTest.class);
    
    
    @Test
    public void executeSinglePrintJob_willTestSuccess() throws Exception {
    	 
    	 PrintJob printJob = new PrintJob(11,5,PaperSide.SINGLE);
    
    	 pricingRulesEngine.executeRules(printJob);
    	 
    	 Money totalPayablePrice = priceExecutor.getTotalPrice(printJob);
    	 assertTrue("Cost should be at least more than $0.00)", totalPayablePrice.getAmount().compareTo(BigDecimal.ZERO) > 0);
    	 
    	 logger.info("Single print job price: " + totalPayablePrice.toString());
    }
    
    
    @Test(expected=InvalidPrintJobException.class)
    public void executeSinglePrintJob_willTestFailureWhenColourPagesMoreThanOverallPages() throws Exception {
    	 
    	 PrintJob printJob = new PrintJob(11,5555,PaperSide.SINGLE);
    
    	 pricingRulesEngine.executeRules(printJob);
    	 
    	 priceExecutor.getTotalPrice(printJob);

    }
    
    
    @Test(expected=PricingNotDefinedException.class)
    public void executeSinglePrintJob_willTestFailureForWhenPricingNotFound() throws Exception {
    	 
    	 PrintJob printJob = new PrintJob();
    
    	 pricingRulesEngine.executeRules(printJob);
    	 
    	 priceExecutor.getTotalPrice(printJob);

    }
    
    @Test
    public void executeMultiplePrintJobs_willTestSuccess() throws Exception {
    	 
    	 List<PrintJob> printJobs = Arrays.asList(
    			 new PrintJob(1,11,5,PaperSide.SINGLE),
    			 new PrintJob(2,9,5,PaperSide.SINGLE),
    			 new PrintJob(3,13,5,PaperSide.DOUBLE));
    
    	 pricingRulesEngine.executeRules(printJobs);
    	    
    	 Money totalPayablePrice = priceExecutor.getTotalPrice(printJobs);
    	 
    	 assertTrue("Cost of all print jobs should be at least more than $0.00)", totalPayablePrice.getAmount().compareTo(BigDecimal.ZERO) > 0);
    	 
    	 
    	 logger.info("Multiple print job price: " + totalPayablePrice.toString());
    }
    
    @Test(expected=PricingNotDefinedException.class)
    public void executeMultiplePrintJobs_willTestFailureForSingleBadJob() throws Exception {
    	 
    	 List<PrintJob> printJobs = Arrays.asList(
    			 new PrintJob(1,11,5,PaperSide.SINGLE),
    			 // no pricing to be found for below job
    			 new PrintJob(),
    			 new PrintJob(3,13,5,PaperSide.DOUBLE));
    
    	 pricingRulesEngine.executeRules(printJobs);
    	    
    	 priceExecutor.getTotalPrice(printJobs);
    	 
    }

}

