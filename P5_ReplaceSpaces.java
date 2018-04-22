package CodingInterviews;

public class P5_ReplaceSpaces {
    public static void ReplaceBlank(char string[],int length){
        if(string==null&&length<=0){
            return ;
        }
        int blankNumber=0;
        //int originaLength=0;
        int i  =0;
        while(i<length){
            if(string[i]==' '){
                ++blankNumber;
            }
            ++i;
        }
        int newLength=length+blankNumber*2;
        char[] newString = new char[newLength];
        int indexOfOriginal=length-1;
        int indexOfNew=newLength-1;
        while(indexOfNew>=indexOfOriginal&&indexOfOriginal>=0){
            if(string[indexOfOriginal]==' '){
                newString[indexOfNew--]='0';
                newString[indexOfNew--]='2';
                newString[indexOfNew--]='%';
            }else{

                newString[indexOfNew--]=string[indexOfOriginal];
            }
            --indexOfOriginal;
        }
        for(char k:newString){
            System.out.print(k);
        }

    }

    public static void main(String[] args) {
        char []s={'w','e',' ','a','r','e',' ','h','a','p','p','y'};
        ReplaceBlank(s,s.length);
    }
}
