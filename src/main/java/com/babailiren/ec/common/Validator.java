package com.babailiren.ec.common;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class Validator {
	private List<String> errorMessages = Lists.newArrayList();
	private static final String VALID_EMAIL_PATTERN = 
        "^(([A-Za-z0-9]+_+)|([A-Za-z0-9]+\\-+)|([A-Za-z0-9]+\\.+)|([A-Za-z0-9]+\\++))*[A-Za-z0-9]+@((\\w+\\-+)|(\\w+\\.))*\\w{1,63}\\.[a-zA-Z]{2,6}$";
	
	public Validator isNotBlankValidator(Object value,String msg) {
		if(value == null) {
			errorMessages.add(msg);
		} else if (value != null && StringUtils.isBlank(value.toString())) {
			errorMessages.add(msg);
		}
		return this;
	}
	
	
	
	public Validator expressionValidator(boolean expression,String msg) {
		if(expression) {
			errorMessages.add(msg);
		} 
		return this;
	}
	
	public boolean isValid() {
		return errorMessages.isEmpty();
	}
	
	public Validator emailValidator(Object value,String msg) {
		if(value == null) {
			return this;
		}
		String v = value.toString();
		if (!patternValidator(v,VALID_EMAIL_PATTERN)) {
			errorMessages.add(msg);
		}
		return this;
	}
	
	public String renderHtmlMessage() {
		return renderMessage("<br/>");
	}
	public String renderMessage() {
		return renderMessage("\n");
	}
	
	public String renderMessage(String sep) {
		if(!errorMessages.isEmpty()) {
			return Joiner.on(sep).join(errorMessages);
		}	
		return null;
	}
	
	private boolean patternValidator(String value,String pattern) {
		return Pattern.matches(pattern, value);
	}	

	public static void main(String[] args) {
		//int[] m=new int[]{1,2,3};
		//System.out.println(String.format("{0}%1$s%1$s{1}{2}","日","月"));
		Validator v = new Validator();
		v.isNotBlankValidator("", "我日你");
		v.isNotBlankValidator("", "我日死你");
		System.out.println(v.renderMessage());
		
	}
}
