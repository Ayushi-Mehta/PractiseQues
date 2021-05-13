package backTracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		List<List<Integer>> main = new ArrayList<>();
		List<Integer> temp = new ArrayList<Integer>();
		// CombineUserRespect(1, n, k, temp, main);// dont take permutation since it has
		// repetition
		CombineElementRespect(1, n, k, temp, main);
		System.out.println(main);

	}

	// sp=starting point
	public static void CombineUserRespect(int sp, int n, int k, List<Integer> temp, List<List<Integer>> main) {
		if (k == 0) {
			// System.out.println(ans);
			main.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = sp; i <= n; i++) {
			temp.add(i);
			CombineUserRespect(i + 1, n, k - 1, temp, main);
			temp.remove(temp.size() - 1);
		}
	}

	public static void CombineElementRespect(int sp, int n, int k, List<Integer> temp, List<List<Integer>> main) {
		if (k == 0) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}
		if (sp > n) {
			return;
		}

		// exclude
		CombineElementRespect(sp + 1, n, k, temp, main);

		// include
		temp.add(sp);
		CombineElementRespect(sp + 1, n, k - 1, temp, main);
		temp.remove(temp.size() - 1);
	}
}
