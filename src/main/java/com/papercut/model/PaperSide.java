package com.papercut.model;

/**
* Whether a paper is printed on both sides or not
*
* @author  Rohan Pereira
* @version 1.0
* @since   2016-05-24
*/

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
