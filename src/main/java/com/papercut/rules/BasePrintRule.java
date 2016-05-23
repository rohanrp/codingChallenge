package com.papercut.rules;

import java.math.BigDecimal;

import com.papercut.model.Money;
import com.papercut.model.PrintJob;

public abstract class BasePrintRule {
	
	protected PrintJob printJob;
	
	private Money basePricePerPage =  Money.dollars(new BigDecimal("0")); 
	
	private Money colourPremiumPerPage =  Money.dollars(new BigDecimal("0")); 
	
    public BasePrintRule(PrintJob printJob, Money basePricePerPage, Money colourPremiumPerPage) {
		super();
		this.printJob = printJob;
		this.basePricePerPage = basePricePerPage;
		this.colourPremiumPerPage = colourPremiumPerPage;
	}
    
    public abstract boolean whenTypeOfPrintJobIs();
    
    public abstract Money calculateTotalPriceOfJob() throws Exception;
    
	public PrintJob getPrintJob() {
		return printJob;
	}

	public void setPrintJob(PrintJob printJob) {
		this.printJob = printJob;
	}

	public Money getBasePricePerPage() {
		return basePricePerPage;
	}

	public void setBasePricePerPage(Money basePricePerPage) {
		this.basePricePerPage = basePricePerPage;
	}

	public Money getColourPremiumPerPage() {
		return colourPremiumPerPage;
	}

	public void setColourPremiumPerPage(Money colourPremiumPerPage) {
		this.colourPremiumPerPage = colourPremiumPerPage;
	}

}
