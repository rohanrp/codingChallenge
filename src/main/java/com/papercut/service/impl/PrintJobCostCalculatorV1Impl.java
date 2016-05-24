package com.papercut.service.impl;
/**
* The calculator class that supplies the algorith against which a price can be determined
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/
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

	/** 
	  * Supplies back a pricing algorithm.
	  * 
	  * This method is meant to be executed against actual pricing data only when it is required
	  * later upstream in the application.
	  * @param A valid print job.
	  * @return A no-args function stored as a portable object that will return the price of the print job
	  * when ultimately executed.
	  */
	@Override
	public Supplier<Money> calculateTotalPriceOfJob(PrintJob printJob) throws Exception {
		
		// Validation of print job
		if (printJob == null || printJob.getTotalColourPages() > printJob.getTotalOverallPages()) {
			throw new InvalidPrintJobException("Print job is invalid: " + printJob.getIdentifier());
		}
		
		PrintJobPricing printPricing = printJob.getPrintJobPricing();
		
		// Validation of pricing
		if (printPricing == null || printPricing.getBasePricePerPage() == null || printPricing.getColourPremiumPerPage() == null) {
			throw new PricingNotDefinedException("No pricing structure defined for print job: " + printJob.getIdentifier());
		}
		
		// Total Price = (Total Overall Pages * Base Price per page) + (Total Colour Pages * Colour Premium per page)
		return () -> {
			Money totalPrice = Money.dollars((printPricing.getBasePricePerPage().getAmount()
					.multiply(new BigDecimal(printJob.getTotalOverallPages())))
							.add(printPricing.getColourPremiumPerPage().getAmount()
									.multiply(new BigDecimal(printJob.getTotalColourPages()))));
			return totalPrice;
		};
	}

}
