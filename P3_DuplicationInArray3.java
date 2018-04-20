package CodingInterviews;

import java.util.HashMap;
//duplication �ظ� ���� ����
public class P3_DuplicationInArray3 {
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean flag = false;
        if(numbers==null || length==0){
            return flag;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: numbers){
            if(map.containsKey(num)){//��������Ƿ���ڣ����ڵĻ����ظ�key��ֵ
                flag = true;
                duplication[num] = num;
            }
            map.put(num, 0);
        }
        return flag;
    }

    public static void main(String[] args) {
        int numbers[]={2,3,1,0,2,5,3,3,3,78};
        int[] duplication = new int[numbers.length];
        duplicate(numbers,numbers.length,duplication);
        for(int k:duplication){
            if(k!=0){
                System.out.println(k);
            }
        }
    }
}
