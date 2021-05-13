package backTracking;

public class CoinCombinationCase2UserRespect {
//multiple use of 1 coin not allowed
	public static void main(String[] args) {
		int[] denom= {1,2,3,4,5};
		userRespect(denom,0,7,"");
	}

	// vidx=virtual index
	public static void userRespect(int[] denom, int vidx, int amount, String ans) {
		if (amount == 0) {
			System.out.println(ans);
			return;
		}
		if (amount < 0) {
			return;
		}
		for (int i = vidx; i < denom.length; i++) {
			userRespect(denom, i + 1, amount - denom[i], ans + denom[i]);

		}
	}
}
