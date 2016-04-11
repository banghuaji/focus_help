package com.help.autotest.common;

public enum ElemType {
	/** Class, interface (including annotation type), or enum declaration */
	id(1),

	/** Field declaration (includes enum constants) */
	name(2),

	/** Method declaration */
	xpath(3);
	int value;

	ElemType(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}
