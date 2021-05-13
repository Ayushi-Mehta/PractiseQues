package backTrackingII;

import java.util.ArrayList;

public class _60_PermutationSequence {

	public static void main(String[] args) {
		int n = 4;
		int k = 17;// 4!=24
		int[] factorial = new int[n];
		factorial[0] = 1;
		for (int i = 1; i < factorial.length; i++) {
			factorial[i] = i * factorial[i - 1];
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(i);
		}
		String s=perm(n, k, factorial, list, "");
		System.out.println(s);
	}

	public static String perm(int n, int k, int[] factorial, ArrayList<Integer> list, String ans) {
		if (n == 0) {
			//System.out.println(ans);
			return ans;
		}

		int group = k / factorial[n - 1];// completely filled groups of size factorial[n-1]
		// 1 group has n-1! elements
		if (k % factorial[n - 1] != 0) {
			group++;// for border cases of groups
		}
		// int newk = k % factorial[n - 1];->wrong ans
		int newk = k - (group - 1) * factorial[n - 1];
		int num = list.remove(group);

		return perm(n - 1, newk, factorial, list, ans + num);

	}

	// public static int fact(int n) {
	// can be made too
	// }
}
