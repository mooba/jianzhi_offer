import java.util.Arrays;
import java.util.Random;

public class XY {
    public static void main(String[] args) {
        
        int result = 10;
        while (result > 9) {
            int[] arr = generate();
            result = convert(arr);
        }  

        System.out.println(result);
    }

    static int x() {
        return new Random().nextInt(2);
    }

    static int convert(int[] arr) {

        int num10 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                num10 += (int) Math.pow(2, i);
            }
        }
        return num10;
    }

    static int[] generate() {
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = x();
        }
        return arr;
    }
};