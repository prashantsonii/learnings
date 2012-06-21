package com.xebia.numberConverter.utils;

import com.xebia.numberConverter.model.Number;

public class ConversionUtils {
	
	private static long[] dividers = {
		1l, 10l, 100l, 1000l, 10000l, 100000l, 1000000l, 10000000l, 100000000l, 1000000000l, 10000000000l
	};
	
	public static String digitsAt(Number number, int index){
		return new Long((Long.valueOf(number.value())%dividers[index+1] - 
				Long.valueOf(number.value())%dividers[index])/dividers[index]).toString();
	}
	
	public static String digitsBetween(Number number, int index, int numDigits){
		return new Long((Long.valueOf(number.value())%dividers[index+numDigits - 1] - 
				Long.valueOf(number.value())%dividers[index-1])/dividers[index-1]).toString();
	}
}