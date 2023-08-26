import java.util.HashSet;
import java.util.Set;

// 剑指offer
public class PathInMatrix {
    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 'c', 'e'}, {'s','f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        String word = "abcced";
        System.out.println(hasPath(matrix, word));
    }

    public static boolean hasPath (char[][] matrix, String word) {
        // write code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 
        || word == null || word.length() == 0) {
            return false;
        }

        boolean ret = false;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == word.charAt(0)) {
                    set.clear();
                    set.add(i + "_" + j);
                    ret = pathHelper(matrix, i, j, word.toCharArray(), 0, set);
                    if (ret) {
                        return ret;
                    }
                }
            }
        }    
        return ret;
    }

    static int[][] points = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static boolean pathHelper(char[][] matrix, int i, int j,  char[] word, int index, Set<String> set) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return false;
        }
        if (index == word.length) {
            return true;
        }

        if (matrix[i][j] != word[index]) {
            return false;
        }

        boolean result = false;
        for(int k = 0; k < points.length; k ++) {
            int newI = i + points[k][0];
            int newJ = j + points[k][1];
            String key = newI + "_" + newJ;
            if (set.contains(key)) {
                continue;
            }
            set.add(key);
            result = pathHelper(matrix, newI, newJ, word, index + 1, set);
            if (result) {
                return result;
            } else {
                set.remove(key);
            }
        }

        return result;
    }
    
}
