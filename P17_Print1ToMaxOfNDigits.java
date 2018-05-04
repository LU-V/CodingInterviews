package CodingInterviews;

import java.util.Arrays;

public class P17_Print1ToMaxOfNDigits {
    public static void printToMax(int n) {
        if (n < 0) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }
        while (!increment(number)) {
            printNumber(number);
        }
        return;
    }

    public static boolean increment(char[] num) {
        boolean isoverflow = false;
        int size = num.length;
        int carry = 0;
        for (int i = size - 1; i >= 0; i--) {
            int temp = num[i] - '0' + carry;
            if (i == size - 1) {
                temp++;
            }
            if (temp >= 10) {
                if (i == 0) {
                    isoverflow = true;
                } else {
                    temp -= 10;
                    carry = 1;
                    num[i] = (char) (temp + '0');
                }
            } else {
                num[i] = (char) (temp + '0');
                break;
            }
        }
        return isoverflow;
    }

    public static void printNumber(char[] num) {
        int size = num.length;
        int i = 0;
        while (i < size && num[i] == '0') //i < size在前，否则越界  确定要复制的范围
            i++;
        if (i == size) {
            return;
        }
        char[] printNum = Arrays.copyOfRange(num, i, size);//复制数组   复制数组num  范围是 i到size 包括i 不包括size
        System.out.println(printNum);
    }


    public static void printToMax2(int n) {
        if (n < 0) {
            return;
        }
        char number[] = new char[n];
        for (int i = 0; i < n; i++)
            number[i] = '0';

        printOrder(number, n, 0);
    }

    public static void printOrder(char[] num, int n, int loc) {
        if (loc == n) return;
        for (int i = 0; i <=9; i++) {
            num[loc]=(char) (i+'0');
            if(loc == n-1){
                printNumber(num);
            }
            printOrder(num,n,loc+1);

        }
    }

    public static void main(String[] args) {
        printToMax2(3);
        printToMax(3);
    }
}
