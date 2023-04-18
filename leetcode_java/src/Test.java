import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        // char a = 'a';
        // System.out.println((int)a);
        // Character aa = a;
        // System.out.println(aa);


        // test3();


        test459();

    }




    // static void test572() {
    //     System.out.println("hello test572!");
    //     Solution1 s = new Solution1();

    //     // String str1 = "[3,4,5,1,2,null,null,null,null,0]";
    //     // String str2 = "[4,1,2]";
    //     // TreeNode tree = BinaryTree.createTree(str1);
    //     // TreeNode subTree = BinaryTree.createTree(str2);
    //     // System.out.println(s.isSubtree(tree, subTree));

    //     String str = "[3,4,5,1,2]";
    //     TreeNode root = BinaryTree.createTree(str);
    //     StringBuilder sb = new StringBuilder();
    //     s.postOrder(root, sb);
    //     System.out.println(sb.toString());

    // }



    // static void test15() {
    //     System.out.println("test 15");
    //     Solution1 solution1 = new Solution1();
    //     int[] nums = {-1,0,1,2,-1,-4};
    //     List<List<Integer>> retList = solution1.threeSum(nums);
    //     System.out.println(retList);
    // }

    // static void test3() {
    //     System.out.println("test 15");
    //     Solution1 solution1 = new Solution1();
    //     String str = "abcabcbb";
    //     System.out.println(solution1.lengthOfLongestSubstring(str));
    // }


        static void test459() {
            String str = "abcabcabcabc";
            Solution1 solution1 = new Solution1();
            boolean ret = solution1.repeatedSubstringPattern(str);
            System.out.println(ret);
        }

}
