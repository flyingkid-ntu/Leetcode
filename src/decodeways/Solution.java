package decodeways;

public class Solution {
	public int numDecodings(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() == 0) {
			return 0;
		} else if (s.length() == 1) {
			return 1;
		} else if (s.length() == 2) {
			if (s.compareTo("26") <= 0) {
				return 2;
			} else {
				return 1;
			}
		} else {
			if (s.substring(0, 2).compareTo("26") <= 0)
				return numDecodings(s.substring(1))
						+ numDecodings(s.substring(2));
			else
				return numDecodings(s.substring(1));
		}
	}

	public int numDecodings2(String s) {
		if (s == null || s.equals(""))
			return 0;
		char[] cc = s.toCharArray(); // conver to char array
		int n = s.length(); // number of chars
		int numEn[] = new int[n + 1];
		numEn[0] = 1;
		if (cc[0] >= '1' && cc[0] <= '9')
			numEn[1] = 1;
		else
			return 0;
		for (int i = 1; i < n; i++) {
			if (cc[i] >= '1' && cc[i] <= '9') {
				if (s.substring(i - 1, i + 1).compareTo("10") >= 0
						&& s.substring(i - 1, i + 1).compareTo("26") <= 0) {
					numEn[i + 1] = numEn[i] + numEn[i - 1];
				} else {
					numEn[i + 1] = numEn[i];
				}
			} else {
				if (s.substring(i - 1, i + 1).compareTo("10") >= 0
						&& s.substring(i - 1, i + 1).compareTo("26") <= 0) {
					numEn[i + 1] = numEn[i - 1];
				} else {
					return 0;
				}
			}
		}

		return numEn[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String code = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
		long ss = System.currentTimeMillis();
		System.out.println(s.numDecodings2(code));
		long ee = System.currentTimeMillis();
		System.out.println(ee-ss);
	}

}
