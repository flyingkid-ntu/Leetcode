package validnumber;

public class Solution {
	public boolean isNumber(String s) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		boolean num = true;
		s = s.trim();
		if (s.length() == 0) {
			return false;
		}
		int index = s.indexOf('e');
		if (index >= 0) {
			if (s.indexOf('e', index+1) >= 0) {
				return false;
			}
			String[] tmp = s.split("e");
			if (tmp.length != 2) {
				num = false;
			} else {
				String front = tmp[0];
				String end = tmp[1];
				if (!fracNum(front) || !pureNum(end)) {
					num = false;
				}
			}
		} else {
			if (!fracNum(s)) {
				num = false;
			}
		}
		return num;
	}

	public boolean fracNum(String s) {
		if (s.length() == 0) {
			return false;
		}
		if (s.length() == 1 && s.indexOf('.') == 0) {
			return false;
		}
		if (s.charAt(0) == '-' || s.charAt(0) == '+') {
			s = s.substring(1);
		}
		if (s.length() == 0) {
			return false;
		}
		if (s.length() == 1 && s.indexOf('.') == 0) {
			return false;
		}
		boolean frac = true;
		boolean dot = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '.' && !dot) {
				dot = true;
			} else if (c == '.' && dot) {
				frac = false;
				break;
			} else if (c < '0' || c > '9') {
				frac = false;
				break;
			}
		}
		return frac;
	}

	public boolean pureNum(String s) {
		boolean pure = true;
		if (s.charAt(0) == '-' || s.charAt(0) == '+') {
			s = s.substring(1);
		}
		if (s.length() == 0) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c < '0' || c > '9') {
				pure = false;
				break;
			}
		}
		return pure;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String str = "2e0";
		boolean b = s.isNumber(str);
		System.out.println(b);
	}

}
