package backTracking;

import java.util.ArrayList;

public class DemoList<List> {

	public static void main(String[] args) {
	/*	ArrayList<Integer> list=new ArrayList<Integer>();
		System.out.println(list);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		System.out.println(list);
		
		ArrayList<Integer> list1=new ArrayList<Integer>();
		list1.add(20);
		list1.add(30);
		list1.add(40);
		System.out.println(list1);
		
		ArrayList<ArrayList<Integer>> big =new ArrayList<ArrayList<Integer>>();
		big.add(list);
		big.add(list1);
		System.out.println(big);
		
		System.out.println(big.get(0));
		System.out.println(big.get(0).get(2));
		*/
		/*ArrayList<ArrayList<Integer>> big =new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp=new ArrayList<Integer>();
		temp.add(10);
		temp.add(20);
		temp.add(30);
		
		big.add(temp);
		System.out.println(big);
		
		temp.add(40);
		temp.add(50);
		
		big.add(temp);
		System.out.println(big);
		
		temp.add(60);
		temp.add(70);
		
		big.add(temp);
		
		System.out.println(big);
		*/
		
		ArrayList<Integer> temp=new ArrayList<Integer>();
		temp.add(10);
		temp.add(20);
		temp.add(30);
		temp.add(40);
		
		//way1
		ArrayList<Integer> l1=new ArrayList<Integer>();
		for(Integer val: temp) {
			l1.add(val);
		}
		ArrayList<ArrayList<Integer>> big =new ArrayList<ArrayList<Integer>>();
		big.add(temp);
		big.add(l1);
		System.out.println(big);
		l1.add(50);
		System.out.println(big);
		
		//way2
		ArrayList<Integer> l2=new ArrayList<Integer>(temp);
		//MAKES A NEW ARRAYLIST AT A NEW ADDRESS
		//AND COPIES ALL THE DATA FROM TEMP TO NEW LIST
		
		big.add(new ArrayList<Integer>(temp));
		/*
		 * this creates a new arraylist at a separate address everytime
		 * and copies the elements of temp everytime 
		 * so any changes in temp would no longer be reflected in the arraylist  of arraylist
		 * 
		 */
		temp.add(100);
		System.out.println(big);
		
	}

}
