package CodingInterviews;
//两种方法，都不难，
//        第一种有点麻烦
//        第二种正则表达式很强大
//        剑指offer Java版代码

public class P20_NumericStrings_byoia {

    public static boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }
        boolean numeric = true;
        int i = 0;
        while (i < str.length) {
            if (str[i] == '-' || str[i] == '+') {//有符号
                i++;
                while (str[i] >= '0' && str[i] <= '9') {
                    if (i == str.length - 1)
                        return true;
                    i++;
                }
                if (i != str.length - 1 && (str[i] == 'e' || str[i] == 'E')) {
                    i++;
                    while (str[i] >= '0' && str[i] <= '9') {
                        if (i == str.length - 1)
                            return true;
                        i++;
                    }
                } else if (str[i] == '.') {
                    i++;
                    while (str[i] >= '0' && str[i] <= '9') {
                        if (i == str.length - 1)
                            return true;
                        i++;
                    }
                    if (i != str.length - 1 && (str[i] == 'e' || str[i] == 'E')) {
                        i++;
                        while (str[i] >= '0' && str[i] <= '9') {
                            if (i == str.length - 1)
                                return true;
                            i++;
                        }
                    }
                }

            } else if (str[i] >= '0' && str[i] <= '9') {//无符号
                i++;
                while (str[i] >= '0' && str[i] <= '9') {
                    if (i == str.length - 1)
                        return true;
                    i++;
                }
                if (str[i] == '.') {
                    i++;
                    while (str[i] >= '0' && str[i] <= '9') {
                        if (i == str.length - 1)
                            return true;
                        i++;
                    }

                } else if (i != str.length - 1 && (str[i] == 'e' || str[i] == 'E')) {
                    i++;
                    while (str[i] >= '0' && str[i] <= '9') {
                        if (i == str.length - 1)
                            return true;
                        i++;
                    }

                }
            } else {
                return false;
            }
        }


        return numeric;
    }

    public static boolean isNumeric1(char[] str) {//正则表达式

        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
            //?匹配前面的子表达式0次或者1次
            // * 匹配前面的子表达式 0次或者多次
            //+匹配前面的子表达式1次或者多次
    }

    public static void main(String[] args) {
        char str[] = {'-', '1', '.', '2'};
        System.out.println(isNumeric(str));

        char str1[] = {'-', '7', '8', 'e'};
        System.out.println("-78e:" + isNumeric(str1));

        char str2[] = {'7', '8', 'e'};
        System.out.println("78e:" + isNumeric(str2));

        char str3[] = {'-', '7', '.', '8', 'e', '9'};
        System.out.println("-7.8e9:" + isNumeric(str3));

        char str4[] = {'1', '7', '3', '8', 'E', '9'};
        System.out.println("1738E9:" + isNumeric(str4));

        char str5[] = {'1', '7', '3', '8', '9'};
        System.out.println("17389:" + isNumeric(str5));

        char str6[] = {'a', '7', '3', '8', '9'};
        System.out.println("a7389:" + isNumeric(str6));

        char str7[] = {'a', 'b'};
        System.out.println("ab:" + isNumeric(str7));

        char str8[] = {'0', 'b'};
        System.out.println("0b:" + isNumeric1(str8));

        char str9[] = {'0'};
        System.out.println("0:" + isNumeric1(str9));

        char str11[] = {'-', '7', '8', 'e'};
        System.out.println("-78e:" + isNumeric1(str11));

        char str12[] = {'7', '8', 'e'};
        System.out.println("78e:" + isNumeric1(str12));

        char str13[] = {'-', '7', '.', '8', 'e', '9'};
        System.out.println("-7.8e9:" + isNumeric1(str13));

        char str14[] = {'1', '7', '3', '8', 'E', '9'};
        System.out.println("1738E9:" + isNumeric1(str14));

        char str15[] = {'1', '7', '3', '8', '9'};
        System.out.println("17389:" + isNumeric1(str15));

        char str16[] = {'a', '7', '3', '8', '9'};
        System.out.println("a7389:" + isNumeric1(str16));

        char str17[] = {'a', 'b'};
        System.out.println("ab:" + isNumeric1(str17));

        char str18[] = {'0', 'b'};
        System.out.println("0b:" + isNumeric1(str18));

        char str19[] = {'0'};
        System.out.println("0:" + isNumeric1(str19));
    }
}




