package backTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3 };
		List<List<Integer>> main = new ArrayList<>();
		List<Integer> temp = new ArrayList<Integer>();
		// elementRespect(arr, 0, temp, main);
		userRespect(arr, 0, temp, main);
		System.out.println(main);
	}

	public static void elementRespect(int[] arr, int vidx, List<Integer> temp, List<List<Integer>> main) {
		if (vidx == arr.length) {
			// System.out.println(ans);
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		// exclude
		elementRespect(arr, vidx + 1, temp, main);

		// include
		temp.add(arr[vidx]);
		elementRespect(arr, vidx + 1, temp, main);
		temp.remove(temp.size() - 1);

	}

	public static void userRespect(int[] arr, int vidx, List<Integer> temp, List<List<Integer>> main) {

		main.add(new ArrayList<Integer>(temp));

		for (int i = vidx; i < arr.length; i++) {
			temp.add(arr[i]);
			userRespect(arr, i + 1, temp, main);
			temp.remove(temp.size() - 1);
		}

	}
}
