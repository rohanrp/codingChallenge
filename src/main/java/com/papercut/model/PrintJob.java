package com.papercut.model;

/**
* The smallest unit of product that must be priced against to a customer
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/

public class PrintJob {
	
	private int identifier;
	
	private int totalOverallPages;
	
	private int totalColourPages;
	
	// default size
	private PaperSize size = PaperSize.A4;
	
	private PaperSide side;
	
	private PrintJobPricing printJobPricing;
	
	public PrintJob() {
		super();
	}
	
	public PrintJob(int totalOverallPages, int totalColourPages, PaperSide side) {
		super();
		this.totalOverallPages = totalOverallPages;
		this.totalColourPages = totalColourPages;
		this.side = side;
	}
	
	public PrintJob(int totalOverallPages, int totalColourPages, PaperSize size, PaperSide side) {
		super();
		this.totalOverallPages = totalOverallPages;
		this.totalColourPages = totalColourPages;
		this.size = size;
		this.side = side;
	}
	
	public PrintJob(int identifier, int totalOverallPages, int totalColourPages, PaperSide side) {
		super();
		this.totalOverallPages = totalOverallPages;
		this.totalColourPages = totalColourPages;
		this.side = side;
		this.identifier = identifier;
	}
	
	public PrintJob(int identifier, int totalOverallPages, int totalColourPages, PaperSize size, PaperSide side) {
		super();
		this.totalOverallPages = totalOverallPages;
		this.totalColourPages = totalColourPages;
		this.size = size;
		this.side = side;
		this.identifier = identifier;
	}
	
	public PrintJob(int identifier, int totalOverallPages, int totalColourPages, PaperSize size, PaperSide side, PrintJobPricing printPricing) {
		super();
		this.totalOverallPages = totalOverallPages;
		this.totalColourPages = totalColourPages;
		this.size = size;
		this.side = side;
		this.printJobPricing = printPricing;
		this.identifier = identifier;
	}

	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public int getTotalOverallPages() {
		return totalOverallPages;
	}

	public void setTotalOverallPages(int totalOverallPages) {
		this.totalOverallPages = totalOverallPages;
	}

	public int getTotalColourPages() {
		return totalColourPages;
	}

	public void setTotalColourPages(int totalColourPages) {
		this.totalColourPages = totalColourPages;
	}

	public PaperSize getSize() {
		return size;
	}

	public void setSize(PaperSize size) {
		this.size = size;
	}

	public PaperSide getSide() {
		return side;
	}

	public void setSide(PaperSide side) {
		this.side = side;
	}

	public PrintJobPricing getPrintJobPricing() {
		return printJobPricing;
	}

	public void setPrintJobPricing(PrintJobPricing printPricing) {
		this.printJobPricing = printPricing;
	}
	
	@Override
    public String toString() {
        return "PrintJob {" +
                "Id='" + identifier + "', " +
				 "Total Pages='" + totalOverallPages + "', " +
				 "Total Colour Pages='" + totalColourPages + "', " +
				 "Paper Size='" + size + "', " +
				  "Paper siding='" + side + "'" +
                '}';
    }
	
	@Override
    public int hashCode() {
        return (int) (identifier ^ (identifier >>> 32));
    }
	
}
