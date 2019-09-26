/*
 题目：实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

/*
规则是：从后往前找，2位，3位的顺序找，
    如果后n位是降序排列 则扩位，
    否则选择后n中，比第一位稍大的一位，后面按升序排列（就是后面选最小的）
*/
class Solution {
    public boolean isdown(int[] nums,int i)//判断是否是降序
    {
        int n=nums.length;
        while(i>1)
        {
            if(nums[n-i]<nums[n-i+1])
                return false;
            i--;
        }
        return true;
    }
    public void print(int[] nums)//输出当前数组
    {
        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
                System.out.print(nums[i]);
            else
                System.out.print(","+nums[i]);
        }
    }
    public void maopao(int[] nums,int k)//冒泡排序
    {
        int n=nums.length;
        for(;k<n;k++)//冒泡排序
                {
                    for(int t=k+1;t<n;t++)
                    {
                        if(nums[k]>nums[t]){int tmp=nums[k];nums[k]=nums[t];nums[t]=tmp;}
                    }
                }
    }
    public void nextPermutation(int[] nums) {//我的方法太复杂，有更简洁的代码需学习，但思路是对的
        //不会出现长度为1的数组要排序把？？？
        if(nums.length==1) return;
        if(nums.length==0) return;
        //print(nums);
        boolean flag=true;
        for(int i=2;i<=nums.length;)//这里等号，要不然遍历不全
        {
            if(isdown(nums,i)) i++;//第一种情况
            else//第二种情况
            {
                //找出稍大的哪一位，交换
                flag=false;
                int n=nums.length;
                int pre=nums[n-i];
                int Min=0,cur=-1;
                for(int j=n-i+1;j<n;j++)
                {
                    int sub=nums[j]-pre;
                    if(cur==-1&&sub>0) 
                    {
                        Min=sub;
                        cur=j;
                    }
                    else if(sub>0&&Min>sub)
                    {
                        Min=sub;
                        cur=j;
                    }

                }
                
                nums[n-i]=nums[cur];
                nums[cur]=pre;
                //剩下的升序排序
                maopao(nums,n-i+1);//冒泡排序
                break;//找到，则结束循环
            }
        }
        if(flag)//如果已经是最大的字典序，则输出最小的字典序
        maopao(nums,0);
        //System.out.print("→");
        //print(nums);
    }
}