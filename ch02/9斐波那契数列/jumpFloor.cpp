/**题目******
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
************/

class Solution {
public:
    //多分析几步就会发现，这其实就是一个斐波拉契数列，同样可以用递归或者递推两种解法
    //这里用递归来实现，要主要判断递归终止条件和特殊情况
    int jumpFloor(int number) {
        if(number <= 0)
            return 0 ;
        else if (1 == number)
            return 1;
        else if (2 == number)
            return 2;
        else
            return jumpFloor(number - 1) + jumpFloor(number-2);
    }
};