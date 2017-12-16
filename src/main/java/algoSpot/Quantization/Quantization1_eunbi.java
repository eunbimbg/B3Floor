package algoSpot.Quantization;

import java.util.*;

/**
 * Created by mobizen on 2017-12-04.
 */
public class Quantization1_eunbi {
    /**
     * 력의 첫 줄에는 테스트 케이스의 수 C (1 <= C <= 50) 가 주어진다.
     * 각 테스트 케이스의 첫 줄에는 수열의 길이 N (1 <= N <= 100), 사용할 숫자의 수 S (1 <= S <= 10) 이 주어진다.
     * 그 다음 줄에 N개의 정수로 수열의 숫자들이 주어진다. 수열의 모든 수는 1000 이하의 자연수이다.
     **/
    public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int c = Integer.parseInt(br.readLine());

        for(;c>0;c--){
            String[] spl = br.readLine().split(" ");
            int n = Integer.parseInt(spl[0]);
            int s = Integer.parseInt(spl[1]);
            sb.append(doDP(n, s, br.readLine())).append('\n');

        }


        System.out.println(sb.toString());

    }

    public static int doDP(int n, int s, String line){
//        int n = 10;
//        int s = 3;
        int[] list = new int[n];//{3, 3, 3, 1, 2, 3, 2, 2, 2, 1};

        String[] list2 = line.split(" ");
        for(int i=0;i<n;i++ ){
            list[i] = Integer.parseInt(list2[i]);
        }
        Arrays.sort(list);


        int[] avglist = new int[s];

        int sum = 0;
        int j =0;
        int k=0;
        for (int i = 1; i <= n; i++) {
            sum += list[i-1];
            k++;
            if (i % (n / s) == 0 && j<s-1) {
                avglist[j] = Math.round(sum / k);
                sum = 0;
                j++;
                k=0;
            }
        }
        avglist[j] = sum / k;

        int sum2 =0;
        for(int i : list) {
            int now =9999999;
            for (int avg : avglist) {
/*
            for(int i :dividList.get(avg)){
                sum2 += Math.pow(avg-i,2);
            }
*/
                int diff = (int) Math.pow(avg-i,2);
                if(diff < now){
                    now = diff;
                }

            }
            sum2+=now;
        }



        return sum2;

    }

    public static HashMap<Integer, List<Integer>> distributeListToSubList(int subListCount, List<Integer> targetList) {
        HashMap<Integer, List<Integer>> distributedList = new HashMap<Integer, List<Integer>>();

        if (subListCount == 0) {
            distributedList.put(0, new ArrayList<Integer>(targetList));
        } else {

            for (int i = 0; i < subListCount; i++) {
                distributedList.put(i, new ArrayList<Integer>());
            }

            int eachCapacity = targetList.size() / subListCount;

            int index = 0;
            for (int i = 0; i < targetList.size(); i++) {
                distributedList.get(index).add(targetList.get(i));

                if (index != distributedList.size() - 1) {
                    if (distributedList.get(index).size() == eachCapacity) {
                        index++;
                    }
                }

            }
        }
        return distributedList;
    }


}
