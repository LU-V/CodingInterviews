package CodingInterviews;
//只能找到任意一个重复数字，不改变数组
public class P3_DuplicationInArray2 {
    public static int duplicate(int numbers[], int length) {
        if (numbers == null || length <= 0) {
            return -1;
        }
        int start = 1;
        int end = length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(numbers, length, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public static int countRange(int[] numbers, int length, int start, int end) {
        if (numbers == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= start && numbers[i] <= end) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //int[] numbers = {2, 3, 5, 4, 3, 2, 6, 7};
        int[] numbers = {1,2,3,4,5,6,6,7};
        int[] duplication = new int[numbers.length];
        System.out.println(duplicate(numbers, numbers.length));
    }
}
