package algoSpot.NQueen;

/**
 * Created by eunbi on 2017-12-04.
 */
public class NQueenRecursion {
    public static int sum=0;

    public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        int N = 7;
        String[][] board = new String[N][N];
        initBoard(board, N);
        remove(board,N,2,3);
        printBoard(board,N);


    }
    public static void checkPoint(String[][] board, int n, int x){
        if(x==n){
//            printBoard(board,n);
            sum++;
        }else {
            for (int y = 0; y < n; y++) {
                if (board[x][y].equals("0")) {
                    String[][] newBoard = deepCopy(board, n);
                    remove(newBoard, n, x, y);
                    checkPoint(newBoard, n, x + 1);
                }

            }
        }
    }
    public static void remove(String[][] board,int n,int x, int y){


        //1. col remove
        for(int i=0;i<n;i++){
            board[x][i] = "x";
        }
        for(int i=0;i<n;i++){
            board[i][y] = "x";
        }
        //2. / remove
        int tempY = y;
        int tempX = x;
        while( tempX>=0 &&  tempY>=0 && tempY<n && tempX<n){
            board[tempX][tempY] = "x";
            tempY++;
            tempX--;
        }
        tempY = y;
        tempX = x;
        while( tempX>=0 &&  tempY>=0 && tempY<n && tempX<n){
            board[tempX][tempY] = "x";
            tempY--;
            tempX++;
        }

        //2. \ remove
        tempY = y;
        tempX = x;
        while( tempX>=0 &&  tempY>=0 && tempY<n && tempX<n){
            board[tempX][tempY] = "x";
            tempY++;
            tempX++;
        }
        tempY = y;
        tempX = x;
        while( tempX>=0 &&  tempY>=0 && tempY<n && tempX<n){
            board[tempX][tempY] = "x";
            tempY--;
            tempX--;
        }
        board[x][y] = "Q";


    }
    public static String printBoard(String[][] board, int n){
        StringBuilder sb = new StringBuilder();
        sb.append("==========================\n");
        for(int x=0;x<n;x++){
            for(int y = 0; y < n; y++) {
                sb.append(board[x][y]+" ");

            }

            sb.append("\n");
        }
        sb.append("==========================\n");
        System.out.println(sb.toString());
        return sb.toString();
    }
    public static void initBoard(String[][] board, int n){
        for(int x=0;x<n;x++){
            for(int y=0;y<n;y++){
                board[x][y] = "0";
            }
        }

    }
    public static String[][] deepCopy(String[][] original, int n) {
        if (original == null) {
            return null;
        }

        String[][] result = new String[n][n];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }





}
