package beak.beak10825;

public class MainLinkedList_EB {
    public static Node head = null;
    public static Node tail = null;

    public static void main(String[] args) throws Exception {
        head = new Node();
        java.util.List<Node> nodeVOList = new java.util.ArrayList<Node>();
        StringBuilder sb = new StringBuilder();
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (;count>0;count--) {
            Node currentNode = new Node(br.readLine());
            insertNode(currentNode);

        }
        for(Node vo : nodeVOList){
            sb.append(vo.getName()+"\n");
        }
        System.out.println(sb.toString());

    }


    public static void insertNode(Node currentNode) {
        Node beforeNode = head.getNextNode();

        // head 지정
        if (beforeNode == null) {
            head.setNextNode(currentNode);
            return;

            //2번째 것 : head 인지 아닌지?
        } else if (beforeNode.getNextNode() == null) {
            if (compare(beforeNode, currentNode)) {
                currentNode.setNextNode(beforeNode);
                head.setNextNode(currentNode);
                return;
            }
        }




        // 비교
        while(beforeNode.getNextNode() != null){
            if (compare(beforeNode.getNextNode(), currentNode)) {
                currentNode.setNextNode(beforeNode.getNextNode());
                beforeNode.setNextNode(currentNode);
                return;
            }
            beforeNode = beforeNode.getNextNode();
        }
        if (compare(beforeNode, currentNode)) {
            currentNode.setNextNode(beforeNode);
        }else {
            beforeNode.setNextNode(currentNode);
        }

    }

    public static boolean compare(Node nextNode, Node currentNode) {
        if (nextNode.getKorea() < currentNode.getKorea()) {
            return true;
        } else if (nextNode.getKorea() == currentNode.getKorea()) {
            if (nextNode.getEnglish() > currentNode.getEnglish()) {
                return true;
            } else if (nextNode.getEnglish() == currentNode.getEnglish()) {
                if (nextNode.getMath() < currentNode.getMath()) {
                    return true;
                } else if (nextNode.getMath() == currentNode.getMath()) {
                    if (nextNode.getName().compareTo(currentNode.getName()) > 0) return true;
                    else return false;
                }
            }
        }
        return false;
    }

    public static class Node{
        // data
        private String name;
        private int korea;
        private int english;
        private int math;

        // Next
        private Node nextNode;
        public Node(){

        }

        public Node(String name, int korea, int english, int math) {
            this.name = name;
            this.korea = korea;
            this.english = english;
            this.math = math;
        }
        public Node(String line) {
            String[] spl = line.split(" ");
            this.name = spl[0];
            this.korea = Integer.parseInt(spl[1]);
            this.english = Integer.parseInt(spl[2]);
            this.math = Integer.parseInt(spl[3]);
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", korea=" + korea +
                    ", english=" + english +
                    ", math=" + math +
                    '}';
        }

        public int getKorea() {
            return korea;
        }

        public int getEnglish() {
            return english;
        }

        public int getMath() {
            return math;
        }

        public String getName() {
            return name;
        }
    }

}