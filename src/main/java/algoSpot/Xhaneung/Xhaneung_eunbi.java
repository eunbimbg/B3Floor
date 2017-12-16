package algoSpot.Xhaneung;


/**
 * Created by rounting_eunbi on 2017-12-11.
 * 입력의 첫 줄에는 채점을 해야 할 수식의 수 T가 입력된다. 각 수식은 한 줄에 입력되며 형식은 다음과 같다.
 * A operation B = C
 * 여기서 A, B, C는 영문 단어로 나타낸 수를 뜻하며, operation은 더하기(+), 빼기(-), 곱하기(*)가 들어온다.
 * A와 B를 구성하는 영문 단어는 0 이상 10 이하의 수를 나타내는 것으로써
 * 순서대로 zero, one, two, three, four, five, six, seven, eight, nine, ten 중 하나가 항상 올바르게 주어진다.
 * 반면 C의 경우 채점의 대상이므로 0부터 10까지의 수를 영문 단어로 표현한 것이 아닌 잘못된 문자열(예를 들어, 'hello')가 입력될 수 있다.
 * 그럼에도 불구하고 이 문자열은 항상 길이가 10을 넘지 않는 알파벳 소문자로만 구성된 문자열임이 보장된다.
 *
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Xhaneung_eunbi {
    static String[] numList = {"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));


        Map<String, Integer> numMap = initMap();


        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String line = br.readLine();
            try {
                String[] s = line.split(" ");
                String C = s[4];
                String result = calc(s[1], numMap.get(s[0]), numMap.get(s[2]));
                sb.append(anagram(C,result)).append('\n');

            }catch (Exception e){
                sb.append("No").append('\n');
            }

        }
        System.out.println(sb.toString());

    }

    public static Map<String, Integer> initMap (){
        Map<String, Integer> numMap = new HashMap<String, Integer>();
        numMap.put("zero",0);
        numMap.put("one",1);
        numMap.put("two",2);
        numMap.put("three",3);
        numMap.put("four",4);
        numMap.put("five",5);
        numMap.put("six",6);
        numMap.put("seven",7);
        numMap.put("eight",8);
        numMap.put("nine",9);
        numMap.put("ten", 10);

        return numMap;
    }
    public static String calc(String operation, int num1, int num2) throws Exception{
        int result;
        if("*".equals(operation)){
            result = num1*num2;
        }else if("+".equals(operation)){
            result = num1 + num2;
        }else if("-".equals(operation)){
            result = num1 - num2;
        }else {
            throw new Exception("No");
        }

        if(result<0 || result >10){
            throw new Exception("No");
        }
        return numList[result];
    }
    public static String anagram(String str1, String str2){
        if(str1.length() == str2.length()) {
            char[] chr1 = str1.toCharArray();
            char[] chr2 = str2.toCharArray();

            Arrays.sort(chr1);
            Arrays.sort(chr2);

            if (Arrays.equals(chr1, chr2)) return "Yes";
            else return "No";
        }
        return "No";
    }
}
