package CodingInterviews;

public class P4_FindInPartiallySortedMartix {
    public static void main(String[] args) {
        int martix[][]  = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(martix.length);
        System.out.println(martix[0].length);

        Find(martix,martix.length,martix[0].length,7);

        Find(martix,martix.length,martix[0].length,5);

        Find(martix,martix.length,martix[0].length,1);
    }
    public static void Find(int martix[][],int rows,int columns,int number){
        boolean found = false;
        if (martix!=null&&rows>0&&columns>0){
            int row =0;
            int column=columns-1;
            while(row<rows&&column>=0){
                if(martix[row][column]==number){
                    found=true;
                    System.out.println("Find");
                    break;
                }else if (martix[row][column]>number){
                    --column;
                }else{
                    ++row;
                }
            }
            if(martix[martix.length-1][0]!=number&&!found){
                System.out.println("NOTFIND");
            }
        }
        return ;
    }
}
