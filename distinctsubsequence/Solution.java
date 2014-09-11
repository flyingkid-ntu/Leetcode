package distinctsubsequence;

public class Solution {
	public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int num = 0;
		
		if (S.equals(T)) {
			num = 1;
		} else if (S.length() < T.length()) {
			num = 0;
		} else if (T.length() == 0) {
			num = 1;
		} else{
			int idx = S.indexOf(T.charAt(0), 0);
			while (idx >= 0) {
				num += numDistinct(S.substring(idx+1), T.substring(1));
				idx = S.indexOf(T.charAt(0), idx+1);
			}
		}
		
        return num;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe";
		String T = "bddabdcae";
		Solution s = new Solution();
		int res = s.numDistinct(S, T);
		System.out.println(res);
	}

}
