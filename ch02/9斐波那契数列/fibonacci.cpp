class Solution {
public:
    //需要注意的是Fibonacci数列的第一项和第二项都都是1
    int Fibonacci(int n) {
        int FiboN = 0;
        int Fibo1 = 1;
        int Fibo2 = 1;
        if(n <= 0)
            return 0;
        if(1 == n or 2 == n)
            return 1;
        
        for(int i = 3; i <= n; i++) {
            FiboN = Fibo1 + Fibo2;
            Fibo1 = Fibo2;
            Fibo2 = FiboN;
        }
        
        return FiboN;
    }
};