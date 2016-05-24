package com.papercut.rules;

/**
* A base class that sets the standard for the when-then pricing rules model through an abstract interface.
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/
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
