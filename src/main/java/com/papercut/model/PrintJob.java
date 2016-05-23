package com.papercut.model;

public class PrintJob {
	
	private int totalOverallPages;
	
	private int totalColourPages;
	
	private PaperSize size = PaperSize.A4;
	
	private PaperSide side;

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
	
}
