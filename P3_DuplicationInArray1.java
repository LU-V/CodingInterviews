package CodingInterviews;
//Duplication1ʱ�临�Ӷ�ΪO(n),�ռ临�Ӷ�ΪO(1)��ȱ���Ǹı�������
public class P3_DuplicationInArray1 {
    public static void duplicate(int numbers[],int length){

        if(numbers==null||length<=0){
            return;
        }
        for(int i =0;i<length;++i){
            if(numbers[i]<0||numbers[i]>length-1){
                return;
            }
        }
        for(int i =0;i<length;++i){
            while (numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    System.out.println(numbers[i]);
                    break;
                }
                int t=numbers[i];
                numbers[i]=numbers[t];
                numbers[t]=t;
            }
        }
    }
    public static void main(String[] args) {
        int []numbers={2,3,1,0,2,5,3,5};
        duplicate(numbers,numbers.length);
    }
}