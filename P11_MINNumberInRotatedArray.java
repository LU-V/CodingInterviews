package CodingInterviews;

public class P11_MINNumberInRotatedArray {
    public static int Min(int []a){
        int p1=0;
        int p2=a.length-1;
        int mid=p1;
        if(a!=null){
            while(p2>=p1){
                if(p2-p1==1){
                    if(a[p1]>=a[p2]){
                        mid= p2;
                    }else{
                        mid=p1;
                    }

                    break;
                }
                mid=(p1+p2)>>1;
                if(a[mid]<=a[p2]){
                    p2=mid;
                }else if(a[mid]>a[p1]){
                    p1=mid;
                }
            }
        }else{
            return 0;
        }
        return mid;
    }
    public static int Min2(int []a){
        int p1=0;
        int p2=a.length-1;
        int result=a[p1];

        for(int i = p1;i<p2;i++){
            if(result>a[i]){
                result=a[i];
            }

        }return result;
    }


    public static void main(String[] args) {
        int a[]={5,1,2,3,4};
        System.out.println(a[Min(a)]);

        int b[]={1,1,1,0,1};
        System.out.println(Min2(b));

        int c[]={1,1,0,1,1};
        System.out.println(Min2(c));
    }
}
