package net.hlw5a.TinMan.UI;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TMComparatorProceedings implements Comparator<String> {

	private Pattern firstString = Pattern.compile("\\D+");
	private Pattern firstNumber = Pattern.compile("\\d+");
	
	@Override
	public int compare(String arg0, String arg1) {
		if (arg0.equals(arg1)) return 0;
		Matcher matcherString0 = firstString.matcher(arg0);
		Matcher matcherString1 = firstString.matcher(arg1);
		int matchResults;
		if (matcherString0.find() && matcherString1.find()) {
			if ((matchResults = matcherString0.group().compareTo(matcherString1.group())) != 0) return matchResults;
		}
		Matcher matcherNumber0 = firstNumber.matcher(arg0);
		Matcher matcherNumber1 = firstNumber.matcher(arg1);
		if (matcherNumber0.find() && matcherNumber1.find()) {
			if ((matchResults = Integer.parseInt(matcherNumber0.group()) - Integer.parseInt(matcherNumber1.group())) != 0) return matchResults;
		}
		if (matcherString0.find() && matcherString1.find()) {
			if ((matchResults = matcherString0.group().compareTo(matcherString1.group())) != 0) return matchResults;
		}
		return 0;
	}
}
