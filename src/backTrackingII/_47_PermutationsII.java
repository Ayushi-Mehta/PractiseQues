package backTrackingII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_PermutationsII {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2 };
		Arrays.sort(arr);
		boolean[] available = new boolean[arr.length];
		Arrays.fill(available, true);// VERY IMP
		List<List<Integer>> main = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		permutations2(arr, available, "", main, temp);
		System.out.println(main);
	}

	public static void permutations2(int[] arr, boolean[] available, String ans, List<List<Integer>> main,
			List<Integer> temp) {
		if (temp.size() == arr.length) {
			// System.out.println(ans);
			main.add(new ArrayList<Integer>(temp));// VERY IMP
			return;
		}

		for (int i = 0; i < available.length; i++) {
			if (available[i] == false) {
				continue;
			} else {
				if (i > 0 && arr[i] == arr[i - 1] && available[i] && available[i-1]) {
					continue;//available[i] && available[i-1] has to be true also for both these to be considered
				} else {
					available[i] = false;

					temp.add(arr[i]);
					permutations2(arr, available, ans + arr[i], main, temp);
					temp.remove(temp.size() - 1);

					available[i] = true;// undo
				}
			}
		}
	}

}
