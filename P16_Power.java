package CodingInterviews;

public class P16_Power {
    //普通的方法 考虑了 exponent 是负数的情况
    public static double power(double base,int exponent){
        if(base==0&&exponent<0){
            return 0.0;
        }
        double result= 1;
        if(exponent<0){
            base=1/base;
            exponent=-exponent;
        }
        for(int i = 0;i<exponent;i++){
            result*=base;
        }
        return result;
    }
//高效的方法
//      a^n = a^(n/2)*a^(n/2)           n是偶数
// 或者a^n = a^((n-1)/2)*a^((n-1)/2)   n是奇数
    public static double power1(double base,int exponent){
        if(base==0&&exponent<0){
            return 0.0;
        }
        if (exponent==0){
            return 1;
        }
        if (exponent==1){
            return base;
        }
        if (exponent==-1){
            return 1/base;
        }
        double result = power1(base,exponent>>1);
        result*=result;
        if (exponent%2==1||exponent%2==-1){
            result*=base;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(power1(2,-3));
        System.out.println(power1(2,11));
        System.out.println(power1(-2,-3));
        System.out.println(power1(-2,11));
        System.out.println(power1(0,-4));
        System.out.println(power1(2,0));
    }
}
