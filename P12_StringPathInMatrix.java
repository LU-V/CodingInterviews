package CodingInterviews;

public class P12_StringPathInMatrix {

    /**
     * @param matrix ¾ØÕó×Ö·û´®
     * @param rows   ¾ØÕóĞĞ
     * @param cols   ¾ØÕóÁĞ
     * @param str    ×Ö·û´®Â·¾¶
     * @return ´æÔÚÒ»ÌõÂ·¾¶·µ»Øtrue£¬·ñÔòfalse
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean flag[] = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }


    private static boolean hasPathCore(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, boolean[] flag) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index])
            return false;
        if (k == str.length - 1) return true;
        flag[index] = true;
        if (hasPathCore(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || hasPathCore(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || hasPathCore(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || hasPathCore(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }
        flag[index] = false;
        return false;
    }

    public static void main(String[] args) {
        int rows=3;
        int cols=4;
        char[] str={'b','f','c','e'};
        char m[]= {'a','b','t','g','c','f','c','s','j','d','e','h'};
        System.out.println(hasPath(m,rows,cols,str));
    }
}