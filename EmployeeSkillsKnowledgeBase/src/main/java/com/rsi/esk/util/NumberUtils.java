package com.rsi.esk.util;

public class NumberUtils {
	
	public Boolean hasInteger(Integer value) {
		if(value == null)
			return false;		  
		return value > 0;
	}
}
