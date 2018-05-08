package CodingInterviews;

import java.util.Arrays;

public class P21_ReorderArray {

    public static void reOrderArray(int[] array) {
        //Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
        for (int i : array)
            System.out.println(i);
    }

    public static void main(String[] args) {
        int[] array1 = {6, 4, 2, 5, 7};
        reOrderArray(array1);
    }
}
