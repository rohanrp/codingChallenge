package com.papercut.service;

import java.util.function.Supplier;

import com.papercut.model.Money;
import com.papercut.model.PrintJob;

@FunctionalInterface
public interface PrintJobCostCalculatorV1 {
	public Supplier<Money> calculateTotalPriceOfJob(PrintJob printJob) throws Exception;
}
