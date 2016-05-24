package com.papercut.rules;

import java.math.BigDecimal;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.springframework.stereotype.Component;

import com.papercut.model.Money;
import com.papercut.model.PaperSide;
import com.papercut.model.PaperSize;
import com.papercut.model.PrintJob;
import com.papercut.model.PrintPricing;

@Rule
@Component
public class DoubleSidedA4 extends BasePrintRule {
	
	final static Money BASE_PRICE_PER_PAGE = Money.dollars(new BigDecimal("0.10"));
	final static Money COLOUR_PREMIUM_PRICE_PER_PAGE = Money.dollars(new BigDecimal("0.10"));
	final static PaperSize PAPER_SIZE = PaperSize.A4;
	final static PaperSide PAPER_SIDE = PaperSide.DOUBLE;
	
	public DoubleSidedA4() {
		super();	
	}
	
	public DoubleSidedA4(PrintJob printJob) {
		super(printJob);	
	}

	@Condition
    public boolean whenTypeOfPrintJobIs() {
		return this.printJob.getSize() == PAPER_SIZE && this.printJob.getSide() == PAPER_SIDE;
    }

	@Action(order = 1)
	public void thenSetJobPricing() throws Exception {
		
		PrintPricing printPricing = new PrintPricing();
		printPricing.setBasePricePerPage(BASE_PRICE_PER_PAGE);
		printPricing.setColourPremiumPerPage(COLOUR_PREMIUM_PRICE_PER_PAGE);
		
		this.printJob.setPrintPricing(printPricing);
	}


    
    
}
