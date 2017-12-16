package beak.beak10825;


public class MainArrayList_collectionSort {

    public static void main(String[] args) throws Exception {
        //java.util.List<Node> nodeVOList = new java.util.ArrayList<Node>();
        Node[] nodeVOList = new Node[12];
        StringBuilder sb = new StringBuilder();
        String data =
                "Junkyu 50 60 100\n" +
                        "Sangkeun 80 60 50\n" +
                        "Sunyoung 80 70 100\n" +
                        "Soong 50 60 90\n" +
                        "Haebin 50 60 100\n" +
                        "Kangsoo 60 80 100\n" +
                        "Donghyuk 80 60 100\n" +
                        "Sei 70 70 70\n" +
                        "Wonseob 70 70 90\n" +
                        "Sanghyun 70 70 80\n" +
                        "nsj 80 80 80\n" +
                        "Taewhan 50 60 90";

//        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
//        int count = Integer.parseInt(br.readLine());
        int i = 0;
        for (String line : data.split("\n")) {
            nodeVOList[i] = (new Node(line));
            i++;
        }

        //java.util.Collections.sort(nodeVOList, Node.comparator);
        java.util.Arrays.sort(nodeVOList);


        for (Node vo : nodeVOList) {
            sb.append(vo + "\n");
        }
        System.out.println(sb.toString());
    }

    public static class Node implements Comparable<Node> {
        // data
        String name;
        int korean;
        int english;
        int math;

        public Node(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        public Node(String line) {
            java.util.StringTokenizer st = new java.util.StringTokenizer(line, " ");
            this.name = st.nextToken();
            this.korean = Integer.parseInt(st.nextToken());
            this.english = Integer.parseInt(st.nextToken());
            this.math = Integer.parseInt(st.nextToken());
        }


        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", korea=" + korean +
                    ", english=" + english +
                    ", math=" + math +
                    '}';
        }

        private static java.util.Comparator<Node> comparator = new java.util.Comparator<Node>() {

            public int compare(Node node1, Node node2) {
                if (node1.korean > node2.korean) {
                    return -1;
                } else if (node1.korean == node2.korean) {
                    if (node1.english < node2.english) {
                        return -1;
                    } else if (node1.english == node2.english) {
                        if (node1.math > node2.math) {
                            return -1;
                        } else if (node1.math == node2.math) {
                            if (node1.name.compareTo(node2.name) < 0) return -1;
                            else return 1;
                        }
                    }
                }
                return 1;
            }
        };

        public int compareTo(Node node2) {
            if (this.korean == node2.korean && this.english == node2.english && this.math == node2.math) {

                return this.name.compareTo(node2.name);

            } else if (this.korean == node2.korean && this.english == node2.english) {

                return (node2.math - this.math);

            } else if (this.korean == node2.korean) {

                return (this.english - node2.english);

            } else {

                return (node2.korean - this.korean);
            }
        }
    }
}

