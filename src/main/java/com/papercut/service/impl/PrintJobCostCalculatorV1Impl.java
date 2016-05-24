package com.papercut.service.impl;

import java.math.BigDecimal;
import java.util.function.Supplier;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.papercut.exception.InvalidPrintJobException;
import com.papercut.exception.PricingNotDefinedException;
import com.papercut.model.Money;
import com.papercut.model.PrintJob;
import com.papercut.model.PrintJobPricing;
import com.papercut.service.PrintJobCostCalculatorV1;

@Service
@Scope("singleton")
public class PrintJobCostCalculatorV1Impl implements PrintJobCostCalculatorV1 {

	@Override
	public Supplier<Money> calculateTotalPriceOfJob(PrintJob printJob) throws Exception {
		// Total Price = (Total Overall Pages * Base Price per page) + (Total Colour Pages * Colour Premium per page)
		
		PrintJobPricing printPricing = printJob.getPrintJobPricing();
		
		if (printPricing == null || printPricing.getBasePricePerPage() == null || printPricing.getColourPremiumPerPage() == null) {
			throw new PricingNotDefinedException("No pricing structure defined for print job: " + printJob.getIdentifier());
		}
		
		if (printJob == null || printJob.getTotalColourPages() > printJob.getTotalOverallPages()) {
			throw new InvalidPrintJobException("Print job is invalid: " + printJob.getIdentifier());
		}
		
		
		return () -> {
			Money totalPrice = Money.dollars((printPricing.getBasePricePerPage().getAmount()
					.multiply(new BigDecimal(printJob.getTotalOverallPages())))
							.add(printPricing.getColourPremiumPerPage().getAmount()
									.multiply(new BigDecimal(printJob.getTotalColourPages()))));
			return totalPrice;
		};
	}

}
