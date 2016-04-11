package com.help.autotest.element;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElement {
	public static By findBy(ElementInfo myele) {
		By b = null;
		if (myele.id != null && !"".equals(myele.id)) {
			b = By.id(myele.id);
			return b;
		} else if (myele.name != null && !"".equals(myele.name)) {
			b = By.name(myele.name);
			return b;
		} else if (myele.xpath != null && !"".equals(myele.xpath)) {
			b = By.xpath(myele.xpath);
			return b;
		}
		return b;
	}

	public static WebElement findElement(WebDriver driver, ElementInfo myele) {
		return driver.findElement(findBy(myele));
	}

	public static List<WebElement> findElements(WebDriver driver, ElementInfo myele) {
		return driver.findElements(findBy(myele));
	}
}
