package com.papercut.model;

public enum PaperSide {
	SINGLE(false),
	DOUBLE(true);
	
	private final boolean isDoubleSided;
	
	PaperSide(boolean doubleSided) {
		this.isDoubleSided = doubleSided;
	}
	
	public boolean isDoubleSided() {
		return isDoubleSided;
	}

	public static PaperSide getPaperSideByBoolean(boolean isDoubleSided) {
        for (PaperSide type : PaperSide.values()) {
            if (type.isDoubleSided() == isDoubleSided) {
                return type;
            }
        }
        return null;
    }
}
