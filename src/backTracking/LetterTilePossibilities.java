package backTracking;

public class LetterTilePossibilities {

	public static void main(String[] args) {
		/*
		 * subsequences + permutation
		 */
		int k=numTilePossibilities("AAB");
		System.out.println(k);
		
	}
	static int count;
	public static int numTilePossibilities(String tiles) {
		count=0;
		int[] freq=new int[26];
		
		for(int i=0;i<tiles.length();i++) {
		char ch=tiles.charAt(i);
		freq[ch-'A']++;
		}
		numTilePossibilities(freq, "");
		return count-1;//empty sequence also in count
	}
	public static void numTilePossibilities(int[] freq, String ans) {
		
		//System.out.println(ans);
		count++;
		for(int i=0;i<freq.length;i++) {
			if(freq[i]>0) {
				freq[i]--;
				numTilePossibilities(freq,ans+(char)('A'+i));
				freq[i]++;
			}
		}
	}

}
