package com.babailiren.ec.common;

import java.text.DecimalFormat;

public class NumberFormatUtils {

	public static String format(Integer number, String style) {
		DecimalFormat df = new DecimalFormat(style);
		return df.format(number);
	}
}