package com.papercut.service;
/**
* Tests the pricing algorithm to ensure it is mathematically sound
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.papercut.TestApplicationConfig;
import com.papercut.model.Money;
import com.papercut.model.PaperSide;
import com.papercut.model.PrintJob;
import com.papercut.model.PrintJobPricing;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestApplicationConfig.class)
public class PricingCalculationTest {

	@Autowired
	PrintJobCostCalculatorV1 calculator;
	
	
	@Autowired
	PriceExecutable priceExecutor;
	
	
    @Test
    public void calculateTotalPriceOfSingleJob_willTestSuccessBasePriceOnly() throws Exception {
    	 
    	// set custom pricing
    	PrintJobPricing printPricing = new PrintJobPricing();
		printPricing.setBasePricePerPage(Money.dollars(new BigDecimal("0.10")));
		printPricing.setColourPremiumPerPage(Money.dollars(new BigDecimal("0.0")));
		
    	// set print job with custom pricing
		PrintJob printJob = new PrintJob(10,0,PaperSide.SINGLE);
		printJob.setPrintJobPricing(printPricing);
		
		BigDecimal price  = calculator.calculateTotalPriceOfJob(printJob).get().getAmount();
		
    	assertTrue("10 pages times 10 cents of base pricing should be $1.00", price.equals(new BigDecimal("1.00")));
    	 
    }
    
    @Test
    public void calculateTotalPriceOfSingleJob_willTestSuccessColourPremiumOnly() throws Exception {
    	 
    	// set custom pricing
    	PrintJobPricing printPricing = new PrintJobPricing();
		printPricing.setBasePricePerPage(Money.dollars(new BigDecimal("0.00")));
		printPricing.setColourPremiumPerPage(Money.dollars(new BigDecimal("0.10")));
		
    	// set print job with custom pricing
		PrintJob printJob = new PrintJob(10,10,PaperSide.SINGLE);
		printJob.setPrintJobPricing(printPricing);
		
		BigDecimal price  = calculator.calculateTotalPriceOfJob(printJob).get().getAmount();
		
    	assertTrue("10 pages times 10 cents of colour premium pricing should be $1.00", price.equals(new BigDecimal("1.00")));
    	 
    }
    
    @Test
    public void calculateTotalPriceOfMultipleJob_willTestSuccess() throws Exception {
    	 
    	// set custom pricing
    	PrintJobPricing printPricing = new PrintJobPricing();
		printPricing.setBasePricePerPage(Money.dollars(new BigDecimal("0.10")));
		printPricing.setColourPremiumPerPage(Money.dollars(new BigDecimal("0.0")));
		
    	// set print job with custom pricing
		PrintJob printJob1 = new PrintJob(10,0,PaperSide.SINGLE);
		printJob1.setPrintJobPricing(printPricing);
		
		PrintJob printJob2 = new PrintJob(10,0,PaperSide.SINGLE);
		printJob2.setPrintJobPricing(printPricing);
		
		List<PrintJob> printJobs = Arrays.asList(printJob1,printJob2);
		
		
		BigDecimal price  = priceExecutor.getTotalPrice(printJobs).getAmount();
		
    	assertTrue("2 jobs of 10 pages times 10 cents of base pricing should be $2.00", price.equals(new BigDecimal("2.00")));
    	 
    }
    
    
    

}

