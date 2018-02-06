package algoSpot.PICNIC;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by eunbi on 2018-02-05.
 * <p>
 * 안드로메다 유치원 익스프레스반에서는 다음 주에 율동공원으로 소풍을 갑니다. 원석 선생님은 소풍 때 학생들을 두 명씩 짝을 지어 행동하게 하려고 합니다.
 * 그런데 서로 친구가 아닌 학생들끼리 짝을 지어 주면 서로 싸우거나 같이 돌아다니지 않기 때문에, 항상 서로 친구인 학생들끼리만 짝을 지어 줘야 합니다.
 * <p>
 * 각 학생들의 쌍에 대해 이들이 서로 친구인지 여부가 주어질 때, 학생들을 짝지어줄 수 있는 방법의 수를 계산하는 프로그램을 작성하세요.
 * 짝이 되는 학생들이 일부만 다르더라도 다른 방법이라고 봅니다. 예를 들어 다음 두 가지 방법은 서로 다른 방법입니다.
 * <p>
 * (태연,제시카) (써니,티파니) (효연,유리)
 * (태연,제시카) (써니,유리) (효연,티파니)
 * <p>
 * 입력
 * 입력의 첫 줄에는 테스트 케이스의 수 C (C <= 50) 가 주어집니다.
 * 각 테스트 케이스의 첫 줄에는 학생의 수 n (2 <= n <= 10) 과 친구 쌍의 수 m (0 <= m <= n*(n-1)/2) 이 주어집니다.
 * 그 다음 줄에 m 개의 정수 쌍으로 서로 친구인 두 학생의 번호가 주어집니다. 번호는 모두 0 부터 n-1 사이의 정수이고,
 * 같은 쌍은 입력에 두 번 주어지지 않습니다. 학생들의 수는 짝수입니다.
 * <p>
 * 출력
 * 각 테스트 케이스마다 한 줄에 모든 학생을 친구끼리만 짝지어줄 수 있는 방법의 수를 출력합니다.
 */
public class PICNIC_EB_list {
    public static StringBuilder sb = new StringBuilder();
    public static Scanner sc = new Scanner(System.in);

    public static int C;
    public static int count;
    public static int N;
    public static int M;
    public static boolean[][] freindsMap;


    public static void main(String[] args)  throws Exception{

        C=sc.nextInt();
        for(int i=0;i<C;i++) {
            solve();
        }
        System.out.println(sb.toString());
        sc.close();
    }

    public static void solve()  throws Exception{

        N = sc.nextInt();
        M = sc.nextInt();

        count =0;
        boolean[] checkList = new boolean[N];
        for (int i = 0; i < N; i++) {
            checkList[i] = false;
        }
        initMap();

        for (int i = 0; i < M; i ++) {

            freindsMap[sc.nextInt()][sc.nextInt()]  = true;
        }
      //  print();
        picnic(checkList);
        sb.append(count).append("\n");

//        System.out.println(sb.toString());
    }
    public static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(freindsMap[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static void picnic(boolean[] checkList) {
        //다음 n을 찾음
        int n=0;
        while (n<N&&checkList[n]){
            n++;
        }
        //모두 true
        if(n==N) {
            count++;
            return;
        }

        boolean[] isfriend = freindsMap[n];
        for(int i=0;i<N;i++){
            if(isfriend[i] && !checkList[i]){
/*                boolean[] tempck = checkList.clone();

                tempck[i] = true;
                tempck[n] = true;*/

                checkList[i] = checkList[n] = true;
                picnic(checkList);
                checkList[i] = checkList[n] = false;
            }
        }




    }

    public static void initMap() {
        freindsMap = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                freindsMap[i][j] = false;

            }
        }
    }


}
