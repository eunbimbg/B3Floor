package beak.beak10825_sort;

/**
 * Created by mobizen on 2017-11-29.
 */
public class Node{
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