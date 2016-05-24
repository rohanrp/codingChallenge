package com.papercut.service;
/**
* A rules engine to run a print job against a set of pricing rules
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/
import java.util.List;

import com.papercut.model.PrintJob;

public interface PricingRulesEngine {

	 void executeRules(PrintJob printJob);
	 
	 void executeRules(List<PrintJob> printJobs);
}
