package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {
		int[] denom = { 2, 2, 3 };// sorted array
		Arrays.sort(denom);
		List<List<Integer>> main = new ArrayList<>();
		List<Integer> temp = new ArrayList<Integer>();
		userRespect(denom, 0, 5, temp, main);
		System.out.println(main);
	}

	public static void userRespect(int[] denom, int vidx, int amount, List<Integer> temp, List<List<Integer>> main) {
		if (amount == 0) {
			// System.out.println(ans);
			main.add(new ArrayList<Integer>(temp));
			return;
		}
		if (amount < 0) {
			return;
		}
		for (int i = vidx; i < denom.length; i++) {
			if (i > vidx && denom[i] == denom[i - 1]) {
				continue;
			} else {
				temp.add(denom[i]);
				userRespect(denom, i+1, amount-denom[i], temp, main);
				temp.remove(temp.size() - 1);
			}
		}

	}
}
