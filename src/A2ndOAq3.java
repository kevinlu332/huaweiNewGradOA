import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A2ndOAq3 {
    // want: cover all the 0 (for only 1 time), and reach 2

    private static int helper(int[][] matrix, int row, int col) {
        int zeroAmount = getZeros(matrix);
        if(zeroAmount==0) return 0;
        int[] coorOf1 = getCoorOf1(matrix);
        if(coorOf1[0] == -1) return 0;
        int[] count = new int[]{0};

        zeroAmount++;
        matrix[coorOf1[0]][coorOf1[1]] = 0;

        dfs(matrix, row, col, coorOf1[0], coorOf1[1], zeroAmount, count);
        return count[0];
    }

    private static void dfs(int[][] matrix, int row, int col, int curRow, int curCol, int zeroAmount, int[] count){
        if(!isValid(matrix, curRow,curCol)){
            return;
        }
        if(matrix[curRow][curCol] == 2 && zeroAmount == 0){
            count[0]++;
            return;
        }else if(matrix[curRow][curCol] == 2) return;
        int val = matrix[curRow][curCol];
        matrix[curRow][curCol] = -1;

        zeroAmount--;
        dfs(matrix, row, col, curRow+1, curCol, zeroAmount, count);
        dfs(matrix, row, col, curRow-1, curCol, zeroAmount, count);
        dfs(matrix, row, col, curRow, curCol+1, zeroAmount, count);
        dfs(matrix, row, col, curRow, curCol-1, zeroAmount, count);
        zeroAmount++;

        matrix[curRow][curCol] = val;

    }

    private static boolean isValid(int[][] matrix, int row, int col){

        return row>=0 && row <matrix.length && col>=0 && col < matrix[0].length && matrix[row][col] != 1 && matrix[row][col] != -1;
    }

    private static int getZeros(int[][] matrix){
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0) count++;
            }
        }
        return count;
    }

    private static int[] getCoorOf1(int[][] matrix){
        int[] coor = new int[]{-1, -1};
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == 1) {
                    coor[0] = i;
                    coor[1] = j;
                    return coor;
                }
            }
        }
        return coor;
    }
    public static void main(String[] args) throws IOException {
        //read line by line:
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        line = reader.readLine();
        String[] s = line.split(" ");
        int row = Integer.parseInt(s[0]);
        int col = Integer.parseInt(s[1]);
        if(row == 0 || col == 0){
            System.out.println(0);
            return;
        }
        int[][] matrix = new int[row][col];
        for(int i = 0; i < row; i++){
            line = reader.readLine();
            String[] s2 = line.split(" ");
            for(int j = 0; j < col; j++){
                matrix[i][j] = Integer.parseInt(s2[j]);
            }
        }
//////////////////////////
//        int row = 3;
//        int col = 4;
//        int [][] matrix = new int[][]{
//                {1, 0, 0, 0},
//                {0, 0, 0, 0},
//                {0, 0, 2, -1}};
//////////////////////////////////
        int ans = helper(matrix, row, col);
        System.out.println(ans);
    }



}