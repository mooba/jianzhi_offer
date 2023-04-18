/**
 * 汉诺塔问题
 */
public class Hanoi {
    // 写一个构造函数

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        // hanoi.hanoi1(3);
        hanoi.hanoi2(3);
        System.out.println(hanoi.totalStep);
    }

    private int totalStep = 0;

    public void hanoi1(int n) {
        left2right(n);
    }

    public void hanoi2(int n) {
        hanoiHelper(n, "left", "right", "mid");
    }

    public void hanoiHelper(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println(n + from + "-->" + to);
            totalStep++;
            return;
        }

        hanoiHelper(n - 1, from, other, to);
        System.out.println(n + from + "-->" + to);
        totalStep++;
        hanoiHelper(n - 1, other, to, from);
    }

    

    // 把n层圆盘从做移动到右边
    public void left2right(int n) {
        if (n == 1) {
            System.out.println(n + "圆盘从左到右");
            totalStep++;
            return;
        }
        left2mid(n - 1);
        System.out.println(n + "圆盘从左到右");
        totalStep++;
        mid2right(n - 1);
    }


    void left2mid(int n) {
        if (n == 1) {
            System.out.println(n + "圆盘从左到中");
            totalStep++;
            return;
        }

        left2right(n - 1);
        System.out.println(n + "圆盘从左到中");
        totalStep++;
        right2mid(n - 1);
    }
    

    void mid2right(int n) {
        if (n == 1) {
            System.out.println(n + "圆盘从中到右");
            totalStep++;
            return;
        }

        mid2left(n - 1);
        System.out.println(n + "圆盘从中到右");
        totalStep++;
        left2right(n - 1);
    }


    void right2mid(int n) {
        if (n == 1) {
            System.out.println(n + "圆盘从右到中");
            totalStep++;
            return;
        }
        
        right2left(n - 1);
        System.out.println(n + "圆盘从右到中");
        totalStep ++;
        left2mid(n - 1);
    }


    void mid2left(int n) {
        if (n == 1) {
            System.out.println(n + "圆盘从中到左");
            totalStep++;
            return;
        }
        mid2right(n - 1);
        System.out.println(n + "圆盘从中到左");
        totalStep++;
        right2left(n - 1);
    }


    void right2left(int n) {
        if (n == 1) {
            System.out.println(n + "圆盘从右到左");
            totalStep++;
            return;
        }
        
        right2mid(n - 1);
        System.out.println(n + "圆盘从右到左");
        totalStep++;
        mid2left(n - 1);
    }
}
