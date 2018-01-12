package algoSpot.Huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by eunbi on 2018-01-12.
 * https://algospot.com/judge/problem/read/KHUFFMAN
 * <p>
 * 입력은 T개의 테스트 케이스로 구성된다. 입력의 첫 줄에는 T가 주어진다.
 * 각 테스트 케이스 첫 줄에는 두 정수 N (2 <= N <= 10000),
 * K (2 <= K <= 10000)가 공백으로 구분되어 주어진다.
 * <p>
 * N은 Huffman 나라의 문자의 수이고 K는 인코딩할 진법을 나타낸다.
 * 다음 줄에는 각 문자가 문자열에 몇 번이나 나타나는지를 의미하는 N 개의 정수 Ci (0 <= Ci <= 100000) 가 공백으로 구분되어 주어진다.
 */
public class Huffman_EB_binary {
    public static StringBuilder sb = new StringBuilder();
    public static java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
    public static int N;
    public static int K;

    //   public static List<Integer> useList;
    public static List<Tree> useTree;
    public static Tree resultTree;
    public static String[] resultList;
    public static int count =0;

    public static void main(String[] args) {
        N = 4;
        K = 2;
        String input = "0 1 2 3";
        String input2 = "0 1 2 2";

        solve();

    }

    public static void solve() {
        N = 4;
        K = 2;
        String input = "0 1 2 3";

        initList(input);
        getList(resultTree, "");

        System.out.println("count : " + count);
    }

    public static void getList(Tree currentTree, String val) {
        if (currentTree.left != null) {
            getList(currentTree.left, val + "0");
        }
        if (currentTree.right != null) {
            getList(currentTree.right, val + "1");
        }
        if (currentTree.left == null&&currentTree.right == null) {

            System.out.println(val+ " / sum : "+currentTree.sum);
            count = count+val.length()*currentTree.sum;
        }
    }
    public static void initList(String input) {
        //       useList = new ArrayList<Integer>();
        useTree = new ArrayList<Tree>();
        count =0;
//        resultList = new String[N];

        for (String s : input.split(" ")) {
            int num = Integer.parseInt(s);
            //if (num != 0)
                //             useList.add(num);
                useTree.add(new Tree(num));

        }

        resultList = new String[useTree.size()];

        sortList();
        System.out.println("===================");
        System.out.println(useTree);
        System.out.println("===================");
        setTree();
    }

    public static void sortList() {
        //      Collections.sort(useList, Collections.reverseOrder());
        Collections.sort(useTree, new Comparator<Tree>() {
            @Override
            public int compare(Tree o1, Tree o2) {
                return o2.sum - o1.sum;
            }
        });

    }

    public static void setTree() {

        if (useTree.size() == 2) {
            resultTree = new Tree();
            resultTree.left = useTree.get(useTree.size() - 1);
            resultTree.right = useTree.get(useTree.size() - 2);
            resultTree.sum = useTree.get(useTree.size() - 2).sum + useTree.get(useTree.size() - 1).sum;

            System.out.println(resultTree);

            return;

        } else {
            Tree newTree = new Tree();
            newTree.left = useTree.get(useTree.size() - 1);
            newTree.right = useTree.get(useTree.size() - 2);
            newTree.sum = useTree.get(useTree.size() - 2).sum + useTree.get(useTree.size() - 1).sum;

            useTree = useTree.subList(0, useTree.size() - 2);
            useTree.add(newTree);

//            useTree.remove(useList.size() - 1 -count);
//            useTree.remove(useList.size() - 2 -count);

            sortList();
            setTree();
        }

    }

    public static class Tree {
        Tree left;  //0
        Tree right; //1
        int sum;

        public Tree() {
        }

        public Tree(int sum) {
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "sum=" + sum +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
