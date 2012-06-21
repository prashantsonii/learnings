package com.promouit.novelstring;

import java.util.HashSet;
import java.util.Set;


public class StringAnalyser {
	public StringAnalysisStatus isNovelString(String stringToAnalyse) {
		int maxPossibleDistance = stringToAnalyse.length()-2;
		for(int currentDistance=0; currentDistance <= maxPossibleDistance; currentDistance++){
			Set<String> stringDistanceSet = new HashSet<String>();
			for(int i = 0; i<stringToAnalyse.length()-currentDistance-1; i++){
				boolean added = stringDistanceSet.
						add(stringToAnalyse.charAt(i)+""+stringToAnalyse.charAt(i+currentDistance+1));
				if(!added)
					return StringAnalysisStatus.NOT_NOVEL_STRING;
			}
		}
		return StringAnalysisStatus.NOVEL_STRING;
	}

	public ValidationStatus validateString(String stringToAnalyse) {
		if(stringToAnalyse.length() == 0)
			return ValidationStatus.INVALID_MINLENGHT;
		else if(stringToAnalyse.length() > 100)
			return ValidationStatus.INVALID_EXCEEDMAXLENGHT;
		return ValidationStatus.VALID;
	}
}
