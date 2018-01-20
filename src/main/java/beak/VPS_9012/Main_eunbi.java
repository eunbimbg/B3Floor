package beak.VPS_9012;

public class Main_eunbi {
    public static void main(String[] args) {
        String data = "(())())\n" +
                "(((()())()\n" +
                "(()())((()))\n" +
                "((()()(()))(((())))()\n" +
                "()()()()(()()())()\n" +
                "(()((())()(";

        System.out.println("Data : " + data);

        System.out.println("========================================");




        //java.util.Scanner scan = new java.util.Scanner(System.in);
        //int num = Integer.parseInt(scan.nextLine());

        StringBuilder sb = new StringBuilder();
        try {
            java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());
            for (int i = 0; i < num; i++) {
                String line = br.readLine();
                sb.append(checkVPS(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(sb.toString());

        for (String line : data.split("\n")) {

            System.out.println(checkVPS(line));
        }
    }


    public static String checkVPS(String line) {
        int num = 0;
        for (int i = 0; i < line.length(); i++) {
            String s = String.valueOf(line.charAt(i));
            if ("(".equals(s)) {
                num++;
            } else if (")".equals(s)) {
                num--;
                if (num < 0)
                    return "NO";
            }
        }

        if (num == 0) {
            return "YES";
        } else {
            return "NO";
        }

    }
}