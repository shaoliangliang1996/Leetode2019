/*
 ��Ŀ��ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�

�����������һ����������У��������������г���С�����У����������У���

����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣

������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С�
1,2,3 �� 1,3,2
3,2,1 �� 1,2,3
1,1,5 �� 1,5,1
*/

/*
�����ǣ��Ӻ���ǰ�ң�2λ��3λ��˳���ң�
    �����nλ�ǽ������� ����λ��
    ����ѡ���n�У��ȵ�һλ�Դ��һλ�����水�������У����Ǻ���ѡ��С�ģ�
*/
class Solution {
    public boolean isdown(int[] nums,int i)//�ж��Ƿ��ǽ���
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
    public void print(int[] nums)//�����ǰ����
    {
        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
                System.out.print(nums[i]);
            else
                System.out.print(","+nums[i]);
        }
    }
    public void maopao(int[] nums,int k)//ð������
    {
        int n=nums.length;
        for(;k<n;k++)//ð������
                {
                    for(int t=k+1;t<n;t++)
                    {
                        if(nums[k]>nums[t]){int tmp=nums[k];nums[k]=nums[t];nums[t]=tmp;}
                    }
                }
    }
    public void nextPermutation(int[] nums) {//�ҵķ���̫���ӣ��и����Ĵ�����ѧϰ����˼·�ǶԵ�
        //������ֳ���Ϊ1������Ҫ����ѣ�����
        if(nums.length==1) return;
        if(nums.length==0) return;
        //print(nums);
        boolean flag=true;
        for(int i=2;i<=nums.length;)//����Ⱥţ�Ҫ��Ȼ������ȫ
        {
            if(isdown(nums,i)) i++;//��һ�����
            else//�ڶ������
            {
                //�ҳ��Դ����һλ������
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
                //ʣ�µ���������
                maopao(nums,n-i+1);//ð������
                break;//�ҵ��������ѭ��
            }
        }
        if(flag)//����Ѿ��������ֵ����������С���ֵ���
        maopao(nums,0);
        //System.out.print("��");
        //print(nums);
    }
}