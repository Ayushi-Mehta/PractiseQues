package backTracking;

import java.util.ArrayList;
import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

	public static void main(String[] args) {
		
		List<String> list=new ArrayList<String>();
		
		list.add("un");
		list.add("iq");
		list.add("ue");
		//max.Length(list);
		System.out.println(maxLength(list));

	}

	static int max;

	public static int maxLength(List<String> arr) {
		max = 0;
		userRespect(arr, 0, "");
		return max;
	}

	public static void userRespect(List<String> arr, int vidx, String ans) {
		// System.out.println(ans);
		if (disitnctChars(ans)) {
			if (ans.length() > max) {
				max = ans.length();
			}
			// System.out.println(ans);
		} else {
			return;
		}
		for (int i = vidx; i < arr.size(); i++) {
			userRespect(arr, i + 1, ans + arr.get(i));
		}

	}

	public static boolean disitnctChars(String str) {
		int[] freq = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (freq[ch - 'a'] > 0) {
				return false;
			} else {
				freq[ch - 'a']++;
			}
		}
		return true;
	}

}
