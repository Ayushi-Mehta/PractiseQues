package backTracking;

import java.util.ArrayList;

public class CombinationSumListOfList {

	public static void main(String[] args) {
		int[] denom= {1,2,3,4};
		ArrayList<ArrayList<Integer>> main=new ArrayList<>();
		ArrayList<Integer> temp=new ArrayList<Integer>();
		userRespect(denom,0,6,temp,main);
		System.out.println(main);
	}

	public static void userRespect(int[] denom, int vidx, int amount, ArrayList<Integer> temp,
			ArrayList<ArrayList<Integer>> main) {
		if (amount == 0) {
			// System.out.println(ans);
			main.add(new ArrayList<Integer>(temp));
			return;
		}
		if (amount < 0) {
			return;
		}
		for (int i = vidx; i < denom.length; i++) {
			temp.add(denom[i]);
			userRespect(denom, i + 1, amount - denom[i], temp, main);
			temp.remove(temp.size() - 1);//explicitly undo
		}
	}
}
