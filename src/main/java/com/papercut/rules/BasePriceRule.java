package com.papercut.rules;

import com.papercut.model.PrintJob;

public abstract class BasePriceRule {
	
	protected PrintJob printJob;
    
    public abstract boolean whenTypeOfPrintJobIs();
    
    public abstract void thenSetJobPricing() throws Exception;
    
    public BasePriceRule() {
		super();
	}
    
	public BasePriceRule(PrintJob printJob) {
		super();
		this.printJob = printJob;
	}

	public PrintJob getPrintJob() {
		return printJob;
	}

	public void setPrintJob(PrintJob printJob) {
		this.printJob = printJob;
	}

	public BasePriceRule getInstance() {
		return this;
	}

}
