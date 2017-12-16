package algoSpot.Quantization;

import java.util.*;

/**
 * Created by mobizen on 2017-12-04.
 */
public class Quantization {
    /**
     * 력의 첫 줄에는 테스트 케이스의 수 C (1 <= C <= 50) 가 주어진다.
     * 각 테스트 케이스의 첫 줄에는 수열의 길이 N (1 <= N <= 100), 사용할 숫자의 수 S (1 <= S <= 10) 이 주어진다.
     * 그 다음 줄에 N개의 정수로 수열의 숫자들이 주어진다. 수열의 모든 수는 1000 이하의 자연수이다.
     **/

    //map <start, map<end, sum>
    static Map<Integer, Map<Integer, Integer>> resultMap = new HashMap<Integer, Map<Integer, Integer>>();

    public static void main(String[] args) throws Exception {
        //java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int n = 10;
        int s = 3;
        int[] list = {3, 3, 3, 1, 2, 3, 2, 2, 2, 1};

        Arrays.sort(list);

        Map<Integer, List<Integer>> dividList = new HashMap<Integer, List<Integer>>();

        List<Integer> integerList = new ArrayList<Integer>();

//        System.out.println(subListDiffSum(2, 5, list));

        System.out.println("*************"+calc(0, 3, n, list));

    }

    public static int calc(int start, int dividCount, int n, int[] list) {
        if (start == n) return 0;
        if (dividCount == 0) return 999999;


        if (resultMap.containsKey(start) && resultMap.get(start).containsKey(start+dividCount)) {
            System.out.println("  \t cache result : " + resultMap.get(start).get(start+dividCount));
            return resultMap.get(start).get(start+dividCount);
        } else {
            int minSum = 999999;

            for (int i = start + 1; i < n; i++) {
                // start, end,  list + 뒤 파티션즈
                for(int j =0;j<dividCount;j++) System.out.print("  ");

                System.out.print("dividCount : " + dividCount + " || start : " + start + " / end : " + i);
                int result = subListDiffSum(start,  i, list) + calc( i, dividCount - 1, n, list);

                if (result < minSum) {
                    minSum = result;
                }
                System.out.println("  \tresult : " + minSum);

            }

            return minSum;
        }
    }

    public static int subListDiffSum(int start, int end, int[] list) {
        if (resultMap.containsKey(start) && resultMap.get(start).containsKey(end)) {
            return resultMap.get(start).get(end);
        } else {
            int sum = 0;
          //  System.out.println(start+" / "+end);
            for (int i = start; i < end; i++) {
                sum += list[i];
            }

            int avg = (int) Math.round(sum / (end - start + 1.0));

            int diffSum = 0;

            for (int i = start; i < end; i++) {
                diffSum += Math.pow(list[i] - avg, 2);
            }
            // DP
            if (!resultMap.containsKey(start)) {
                Map<Integer, Integer> result = new HashMap<Integer, Integer>();
                result.put(end,diffSum);
                resultMap.put(start, result);
            } else if (!resultMap.get(start).containsKey(end)) {
                resultMap.get(start).put(end, diffSum);
            } else {
                System.out.println("무ㅓ지");
            }
            System.out.println("  diff result : " +diffSum);
            return diffSum;
        }
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
