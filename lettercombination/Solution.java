package lettercombination;

import java.util.ArrayList;

public class Solution {
	public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
		final String[] alphaBeta = {"", "", "abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            res.add("");
            return res; 
        }
        if (digits.length() == 1) {
            int idx = digits.charAt(0) - '0';
            for (int i = 0; i < alphaBeta[idx].length(); i++) {
                res.add(alphaBeta[idx].substring(i, i+1));
            }
            return res;
        }
        int idx = digits.charAt(0) - '0';
        ArrayList<String> temp = letterCombinations(digits.substring(1));
        for (int i = 0; i < alphaBeta[idx].length(); i++) {
        	String t = alphaBeta[idx].substring(i, i+1);
        	for (String s : temp) {
        		res.add(t+s);
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String digits = "23";
		ArrayList<String> res = s.letterCombinations(digits);
		for (String ss : res) {
			System.out.println(ss);
		}
	}

}
