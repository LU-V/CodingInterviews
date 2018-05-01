package CodingInterviews;

public class P14_maxProductAfterCuttingGreedy {
    public static int maxProductWithGreedy(int len){
        if(len<2)
            return 0;
        if(len==2)
            return 1;
        if(len==3)
            return 2;
        //啥也不管,先尽可能减去长度为3的段
        int timeOfThree=len/3;

        //判断还剩下多少，再进行处理
        if(len-timeOfThree*3==1)
            timeOfThree-=1;
        int timeOfTwo=(len-timeOfThree*3)/2;

        return (int) ((Math.pow(3, timeOfThree))*(Math.pow(2, timeOfTwo)));
    }

    public static void main(String[] args) {
        System.out.println(maxProductWithGreedy(7));
        System.out.println(maxProductWithGreedy(8));
    }

}
