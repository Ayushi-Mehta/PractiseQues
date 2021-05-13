package backTracking;

import java.util.Arrays;

public class CoinCombinationCase3UserRespect {// repeating values in denom but no repeating values in output

	public static void main(String[] args) {
		int[] denom = {2, 2, 3};// sorted array
		//Arrays.sort(denom);
		coinRespect(denom, 0, 5, "", true);
	}

//call true include, false exclude
	public static void coinRespect(int[] denom, int vidx, int amount, String ans, boolean call) {
		if (amount == 0) {
			System.out.println(ans);
			return;
		}
		if (amount < 0 || vidx == denom.length) {
			return;
		}
		if (call == false && denom[vidx] == denom[vidx - 1]) {
			coinRespect(denom, vidx + 1, amount, ans, false);// exclude
		} else {
			coinRespect(denom, vidx + 1, amount - denom[vidx], ans + denom[vidx], true);
			coinRespect(denom, vidx + 1, amount, ans, false);// exclude
		}

	}
}
