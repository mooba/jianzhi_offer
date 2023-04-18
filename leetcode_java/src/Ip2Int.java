import java.util.Arrays;

public class Ip2Int {
    public static void main(String[] args) {
        ten2Two(198);
        // boolean success = IpToInt("192.168.100.31");
        // System.out.println();
        // System.out.println(success);
        
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(reserved));
    }

    private static int a[] = new int[32];
    private static int reserved[] = new int[4];

    private static boolean IpToInt(String s) {
        int num = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '.') {
                num = num * 10 + (s.charAt(i) - '0');
            } else {
                if (num > 255)
                    return false;
                reserved[j++] = num;
                num = 0;
            }
        }
        reserved[j] = num;
        j = 0;
        for (int i = 0; i < 4; i++) {
            int tmp = reserved[i];
            for (int n = 7; n >= 0; n--) {
                int number = tmp & 0x1;
                tmp = tmp >> 1;
                a[n + j * 8] = number;
            }
            j++;
        }

        // for (int i = 0; i < 32; i++) {
        //     if (i % 8 == 0) {
        //         System.out.print(" ");
        //     }
        //     System.out.print(a[i]);
        // }
        return true;
    }



    
    private static int[] ten2Two(int num) {
        int[] ret = new int[8];
        int tmp = num;
        for (int i = 7; i >=0; i--) {
            ret[i] = tmp & 0x1;
            tmp = tmp >> 1;
        }
        System.out.println(Arrays.toString(ret));
        return ret;
    }

}
