
/**
 *题目：给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num=l1.val+l2.val;
        ListNode l3 =new ListNode(num%10); 
        ListNode head=l3;
        while(l1.next!=null&&l2.next!=null)
        {
            l1=l1.next;
            l2=l2.next;
            num=l1.val+l2.val+num/10;
            l3.next=new ListNode(num%10);
            l3=l3.next;
        }
        while(l1.next!=null)//这里在链表不等长的处理方法上很啰嗦
        {
            l1=l1.next;
            num=l1.val+num/10;
            l3.next=new ListNode(num%10);
            l3=l3.next;
        }
        while(l2.next!=null)//和上一个函数是重复的
        {
            l2=l2.next;
            num=l2.val+num/10;
            l3.next=new ListNode(num%10);
            l3=l3.next;
        }
        if(num/10!=0)
            l3.next=new ListNode(num/10);
        return head;
    }
}
/**
当遇到两个数组或列表的操作的时候，肯定会有不等长的情况，这一用如下方法写，原来的写法太啰嗦
*/
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {//**
        int x = (p != null) ? p.val : 0;//**
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;//**
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}
