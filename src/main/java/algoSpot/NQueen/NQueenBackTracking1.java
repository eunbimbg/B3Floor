package algoSpot.NQueen;

/**
 * Created by eunbi on 2017-12-04.
 */
public class NQueenBackTracking1 {
    public static int sum = 0;

    public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        for(;num>0;num--) {
            sum = 0;
            int N = Integer.parseInt(br.readLine());
            int[][] board = new int[N][N];
            initBoard(board, N);

            backTracking(board, N, 0);
            System.out.println(sum);
        }

    }

    public static void backTracking(int[][] board, int n, int x) {
        if (x == n) {
            printBoard(board, n);
            sum++;
        } else {
            for (int y = 0; y < n; y++) {
                if (check(board, n, x, y)) {
                    int[][] newBoard = deepCopy(board, n);
                    newBoard[x][y] = 1;
                    backTracking(newBoard, n, x + 1);
                }
            }
        }
    }


    // 이전것이 없는지 확인
    public static boolean check(int[][] board, int n, int x, int y) {

        // \ check, / check, | check
        for (int i = 1; i <= x; i++) {
            if (x-i>=0 && y-i>=0 && board[x - i][y - i] == 1) {
                return false;
            }
            if (x-i>=0 && y+i<n && board[x - i][y + i] ==1) {
                return false;
            }
            if (x-i>=0 && board[x-i][y] ==1) {
                return false;
            }

        }
        return true;

    }


    public static void initBoard(int[][] board, int n) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                board[x][y] = 0;
            }
        }

    }

    public static int[][] deepCopy(int[][] original, int n) {
        if (original == null) {
            return null;
        }

        int[][] result = new int[n][n];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }


    public static String printBoard(int[][] board, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("==========================\n");
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                sb.append(board[x][y] + " ");

            }

            sb.append("\n");
        }
        sb.append("==========================\n");
        System.out.println(sb.toString());
        return sb.toString();
    }
}
