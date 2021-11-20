

public class Stack<T> {
    private int size;
    private int[] array;
    private int top;

    public Stack(int s){
        size =s;
        array = new int[size];
        top = -1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public void push(int a){
        int i = ++top;
        array[i] = a;

    }

    public int pop(){
       return array[top--];
    }

    public int peek(){
        return array[top];
    }

    public int size(){
        return size;
    }

    public void clear(){
        for(int i =0; i < array.length; i++){
            array[i] = Integer.parseInt(null);
        }

    }

}
