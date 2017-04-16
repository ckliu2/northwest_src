package com.base.web.displaytag;

import java.text.DecimalFormat;

import javax.servlet.jsp.PageContext;

import org.displaytag.properties.MediaTypeEnum;

public class ThousandsDecorator2 extends CommonColumnDecorator {
	public ThousandsDecorator2() {
		super();
	}

	public Object decorate(Object columnValue, PageContext context, MediaTypeEnum md) {
		DecimalFormat df = new DecimalFormat("###,###");

		if (columnValue == null) {
			return "";
		}

		try {
			float f = Float.parseFloat(String.valueOf(columnValue));
			int s = (int) f;
			return df.format(s);
		} catch (Exception e) {
			return "";
		}
	}
}
