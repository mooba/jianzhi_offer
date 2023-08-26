import java.util.HashSet;
import java.util.Set;

public class RobotMovingCount {

    public static void main(String[] args) {
        int threshold = 15;
        int rows = 20, cols = 20;

        // int threshold = 10;
        // int rows = 1, cols = 100;

        RobotMovingCount robotMovingCount = new RobotMovingCount();

        System.out.println(robotMovingCount.movingCount(threshold, rows, cols));
    }


    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        helper(threshold, rows, cols, 0, 0, set);
        // System.out.println(set);
        return set.size();
    }


    static int[][] points = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void helper(int threshold, int rows, int cols, int i, int j, Set<String> set) {
        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            return;
        }

        if (calNum(i) + calNum(j) <= threshold) {
            System.out.println(i + "_" + j);
            set.add(i + "_" + j);
        } else{
            return;
        }

       for (int[] point : points) {
            int newI = i + point[0];
            int newJ = j + point[1];
            String key = newI + "_" + newJ;
            if (!set.contains(key)) {
                helper(threshold, rows, cols, newI, newJ, set);
            }
       }
    }

    int calNum(int num) {
        String str = String.valueOf(num);
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            ret += str.charAt(i) - '0';
        }
        return ret;
    }
}
