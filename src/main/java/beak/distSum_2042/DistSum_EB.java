package beak.distSum_2042;

/**
 * Created by eunbi on 2018-01-06.
 */
public class DistSum_EB {
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
