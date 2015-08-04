package Model;

import java.util.ArrayList;

 
public class Calc {

	public static void main(String[] args) throws negativesNotAllowedException {
		// TODO Auto-generated method stub

	}

	public static int add(String str) throws negativesNotAllowedException {
		String replaceChar = ";";
		String delimeter = "";
		int num;
		int sum = 0;
		ArrayList<Integer> numbers;
		String[] delimeters = null;
		if (str == "") {
			return 0;
		}
		int charAsciiCode =str.charAt(0);
	if((charAsciiCode>47 &&charAsciiCode<59) || charAsciiCode==45)
		delimeter=";";
	else{
			String subStr = str.substring(2, str.lastIndexOf("]"));
		    str=str.substring(str.indexOf("\n")+1);
			delimeters = subStr.split("\\[|\\]");
			replaceChar = delimeters[0];
			for (int i = 0; i < delimeters.length; i++) {
				delimeter += delimeters[i];
				if(i != delimeters.length-1){
					delimeter=delimeter+"|";
				}
				if(i == delimeters.length-1){
					delimeter="["+delimeter+"]"+"+";
				}
			}

	}

		if (str.contains("\n"))
			str = str.replace("\n", replaceChar);

		numbers = new ArrayList<Integer>();

		String[] strNumbers = str.split(delimeter);

		for (int i = 0; i < strNumbers.length; i++) {
			num = Integer.parseInt((strNumbers[i]));
			if (num < 0) {
				throw new negativesNotAllowedException(
						"negatives not allowed: " + num);
			}
			if (num > 1000)
				continue;
			numbers.add(num);
		}

		for (int n : numbers) {
			sum += n;
		}

		return sum;

	}
}
