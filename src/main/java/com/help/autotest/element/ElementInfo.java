package com.help.autotest.element;

import com.help.autotest.common.ElemVariety;

public class ElementInfo {

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getXpath() {
		return xpath;
	}

	public ElemVariety getControl() {
		return control;
	}

	public String id;
	public String name;
	public String xpath;
	public ElemVariety control;

	public ElementInfo(String id, String name, String xpath, ElemVariety control) {
		this.id = id;
		this.name = name;
		this.xpath = xpath;
		this.control = control;
	}


}
