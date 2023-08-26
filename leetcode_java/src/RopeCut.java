public class RopeCut {
    public static void main(String[] args) {
        RopeCut ropeCut = new RopeCut();
        // System.out.println(ropeCut.cutRope(17));
        // System.out.println(ropeCut.cutRope1(17));
        System.out.println(ropeCut.cutRope2(8));
    }

    public int cutRope1(int target) {
        //不超过3直接计算
        if(target <= 3)
            return target- 1;
        //dp[i]表示长度为i的绳子可以被剪出来的最大乘积
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        //遍历后续每一个长度
        for(int i = 5; i <= target; i++)
            //可以被分成两份
            for(int j = 1; j < i; j++)
                //取最大值
                dp[i] = Math.max(dp[i], j * dp[i - j]);
        return dp[target];
    }


    public int cutRope2(int target) {
        if(target <= 3){
            return target- 1;
        }
        if (target == 4) {
            return 4;
        }

        int max = 0;
        for (int i = 2; i <= target; i++) {
            int tmp = i * cutRope2(target - i);
            if (tmp > max) {
                max = tmp;
            }
        }

        return max;
    }
    
    public int cutRope(int target) {
        int max = 0;
        // Map<String, Integer>
        for (int cutNum = 1; cutNum <= target; cutNum++) {
            int tmp = curHelper(cutNum, 0, target, 1);
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    public int curHelper(int m, int index, int rest, int alreadyM) {
        // System.out.println(m + "_" + index + "_" + rest);

        if (index == m - 1) {
            return alreadyM * rest;
        }

        int max = 0;
        // i 表示在index位置这段留多长，最多能留rest - (m - (index + 1))这么长
        for (int i = 1; i <= rest - (m - (index + 1)); i++) {
            int tmp = curHelper(m, index + 1, rest - i, alreadyM * i);
            if (tmp > max) {
                max = tmp;
            }
        }

        return max;
    }
}
