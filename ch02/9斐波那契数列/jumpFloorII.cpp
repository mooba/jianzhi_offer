/****题目***
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
*********/

class Solution {
public:
    //分析几步之后就会发现青蛙跳的方式的数量是2^(n-1)
    //这里需要注意的是2的多少次方用移位操作来实现比乘除法要快很多
    int jumpFloorII(int number) {
        if (number <= 0)
            return 0;
        if (number == 1) 
            return 1;

        int re = 1;
        for(int i = 1; i < number; i ++) {
            re = re << 1;
        }
        
		return re;
    }
};