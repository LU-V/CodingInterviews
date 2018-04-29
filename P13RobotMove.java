package CodingInterviews;

public class P13RobotMove {
    public static int movingCount(int k,int rows,int cols){
        if(k<0||rows<=0||cols<=0){
            return 0;
        }

        boolean visited[]=new boolean[rows*cols];
        for(int i = 0;i<rows*cols;i++){
            visited[i]=false;
        }
        int count = movingCountCore(k,rows,cols,0,0,visited);
        return count;
    }

    private static int movingCountCore(int k, int rows, int cols, int i, int j, boolean[] visited) {
        int count = 0;
        if(check(k,rows,cols,i,j,visited)){
            visited[i*cols+j]=true;
            count=1+movingCountCore(k,rows,cols,i-1,j,visited)+
                    movingCountCore(k,rows,cols,i,j-1,visited)+
                    movingCountCore(k,rows,cols,i+1,j,visited)+
                    movingCountCore(k,rows,cols,i,j+1,visited);                    ;
        }
        return count;
    }

    private static boolean check(int k, int rows, int cols, int i, int j, boolean[] visited) {
        if(rows>i&&cols>j&&i>=0&&j>=0&&getDigitSum(i)+getDigitSum(j)<=k&&!visited[i*cols+j]){
            return true;
        }

        return false;
    }
    public static int getDigitSum(int number){
        int sum = 0;
        while(number>0){
            sum+=number%10;
            number/=10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(4,5,5));
        System.out.println(movingCount(5,10,10));
    }
}
