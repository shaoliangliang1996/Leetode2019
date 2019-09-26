/*
 题目：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */

/*
 遇到这种简单的数列求和问题，第一个想到就是二重循环暴力，时间复杂度是O(n2),空间复杂度是O(1)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
            for(int j=i+1;j<nums.length;j++)
                if(nums[i]+nums[j]==target)
                {
                    //System.out.print("["+i+','+j+"]");
                    return new int[]{i,j};				//数组的定义形式
                }
        return new int[]{0,0};
        }
            
    }


/*
 方法二：
二重遍历查找的问题还可用hash表的方法减少时间复杂度，至O(n),用空间换时间后空间复杂度为O(n)
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
        	int sub=target-nums[i];
        	if (map.containsKey(sub)) {
                return new int[] { map.get(sub), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");//如果没找到就报错
        }
            
    }

