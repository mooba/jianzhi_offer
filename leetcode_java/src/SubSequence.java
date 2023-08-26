import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 打印一个字符串的全部子序列,
 * 所谓子序列，就是在保持和原字符串绝对顺序不变的情况下字母的组合，可以是不连续的。
 */
public class SubSequence {

    public static void main(String[] args) {
        String a = "abccd";
        System.out.println(getAllSubSeq(a));

        System.out.println(getAllSubSeqDeduplicated(a));
    }


    /**
     * 返回不重复的子序列
     * @return
     */
    public static Set<String> getAllSubSeqDeduplicated(String s) {
        Set<String> set = new HashSet<>();
        helper2(s.toCharArray(), set, 0, "");
        return set;
    }


    static void helper2(char[] arr, Set<String> set, int index, String path) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (index == arr.length) {
            set.add(path);
            return;
        }

        helper2(arr, set, index + 1, path + String.valueOf(arr[index]));

        helper2(arr, set, index + 1, path);
    }
    

    public static List<String> getAllSubSeq(String s) {
        List<String> retList = new ArrayList<>();
        helper1(s, 0, retList, "");
        return retList;
    }

    public static void helper1(String s, int index, Collection<String> list, String path) {
        if (s == null || s.length() == 0) {
            return;
        }
        if (s.length() == index) {
            list.add(path);
            return;
        }

        // not choose
        helper1(s, index + 1, list, path);


        helper1(s, index + 1, list, path + String.valueOf(s.charAt(index)));

    }
    
}
