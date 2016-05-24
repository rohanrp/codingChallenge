package com.papercut.service.impl;
/**
* A rules engine to run a print job against a set of pricing rules
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/
import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

import java.util.List;

import javax.annotation.PostConstruct;

import org.easyrules.api.RulesEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.papercut.PrintJobConsoleRunner;
import com.papercut.model.PrintJob;
import com.papercut.rules.DoubleSidedA4PriceRule;
import com.papercut.rules.SingleSidedA4PriceRule;
import com.papercut.service.PricingRulesEngine;

@Service
@Scope("singleton")
public class PricingRulesEngineV1Impl implements PricingRulesEngine {

	private volatile static RulesEngine engineInstance;
	
	private static final Logger logger = LoggerFactory.getLogger(PrintJobConsoleRunner.class);
	
	@Autowired
	private SingleSidedA4PriceRule singleSidedA4;
	
	@Autowired
	private DoubleSidedA4PriceRule doubleSidedA4;
	
	private PricingRulesEngineV1Impl() {
	}

	/**
	 * create a rules engine through singleton pattern
	 */
	@PostConstruct
	public static RulesEngine getInstance() {
		if (engineInstance == null) {
			synchronized (PricingRulesEngineV1Impl.class) {
				engineInstance = aNewRulesEngine()
		        		.withSkipOnFirstAppliedRule(true)
		        	    .withSilentMode(true)
		        		.build();
			}
			logger.info("Pricing Engine Initialized");
		}		
		return engineInstance;
	}

	/**
	 * Register a bunch of pricing rules
	 * Reuses rules instead of initializing new rules for each print job
	 */
	@Override
	public synchronized void executeRules(PrintJob printJob) {
		//set the pricing metadata for the price rules
		singleSidedA4.setPrintJob(printJob);
		doubleSidedA4.setPrintJob(printJob);
		
		engineInstance.registerRule(singleSidedA4);
		engineInstance.registerRule(doubleSidedA4);
		
		//fire rules
		engineInstance.fireRules();
	}

	@Override
	public void executeRules(List<PrintJob> printJobs) {
		printJobs.forEach(PrintJob -> executeRules(PrintJob));
		
	}
	

}