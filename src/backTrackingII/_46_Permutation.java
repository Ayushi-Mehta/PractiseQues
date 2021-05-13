package backTrackingII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _46_Permutation {

	public static void main(String[] args) {
		int[] arr= {1,2,3};
		boolean[] available=new boolean[arr.length];
		Arrays.fill(available, true);//VERY IMP
		List<List<Integer>> main=new ArrayList<List<Integer>>();
		List<Integer> temp=new ArrayList<Integer>();
		permutations(arr, available,"", main, temp);
		System.out.println(main);

	}
	public static void permutations(int[] arr, boolean[] available,String ans,List<List<Integer>> main,List<Integer> temp) {
		if(temp.size()==arr.length) {
			//System.out.println(ans);
			main.add(new ArrayList<Integer>(temp));//VERY IMP
			return;
		}
		
		
		for(int i=0;i<available.length;i++) {
			if(available[i]==false) {
				continue;
			}else {
				available[i]=false;
				temp.add(arr[i]);
				permutations(arr, available, ans+arr[i],main,temp);
				temp.remove(temp.size()-1);
				available[i]=true;//undo
			}
		}
	}
}
