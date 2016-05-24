package com.papercut.service;

import java.util.List;

import com.papercut.model.PrintJob;

public interface PricingRulesEngine {

	 void executeRules(PrintJob printJob);
	 
	 void executeRules(List<PrintJob> printJobs);
}
