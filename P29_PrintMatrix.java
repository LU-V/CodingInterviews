package CodingInterviews;

import java.util.ArrayList;

public class P29_PrintMatrix {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>() ;
        if(matrix==null || matrix.length==0) { return result ; }

        printMatrixClockWisely(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, result);

        return result ;
    }

    public static void printMatrixClockWisely(int[][] matrix, int startRow, int startCol, int endRow, int endCol, ArrayList<Integer> result) {
        if(startRow<endRow && startCol<endCol) {
            for(int j=startCol; j<=endCol; j++) { result.add(matrix[startRow][j]) ; }   //Right
            for(int i=startRow+1; i<=endRow; i++) {
                result.add(matrix[i][endCol]) ; }     //Down
            for(int j=endCol-1; j>=startCol; j--) { result.add(matrix[endRow][j]) ; }     //Left
            for(int i=endRow-1; i>=startRow+1; i--) { result.add(matrix[i][startCol]) ; }   //Up
            printMatrixClockWisely(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1, result) ;
        }else if(startRow==endRow && startCol<endCol) {
            for(int j=startCol; j<=endCol; j++) { result.add(matrix[startRow][j]) ; }
        }else if(startRow<endRow && startCol==endCol) {
            for(int i=startRow; i<=endRow; i++) { result.add(matrix[i][endCol]) ; }
        }else if(startRow==endRow && startCol==endCol) {
            result.add(matrix[startRow][startCol]) ;
        }else {
            return ;
        }

    }

    public static void main(String[] args) {
        int a[][]=new int[4][5];
        int num  = 0;
        for (int i = 0 ; i < 4; i++){
            for (int j = 0;j<5;j++){
                a[i][j]=++num;
            }
        }
        for (int j[] :a){
            for (int k:j)
            System.out.print(k+" ");
        }
        System.out.println();
        for (int  r : printMatrix(a)){
            System.out.print(r+ " ");
        }
    }


}
