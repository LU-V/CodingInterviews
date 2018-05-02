package CodingInterviews;

public class P15NumberOf1InBinary {
    public static int NumberOf1_1(int n){
        int count = 0;
        int flag= 0x1;
        while(flag!=0){

            if((n&flag)!=0){
                ++count;
            }
            flag=flag<<1;
        }
        return count;
    }

    public static int NumberOf1_2(int n){
        int count = 0;
        while(n!=0){
            ++count;
            n =n&(n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1_1(1));
        System.out.println(NumberOf1_2(1));
        System.out.println(NumberOf1_1(0x7FFFFFFF));
        System.out.println(NumberOf1_2(0x7FFFFFFF));
        System.out.println(NumberOf1_1(0x80000000));
        System.out.println(NumberOf1_2(0x80000000));
        System.out.println(NumberOf1_1(0xFFFFFFFF));
        System.out.println(NumberOf1_2(0xFFFFFFFF));
    }
}
