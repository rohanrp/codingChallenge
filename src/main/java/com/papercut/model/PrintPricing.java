package com.papercut.model;

import java.math.BigDecimal;

public class PrintPricing {
	
	Money basePricePerPage = Money.dollars(new BigDecimal("0.0"));
	Money colourPremiumPerPage = Money.dollars(new BigDecimal("0.0"));
	
	
	public PrintPricing() {
		super();
	}
	
	public PrintPricing(Money basePricePerPage, Money colourPremiumPerPage) {
		super();
		this.basePricePerPage = basePricePerPage;
		this.colourPremiumPerPage = colourPremiumPerPage;
	}

	
	public void setBasePricePerPage(Money basePricePerPage) {
		this.basePricePerPage = basePricePerPage;
	}


	public void setColourPremiumPerPage(Money colourPremiumPerPage) {
		this.colourPremiumPerPage = colourPremiumPerPage;
	}


	public Money getBasePricePerPage() {
		return basePricePerPage;
	}


	public Money getColourPremiumPerPage() {
		return colourPremiumPerPage;
	}
	
	
}
