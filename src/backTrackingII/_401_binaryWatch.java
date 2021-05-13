package backTrackingII;

import java.util.ArrayList;
import java.util.List;

public class _401_binaryWatch {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32 };
		List<String> main = new ArrayList<String>();
		watch(arr, 0, 3, 0, 0, main);
		System.out.println(main);
	}

	public static void watch(int[] arr, int vidx, int n, int hr, int min, List<String> main) {
		if (hr >= 12 || min >= 60) {
			return;
		}
		if (n == 0) {// +ve base case
			String fmin = min + "";// string
			if (fmin.length() == 1) {
				fmin = "0" + fmin;
			}
			// System.out.println(hr + ":" + fmin);
			main.add(hr + ":" + fmin);
			return;
		}
		if (vidx == arr.length) {
			return;
		}

		// include->LED ON
		if (vidx < 4) {// hr
			watch(arr, vidx + 1, n - 1, hr + arr[vidx], min, main);
		} else {// min
			watch(arr, vidx + 1, n - 1, hr, min + arr[vidx], main);
		}

		// exclude->LED OFF
		watch(arr, vidx + 1, n, hr, min, main);

	}
}
