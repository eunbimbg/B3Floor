package beak.distSum_2042;

/**
 * Created by eunbi on 2018-01-05.
 *
 * 첫째 줄에 수의 개수 N(1<=N<=1,000,000)과 M(1<=M<=10,000), K(1<=k<=10,000) 가 주어진다.
 * M은 수의 변경이 일어나는 회수이고, K는 구간의 합을 구하는 회수이다.
 * 그리고 둘째 줄부터 N+1번째 줄까지 N개의 수가 주어진다.
 * 그리고 N+2번째 줄부터 N+M+K+1번째 줄까지 세 개의 정수 a,b,c가 주어지는데,
 * a가 1인 경우 b번째 수를 c로 바꾸고 a가 2인 경우에는 b번째 수부터 c번째 수까지의 합을 구하여 출력하면 된다.
 *
 */
public class eunbi {
    public static StringBuilder sb = new StringBuilder();
    public static double[] numList;
    public static void main(String[] args) throws Exception{

        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        String firstLine = br.readLine();
        String[] spl = firstLine.split(" ");

        int N = Integer.parseInt(spl[0]);
        int M = Integer.parseInt(spl[1]);
        int K = Integer.parseInt(spl[2]);


        numList = new double[N];
        for(int i=0;i<N;i++){
            numList[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0;i<M+K;i++){
            check(br.readLine());
        }

        System.out.println(sb.toString());

    }
    public static void print(){
        for(double s : numList){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void check(String line){
        String[] spl = line.split(" ");
        int b = Integer.parseInt(spl[1]);
        int c = Integer.parseInt(spl[2]);

        if(spl[0].equals("1")){
            change(b,c);
        }else if(spl[0].equals("2")){
            sb.append(sum(b, c)).append("\n");
        }else{
        }
    }

    public static void change(int b, int c){
//        System.out.println("===========================================");
//        print();
        numList[b-1] = c;
 //       print();
//        System.out.println("===========================================");
    }
    public static int sum(int b, int c){
        double sum=0;
        for(int i=b;i<=c;i++){
            sum += numList[i-1];
        }
        return (int)sum;
    }

}
