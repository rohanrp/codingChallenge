package com.papercut.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.papercut.model.Money;
import com.papercut.model.PrintJob;
import com.papercut.service.PriceExecutable;
import com.papercut.service.PrintJobCostCalculatorV1;
import com.papercut.util.LambdaExceptionUtil;

@Service
@Scope("singleton")
public class PriceExecutableImpl implements PriceExecutable {
	
	@Autowired
	PrintJobCostCalculatorV1 calculator;
	
	
	@Override
	public Money getTotalPrice(PrintJob printJob) throws Exception {
		return calculator.calculateTotalPriceOfJob(printJob).get();
	}


	@Override
	public Money getTotalPrice(List<PrintJob> printJobs) throws Exception {
		
		BigDecimal result = printJobs.stream()
		        .map(LambdaExceptionUtil.rethrowFunction(printJob -> getTotalPrice(printJob).getAmount()))
		        .reduce(BigDecimal.ZERO, BigDecimal::add);
		
		
		return Money.dollars(result);
	}
	
	
	
}
