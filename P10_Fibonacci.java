package CodingInterviews;

public class P10_Fibonacci {
    public static long fib(int n) {
        int result[]={0,1};
        if(n<2){
            return result[n];
        }
        long fibN=0;
        long fibOne=0;
        long fibTwo=1;
        for(int i = 2;i<=n;i++){
            fibN=fibOne+fibTwo;
            fibOne=fibTwo;
            fibTwo=fibN;
        }
        return fibN;
    }

    public static void main(String[] args) {
        System.out.println(fib(100));
        System.out.println(fib(4));
        System.out.println(fib(0));
        System.out.println(fib(1));
    }
}
