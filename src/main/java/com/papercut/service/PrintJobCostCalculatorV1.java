package com.papercut.service;
/**
* The calculator class that supplies the algorith against which a price can be determined
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/
import java.util.function.Supplier;

import com.papercut.model.Money;
import com.papercut.model.PrintJob;

@FunctionalInterface
public interface PrintJobCostCalculatorV1 {
	public Supplier<Money> calculateTotalPriceOfJob(PrintJob printJob) throws Exception;
}
