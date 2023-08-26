public class Knapsack {
    public static void main(String[] args) {

        int[] weights = {3,4,3,7,1};
        int[] values = {6,4,8,7,2};
        int bag = 10;

        int maxValue = process(weights, values, 0, bag);
        System.out.println(maxValue);
    }


    /**
     * 
     * @param w
     * @param v
     * @param index 来到当前index，判断这个货物要还是不要
     * @param alreadyW 来到当前index, bag中还剩的重量空间rest
     * @return 返回-1 表示没有方案，大于等于0表示能装的货物总价值
     */
    public static int process(int[] w, int[] v, int index, int rest) {
        if (rest < 0) {
            return -1;
        }

        if (index == w.length) {
            return 0;
        }

        // 不要当前位置的货物
        int value1 = process(w, v, index + 1, rest);

        // 要当前位置的货物
        int next = process(w, v, index + 1, rest - w[index]);
        int value2 = -1;
        if (next != -1) {
            value2 = v[index] + next;
        }
        
        return Math.max(value1, value2);
    }


    // 递归转为动态规划
    public static int process1(int[] w, int[] v, int bag) {
        if (bag < 0) {
            return -1; // 无效解
        }

        int N = w.length;

        int[][] dp = new int[N + 1][bag + 1];

        return dp[0][bag];
    }



}
