package CodingInterviews;

public class P14_maxProductAfterCutting{
    public static int maxProductAfterCutting(int length){
        int product[] = new int[length+1];
        if(length<2){
            return 0;
        }else if (length==2){
            return 1;
        }else if (length==3){
            return 2;
        }
        product[0]=0;
        product[1]=1;
        product[2]=2;
        product[3]=3;
        int max = 0;
        for(int i = 4;i<=length;++i){

            for(int j = 1;j<=i/2;++j){
                int products=product[j]*product[i-j];
                if(max<products){
                    max=products;
                }
                product[i]=max;
            }

        }
        max=product[length];
        return  max;
    }

    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting(1));
        System.out.println(maxProductAfterCutting(8));
        System.out.println(maxProductAfterCutting(18));

    }
}