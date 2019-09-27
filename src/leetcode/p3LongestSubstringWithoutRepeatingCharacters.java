/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * 原方法，寻找不重复的最长连续子串，用了滑动窗口的方法
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.equals("")) return 0;
        int Max=1;
        for(int i=0;i<s.length();i++)
        {
            for(int j=i+1;j<s.length();j++)
            {
                if(s.substring(i,j).indexOf(String.valueOf(s.charAt(j)))==-1) 
                    Max=(Max>=(j-i+1))?Max:(j-i)+1;//直接用Math.max()
                else break;
            }
        }
        return Max;
    }
}

/**
 * 同样利用Hash的相关操作来减少时间复杂度，这里像p1一样我的原答案都用可双重循环，第二重用来查找
 * 刚好hash对于查找可以将O(n)变为O(1).且对于set来说查找比添加更快捷（相对于arraylist）
 * 算法的总时间复杂度变为O(2n)->O(n)
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
/**
 * 官方题解还有更快的解法 O(n)，用hashmap
 */

