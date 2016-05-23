package com.papercut.model;

public enum PaperSide {
	SINGLE(false),
	DOUBLE(true);
	
	private final boolean doubleSided;
	
	PaperSide(boolean doubleSided) {
		this.doubleSided = doubleSided;
	}
}
