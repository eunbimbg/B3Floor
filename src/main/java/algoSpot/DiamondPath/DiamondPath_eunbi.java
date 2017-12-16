package algoSpot.DiamondPath;

/**
 * Created by rounting_eunbi on 2017-12-11.
 * 입력의 첫 줄에는 테스트 케이스의 수 C (1 <= C <= 100) 가 주어진다.
 * 각 테스트 케이스의 첫 줄에는 다이아몬드 가운데 줄의 가로 길이 N (1 <= N <= 100) 이 주어진다.
 * 그 후 2*N-1 줄에, 맨 윗 줄부터, 다이아몬드의 각 가로줄에 속한 숫자가 왼쪽부터 순서대로 주어진다.
 * 각 수는 100 이하의 자연수라고 가정해도 좋다.
 */
public class DiamondPath_eunbi {

    static  int[][] resultBoard;
    static int[][] board;
    static int N;
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        for(;num>0;num--){

            N = Integer.parseInt(br.readLine());
        //    System.out.println("N : " + N);
            resultBoard = new int[2*N-1][N];
            board = new int[2*N-1][N];


            for(int x=0;x<2*N-1;x++){

                doDP(x,br.readLine());
            }
            sb.append(resultBoard[2*N-2][0]).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static String printBoard(int[][] board, int n){
        StringBuilder sb = new StringBuilder();
        sb.append("==========================\n");
        for(int x=0;x<2*n-1;x++){
            for(int y = 0; y < n; y++) {
                sb.append(board[x][y]+" ");
            }
            sb.append("\n");
        }
        sb.append("==========================\n");
        System.out.println(sb.toString());
        return sb.toString();
    }
    public static void doDP(int x, String line){
        if(x==2*N-1) return ;

        if(x==0) {
            resultBoard[0][0] = Integer.parseInt(line);
        }else {
            int result;

            int beforeNum;
            int afterNum;
            int y = 0;
            for(String s : line.split(" ")) {
                if (x < N) {
                    beforeNum = y-1;
                    afterNum = y;
                } else {
                    beforeNum = y;
                    afterNum = y + 1;
                }

                if (beforeNum < 0) result = resultBoard[x - 1][afterNum] + Integer.parseInt(s);
                else if (afterNum >= N) result = resultBoard[x - 1][beforeNum] + Integer.parseInt(s);
                else {
                  //  System.out.println(x+" / "+beforeNum+" / "+afterNum);
                    result = Math.max(resultBoard[x - 1][beforeNum],resultBoard[x - 1][afterNum]) + Integer.parseInt(s);
                }
                resultBoard[x][y] = result;
                y++;
            }
        }
    }
}
