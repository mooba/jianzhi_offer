import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 【7,3,100,50】四种面值的货币，每种可以使用多张，问有多少种方式能够拼成target的总额（返回方法数）。
 */
public class CoinsWay {
    
    public static void main(String[] args) {
    
        int[] arr = {5, 10, 50, 100};
        int aim = 1000;
        System.out.println(ways1(arr, aim));
        System.out.println(ways2(arr, aim));
        System.out.println(ways3(arr, aim));
        System.out.println(ways4(arr, aim));

        System.out.println(process5(arr, aim));
    }


    /**
     * 
     * @param arr 都是正整数且不重复
     * @param aim 目标额度
     * @return 
     */
    public static int ways1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        
        return process1(arr, 0, aim);
    }

    // 尝试模型，暴力递归
    // 可以使用arr[index...]所有的面额的任意张数，要组成rest, 返回方法数
    public static int process1(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }

        // i 为使用index的面值的张数
        int count = 0;
        for (int i = 0; i <= rest / arr[index]; i++) {
            count += process1(arr, index + 1, rest - arr[index] * i);
        }

        return count;
    }


    // 记忆化搜索，可以用hashmap拼上动态参数，也可以用二维数组做记忆
    // ways2是用hashmap做记忆化搜索
    public static int ways2(int[] arr, int aim) { 
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        
        Map<String, Integer> memo = new HashMap<>();
        return process2(arr, 0, aim, memo);
    }

    
    public static int process2(int[] arr, int index, int rest, Map<String, Integer> memo) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }

        int count = 0;
        for (int i = 0; i <= rest / arr[index]; i++) {
            String key = index + "_" + rest;
            Integer ways = memo.get(key);
            if (ways != null) {
                count += ways;
            } else {
                count += process2(arr, index + 1, rest - i * arr[index], memo);
            }
        }

        return count;
    }


    /**
     * 使用二维数组作记忆化搜索  有点类似于动态规划了
     * @param arr
     * @param aim
     * @return
     */
    public static int ways3(int[] arr, int aim) { 
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
    
        int[][] dp = new int[arr.length + 1][aim + 1];
        // 先把所有位置设置成-1，用于标记没有被算过
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return process3(arr, 0, aim, dp);
    }


    public static int process3(int[] arr, int index, int rest, int[][] dp) {
        int len = arr.length;
        if (index == len) {
            return rest == 0 ? 1 : 0;
        }

        if (dp[index][rest] == -1) {
            int ways = 0;
            for (int i = 0; i <= rest / arr[index]; i++) {
                ways += process3(arr, index + 1, rest - arr[index] * i, dp);
            }
            dp[index][rest] = ways;
            return ways;
        } 

        return dp[index][rest];
    }




    /**
     * 动态规划
     * @param arr
     * @param aim
     * @return
     */
    public static int ways4(int[] arr, int aim) { 
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
    
        return process4(arr, aim);
    }


    /**
     * 还有优化的空间，这种方式枚举了所有的情况，是最基础的一种写法
     * 在通过累加获得dp[i][rest]的过程中，其实dp[i][rest - arr[i]]已经被计算了
     */
    public static int process4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        int len = arr.length;
        int[][] dp = new int[len + 1][aim + 1];
        dp[len][0] = 1;
        
        for (int i = len - 1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                int count = 0;
                for (int zhang = 0; zhang <= rest / arr[i]; zhang++) {
                    count += dp[i + 1][rest - arr[i] * zhang];
                }
                dp[i][rest] = count;
            }
        }

        return dp[0][aim];
    }


    public static int process5(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        int len = arr.length;
        int[][] dp = new int[len + 1][aim + 1];
        dp[len][0] = 1;
        
        for (int i = len - 1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                // int count = 0;
                // for (int zhang = 0; zhang <= rest / arr[i]; zhang++) {
                //     count += dp[i + 1][rest - arr[i] * zhang];
                // }
                dp[i][rest] = dp[i + 1][rest];
                if (rest - arr[i] >= 0) {
                    dp[i][rest] += dp[i][rest - arr[i]];
                }
            }
        }

        return dp[0][aim];
    }


}


