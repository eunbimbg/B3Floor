package other.kakao;

/**
 * Created by eunbi on 2018-01-12.
 */

public class Camping_EB {
    public static StringBuilder sb = new StringBuilder();
    public static java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
    public static java.util.Scanner sc = new java.util.Scanner(System.in);
    public static int C;
    public static int N;
    public static int M;
    public static int[][] data;
    public static void main(String[] args)throws Exception {
        solve();
    }

    public static void solve()throws Exception {
        N=4;
        data = new int[N][2];

//        String input ="[[0, 0], [1, 1], [0, 2], [2, 0]]";

        data[0] = new int[]{ 0, 0 };
        data[1] = new int[]{ 1, 1 } ;
        data[2] = new int[]{ 0, 2 };
        data[3] = new int[]{ 2, 0 };

        for(int i=0; i<N ;i++){
            for(int j=i+1; j<N ;j++){
                check(i,j);
            }
        }

    }
    public static void check(int num1, int num2){
        //쐐기1 좌표
        int num1x = data[num1][0];
        int num1y = data[num1][1];

        //쐐기2 좌표
        int num2x = data[num2][0];
        int num2y = data[num2][1];

        //넓이가 0인 케이스
        if(num1x == num2x || num1y == num2y){
            return ;
        }

        //안에 쐐기가 존재하는 케이스
        for(int i=0;i<N; i++){
            if(i !=num1 && i !=num2){
                int checkx= data[i][0];
                int checky= data[i][1];

                if((checkx-num1x ) * (checkx-num2x ) <0){
                    if((checky-num1y ) * (checky-num2y ) <0){
                        System.out.println("contain ( "+checkx+" , " +checky+" )");
                        return;
                    }

                }

            }
        }

        System.out.println("("+num1x+" , " +num1y+" ) / ("+num2x+" , " +num2y+" )");


    }
}

