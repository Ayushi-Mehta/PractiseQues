package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIICoinRespect {

	public static void main(String[] args) {
		int[] denom = {10,1,2,7,6,1,5};// sorted array
		Arrays.sort(denom);
		List<List<Integer>> main = new ArrayList<>();
		List<Integer> temp = new ArrayList<Integer>();
		coinRespect(denom, 0, 5,true, temp, main);
		System.out.println(main);
	}
	public static void coinRespect(int[] denom, int vidx, int amount,boolean call, List<Integer> temp, List<List<Integer>> main) {
		if (amount == 0) {
			//System.out.println(ans);
			main.add(new ArrayList<Integer>(temp));
			return;
		}
		if (amount < 0 || vidx == denom.length) {
			return;
		}
		if (call == false && denom[vidx] == denom[vidx - 1]) {
			coinRespect(denom, vidx + 1, amount,false,temp,main);// exclude
		} else {
			temp.add(denom[vidx]);
			coinRespect(denom, vidx + 1, amount - denom[vidx],true,temp,main);
			temp.remove(temp.size()-1);
			coinRespect(denom, vidx + 1, amount,false,temp, main);// exclude
			
		}

	}
}
