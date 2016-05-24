package com.papercut.rules;
/**
* A pricing rule to be applied when the paper matches the below condition
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/
import java.math.BigDecimal;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.springframework.stereotype.Component;

import com.papercut.model.Money;
import com.papercut.model.PaperSide;
import com.papercut.model.PaperSize;
import com.papercut.model.PrintJob;
import com.papercut.model.PrintJobPricing;

@Rule
@Component
public class DoubleSidedA4PriceRule extends BasePriceRule {
	
	final static Money BASE_PRICE_PER_PAGE = Money.dollars(new BigDecimal("0.10"));
	final static Money COLOUR_PREMIUM_PRICE_PER_PAGE = Money.dollars(new BigDecimal("0.10"));
	final static PaperSize PAPER_SIZE = PaperSize.A4;
	final static PaperSide PAPER_SIDE = PaperSide.DOUBLE;
	
	public DoubleSidedA4PriceRule() {
		super();	
	}
	
	public DoubleSidedA4PriceRule(PrintJob printJob) {
		super(printJob);	
	}

	@Condition
    public boolean whenTypeOfPrintJobIs() {
		return this.printJob.getSize() == PAPER_SIZE && this.printJob.getSide() == PAPER_SIDE;
    }

	@Action(order = 1)
	public void thenSetJobPricing() throws Exception {
		
		PrintJobPricing printPricing = new PrintJobPricing();
		printPricing.setBasePricePerPage(BASE_PRICE_PER_PAGE);
		printPricing.setColourPremiumPerPage(COLOUR_PREMIUM_PRICE_PER_PAGE);
		
		this.printJob.setPrintJobPricing(printPricing);
	}


    
    
}
