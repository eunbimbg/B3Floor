package beak.beak9012;

/**
 * Created by mobizen on 2017-11-29.
 */
public class ArrayStack_eunbi {
    private int top;
    private int maxSize;
    private String[] array;

    public ArrayStack_eunbi(int maxSize) {
        this.top = -1;
        this.maxSize = maxSize;
        this.array = new String[maxSize];
    }

    // empty check
    private boolean empty(){
        return (top == -1);
    }

    // full check
    private boolean full(){
        return (top == maxSize-1);
    }

    // push
    public void push(String item){

        if(full()) System.out.println("Stack Full :"+(top+1)+">=" + maxSize);

        array[++top] = item;
    }


    // pop
    public String pop()throws Exception{

        if(empty()) throw new Exception("Stack Empty : top = "+top);
        String item = array[top];
        top--;

        return item;
    }


    public String checkVPS(String line){
        for (int i = 0; i < line.length(); i++) {
            try {
                String s = String.valueOf(line.charAt(i));
                if ("(".equals(s)) {
                    push(s);
                } else if (")".equals(s)) {
                    pop();
                }
            }catch (Exception e){
                return "NO";
            }
        }

        if(top == -1){
            return "YES";
        }else{
            return "NO";
        }
    }
}
