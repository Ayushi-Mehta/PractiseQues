package backTrackingII;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _93_RestoreIPAddresses {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		List<String> main =new ArrayList<String>();
		String s=scn.next();
		if(s.length()<=12)//3 digits per part * 4 parts=12 digits in IP
		ipAddresses(s, "", 0,main);
		System.out.println(main);
	}

	public static void ipAddresses(String ques, String ans, int dots,List<String> main) {
		if (ques.length() == 0) {
			if (dots == 4)// valid IP has only 4 parts
				//System.out.println(ans.substring(0, ans.length() - 1));// removing the last "."
				main.add(ans.substring(0, ans.length() - 1));
				return;
		}
		if(ques.length()>(4-dots)*3) {//reduces the no of calls further decreasing the time complexity
			return;
		}
		for (int i = 1; i <= 3 && i <= ques.length(); i++) {
			// more than 3 calls cant be made as 256 is a 3 digit number
			String roq = ques.substring(i);
			String part = ques.substring(0, i);

			if (noLeadingZeroes(part) && isValidPart(part))
				ipAddresses(roq, ans + part + ".", dots + 1,main);
		}
	}

	public static boolean isValidPart(String str) {
		int num = Integer.parseInt(str);
		return num <= 255;
	}

	// true:no leading zeroes
	// false: leading zeroes
	public static boolean noLeadingZeroes(String str) {
		if (str.length() <= 1)
			return true;
		return str.charAt(0) != '0';
	}
}
