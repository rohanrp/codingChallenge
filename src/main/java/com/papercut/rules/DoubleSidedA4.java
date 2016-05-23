package com.papercut.rules;

import java.math.BigDecimal;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import com.papercut.model.Money;
import com.papercut.model.PaperSide;
import com.papercut.model.PaperSize;
import com.papercut.model.PrintJob;

@Rule
public class DoubleSidedA4 extends BasePrintRule {
	
	final static Money basePricePerPage = Money.dollars(new BigDecimal("0.10"));
	final static Money colourPremiumPerPage = Money.dollars(new BigDecimal("0.10"));
	
	public DoubleSidedA4(PrintJob printJob) {
		super(printJob, basePricePerPage, colourPremiumPerPage);	
	}

	@Condition
    public boolean whenTypeOfPrintJobIs() {
        return this.printJob.getSize() == PaperSize.A4 && this.printJob.getSide() == PaperSide.SINGLE;
    }

	@Action(order = 1)
	public Money calculateTotalPriceOfJob() throws Exception {
		// Total Price = (#Total Pages * Base Price pp) + (#Colour Pages * Colour Premium pp)
		Money totalPrice = Money.dollars(
				(this.getBasePricePerPage().getAmount().multiply(new BigDecimal(this.printJob.getTotalOverallPages())))
						.add(this.getColourPremiumPerPage().getAmount()
								.multiply(new BigDecimal(this.getPrintJob().getTotalColourPages()))));

		return totalPrice;
	}


    
    
}
