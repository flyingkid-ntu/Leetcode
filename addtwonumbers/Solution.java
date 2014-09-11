package addtwonumbers;

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        boolean overflow = false;
        int sumInit = l1.val + l2.val;
        if (sumInit >= 10) {
            sumInit -= 10;
            overflow = true;
        }
        ListNode res = new ListNode(sumInit);
        ListNode last = res;
        ListNode one = l1.next;
        ListNode two = l2.next;
        while (one != null && two != null) {
            int sum = 0;
            if (overflow) {
                sum = one.val + two.val + 1;
                overflow = false;
            } else {
                sum = one.val + two.val;
            }
            if (sum >= 10) {
                sum -= 10;
                overflow = true;
            }
            ListNode cur = new ListNode(sum);
            last.next = cur;
            last = cur;
            one = one.next;
            two = two.next;
        }
        if (one == null && two == null) {
            if (overflow) {
                ListNode cur = new ListNode(1);
                last.next = cur;
            }
        } else {
            if (one == null) {
                one = two;
            }
            while (one != null) {
                int sum = 0;
                if (overflow) {
                    sum = one.val + 1;
                    overflow = false;
                } else {
                    sum = one.val;
                }
                if (sum >= 10) {
                    sum -= 10;
                    overflow = true;
                }    
                ListNode cur = new ListNode(sum);
                last.next = cur;
                last = cur;
                one = one.next;
            }
            if (overflow) {
                ListNode cur = new ListNode(1);
                last.next = cur;
            }
        }
        return res;
    }
	
	public ListNode generate (int[] num) {
		ListNode res = new ListNode (num[0]);
		ListNode last = res;
		for (int i = 1; i < num.length; i++) {
			ListNode cur = new ListNode(num[i]);
			last.next = cur;
			last = cur;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] a = {8,7,4,8,3,2,0,0,2,1};
		int[] b = {1,1,2,2,5,5,6,5,2};
		ListNode l1 = s.generate(a);
		ListNode l2 = s.generate(b);
		long st = System.currentTimeMillis();
		ListNode res = s.addTwoNumbers(l1, l2);
		long ed = System.currentTimeMillis();
		System.out.println(ed + ", " + st);
		while (res != null) {
			System.out.print(res.val + ", ");
			res = res.next;
		}
	}

}
