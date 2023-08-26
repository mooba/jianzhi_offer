import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 获得一个字符串的全排列：由所有字符排列组合成的所有字符串
 */
public class Permutation {
    public static void main(String[] args) {
        String s = "abca";
        List<String> retList = getPermutation(s);
        System.out.println(retList);
    }


    public static List<String> getPermutation(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return list;
        }
        process1(s.toCharArray(), 0, list);
        return list;
    }


    public static void process(char[] arr, int index, Collection<String> ret) {
        if (index == arr.length) {
            ret.add(String.valueOf(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            process(arr, i + 1, ret);
            swap(arr, i, index);
        }
    }

    /**
     * 返回不重复的排列
     * 使用了分支限界的算法，性能更好
     * @param arr
     * @param index
     * @param ret
     */
    public static void process1(char[] arr, int index, Collection<String> ret) {
        if (index == arr.length) {
            ret.add(String.valueOf(arr));
            return;
        }

        // set 记录本轮来过index位置的char，如果已经来过就可以不用来了
        Set<Character> set = new HashSet<>(arr.length); 
        for (int i = index; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                swap(arr, index, i);
                process1(arr, i + 1, ret);
                swap(arr, i, index);
            }
        }
    }


    public static void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

}
