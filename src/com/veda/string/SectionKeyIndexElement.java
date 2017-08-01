package com.veda.string;

public class SectionKeyIndexElement implements KeyIndexElement<Integer> {
	private String mName;
	private Integer mSection;
	
	public SectionKeyIndexElement(String name, Integer section) {
		mName = name;
		mSection = section;
	}
	
	public Integer getKey() {
		return mSection;
	}
	
	public String getName() {
		return mName;
	}
	
	public String toString() {
		return mName + "     " + mSection;
	}
}
