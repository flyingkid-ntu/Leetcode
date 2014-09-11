package textjustification;

import java.util.ArrayList;

public class Solution {
	public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int start = 0;
        ArrayList<String> res = new ArrayList<String>();
        while (start < words.length) {
            int end = start;
            int length = 0;
            int numOfSpace = 0;
            while (end < words.length) {
                length += words[end].length();
                numOfSpace = end - start;
                if (length + numOfSpace <= L) {
                    end++;
                } else {
                    length = length - words[end].length();
                    end--;
                    numOfSpace = end -start;
                    break;
                }
            }
            if (end == words.length) 
            	end = words.length-1;
            int left = L - length;
            if (end == start) {
            	// the line only has one word and it is the last line
            	// left-justified
            	String space = "";
            	for (int i = 0; i < left; i++) {
            		space += " ";
            	}
            	String line = words[start] + space;
            	res.add(line);
            } else {
				if (end != words.length - 1) {
					// the line has at least two words
					int padding = left / numOfSpace;
					int more = left % numOfSpace;
					String space1 = "";
					String space2 = "";
					for (int i = 0; i < padding; i++)
						space1 += " ";
					for (int i = 0; i < padding + 1; i++)
						space2 += " ";
					String line = "";
					for (int i = 0; i < numOfSpace; i++) {
						line += words[start + i];
						if (more > 0) {
							line += space2;
							more--;
						} else {
							line += space1;
						}
					}
					line += words[end];
					res.add(line);
				} else {
					// for the last line, no additional space is needed.
					numOfSpace++;
					String line = "";
					for (int i = 0; i < numOfSpace; i++) {
						line += words[start + i];
						line += " ";
					}
					while (line.length() != L) {
						line += " ";
					}
					res.add(line);
				}
            }
            start = end + 1;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String[] words = {"What","must","be","shall","be."};
		int L = 12;
		ArrayList<String> res = s.fullJustify(words, L);
		for (String ss : res) {
			System.out.println(ss);
		}
	}

}
