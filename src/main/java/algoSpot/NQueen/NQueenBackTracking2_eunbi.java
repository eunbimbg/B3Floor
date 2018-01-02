package algoSpot.NQueen;

/**
 * Created by Rounting_eunbi on 2017-12-04.
 */
public class NQueenBackTracking2_eunbi {
        public static int sum = 0;

        public static void main(String[] args) throws Exception {

            int N = 8;
            int[] board = new int[N];
//           initBoard(board, N);

            backTracking(board, N, 0);
            System.out.println("Total : " + sum);




        }

        public static void backTracking(int[] board, int n, int x) {
            if (x == n) {
                printBoard(board, n);
                sum++;
            } else {
                for (int y = 0; y < n; y++) {
                    if (check(board, n, x, y)) {
                        int[] newBoard = board.clone();
                        newBoard[x] = y;
                        backTracking(newBoard, n, x + 1);
                    }
                }
            }
        }


        // 이전것이 없는지 확인
        public static boolean check(int[] board, int n, int x, int y) {

            // \ check, / check, | check
            for (int i = 1; i <= x; i++) {
                if (board[x - i] - (y - i) ==0) {
                    return false;
                }
                if ( board[x - i]- (y + i) ==0) {
                    return false;
                }
                if (board[x-i]- y == 0) {
                    return false;
                }

            }
            return true;

        }

        public static String printBoard(int[] board, int n) {
            StringBuilder sb = new StringBuilder();
            sb.append("==========================\n");
            for (int x = 0; x < n; x++) {
                int y = board[x];
                for (int i=0; i< y; ) {
                    sb.append("0");

                }
                sb.append("1");
                sb.append("\n");
            }
            sb.append("==========================\n");
            System.out.println(sb.toString());
            return sb.toString();
        }

        public static void initBoard(int[] board, int n) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    board[x] = 0;
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


}
