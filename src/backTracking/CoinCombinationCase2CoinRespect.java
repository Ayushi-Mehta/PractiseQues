package backTracking;

public class CoinCombinationCase2CoinRespect {

	public static void main(String[] args) {
		int[] denom = { 1, 2, 3, 4, 5 };
		coinRespect(denom, 0, 7, "");
	}//coin can only be used once

	public static void coinRespect(int[] denom, int vidx, int amount, String ans) {
		if (amount == 0) {// +ve base case
			System.out.println(ans);
			return;
		}
		if (amount < 0 || vidx == denom.length) {// -ve base case
			return;
		}
		// include
		coinRespect(denom, vidx + 1, amount - denom[vidx], ans + denom[vidx]);
		// exclude
		coinRespect(denom, vidx + 1, amount, ans);
	}
}
