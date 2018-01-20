package beak.josephus_1158;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eunbi on 2018-01-04.
 *
 * 7, 3 -> <3, 6, 2, 7, 5, 1, 4>
 */
public class Josephus_eunbi  {
    public static Queue queue = new LinkedList();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{

        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String readLine = br.readLine();
        String[] spl = readLine.split(" ");
        int N = Integer.parseInt(spl[0]);
        int M = Integer.parseInt(spl[1]);

        insert(N);
        josephus(M);

        System.out.println("<"+sb.substring(0, sb.length() - 2)+">");

    }
    public static void josephus(int num){
        int index=0;
        int value ;
        while(queue.size()>0){
            index = index % num;
            index++;
            value = Integer.parseInt(queue.poll().toString());
            if(index == num){
                sb.append(value).append(", ");
            }else{
                queue.offer(value);
            }

        }
    }
    public static void insert(int n){
        for(int i=1;i<=n;i++){
            queue.offer(i);
        }
    }



}
