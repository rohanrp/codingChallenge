package com.papercut.rules;

import com.papercut.model.PrintJob;

public abstract class BasePrintRule {
	
	protected PrintJob printJob;
    
    public abstract boolean whenTypeOfPrintJobIs();
    
    public abstract void thenSetJobPricing() throws Exception;
    
    public BasePrintRule() {
		super();
	}
    
	public BasePrintRule(PrintJob printJob) {
		super();
		this.printJob = printJob;
	}

	public PrintJob getPrintJob() {
		return printJob;
	}

	public void setPrintJob(PrintJob printJob) {
		this.printJob = printJob;
	}

	public BasePrintRule getInstance() {
		return this;
	}

}
