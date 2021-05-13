package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2 };
		Arrays.sort(arr);//VERY IMPORTANT!!!!!
		// elementRespect(arr, 0, "", true);
		List<List<Integer>> main = new ArrayList<>();
		List<Integer> temp = new ArrayList<Integer>();
		// elementRespectList(arr, 0, temp, main, true);
		userRespectList(arr, 0, temp, main);
		System.out.println(main);
	}

	public static void elementRespect(int[] arr, int vidx, String ans, boolean call) {
		if (vidx == arr.length) {
			System.out.println(ans);
			return;
		}
		if (call == false && arr[vidx - 1] == arr[vidx]) {
			// exclude
			elementRespect(arr, vidx + 1, ans, false);
		} else {
			// exclude
			elementRespect(arr, vidx + 1, ans, false);

			// include
			elementRespect(arr, vidx + 1, ans + arr[vidx], true);
		}
	}

	
	public static void elementRespectList(int[] arr, int vidx, List<Integer> temp, List<List<Integer>> main,
			boolean call) {
		if (vidx == arr.length) {
			// System.out.println(ans);
			main.add(new ArrayList<Integer>(temp));
			return;
		}
		if (call == false && arr[vidx - 1] == arr[vidx]) {
			// exclude
			elementRespectList(arr, vidx + 1, temp, main, false);
		} else {
			// exclude
			elementRespectList(arr, vidx + 1, temp, main, false);

			// include
			temp.add(arr[vidx]);
			elementRespectList(arr, vidx + 1, temp, main, true);
			temp.remove(temp.size() - 1);
		}
	}

	public static void userRespectList(int[] arr, int vidx, List<Integer> temp, List<List<Integer>> main) {

		main.add(new ArrayList<Integer>(temp));

		for (int i = vidx; i < arr.length; i++) {
			if (i > vidx && arr[i] == arr[i - 1]) {
				continue;
			} else {
				temp.add(arr[i]);
				userRespectList(arr, i + 1, temp, main);
				temp.remove(temp.size() - 1);
			}
		}

	}
	public static void userRespect(int[] arr, int vidx,String ans) {

		System.out.println(ans);

		for (int i = vidx; i < arr.length; i++) {
			if (i > vidx && arr[i] == arr[i - 1]) {
				continue;
			} else {
				userRespect(arr, i + 1, ans+arr[i]);
			}
		}

	}
}
