package homework8.homework8Three;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>(10);
        queue.add("10");
        queue.add("4");
        queue.add("5");
        System.out.println(queue.size());
        queue.remove();
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        queue.clear();
        System.out.println(queue.size());





    }

}
