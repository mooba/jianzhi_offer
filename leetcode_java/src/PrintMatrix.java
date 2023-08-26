import java.util.ArrayList;

public class PrintMatrix {
    public static void main(String[] args) {
        // int[][] matrix = {{1,2,3,4},
        // {5,6,7,8},
        // {9,10,11,12},
        // {13,14,15,16}};
        int[][] matrix = {{1,2,3,4,5},
                          {6,7,8,9,10}};

        System.out.println(printMatrix(matrix));
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0, j = 0;
        int right = n - 1, down = m - 1, left = 0, up = 0;
        while (true) {
            for (int tmp = 0; tmp <= right; tmp++)
            while(j <= right) {
                list.add(matrix[i][j]);
                j++;
            }
            j--;
            up++;
            i++;
            if (i > down) {
                break;
            }

            while (i <= down) {
                list.add(matrix[i][j]);
                i++;
            }
            i--;
            down--;
            j--;
            if (j < left) {
                break;
            }

            while (j >= left) {
                list.add(matrix[i][j]);
                j--;
            }
            j++;
            left++;
            i--;

            if (i < up) {
                break;
            }
            while (i >= up) {
                list.add(matrix[i][j]);
                i--;
            }
            i++;
            up++;
            j++;
            if (i > left) {
                break;
            }
        }

        return list;
    }
}
