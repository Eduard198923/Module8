


abstract class MyLinkedList<T>  {

    private Node<T> first;
    private Node<T> last;
    private int size=0;

    public void MyNodeList() {
        size = 0;
    }

    //добавляет элемент в конец

    public void add(T value) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(last, value,null);
        if (first == null){
            first = newNode;
            last = newNode;
        }
        last.next = newNode;
        last = newNode;
        size++;
    }

    //удаляет элемент под индексом

    public void remove(int index) {
        int mid = size/2;
        if (mid > index) {
            Node<T> node = first;
            for(int i=0; i< mid;i++){
                if(i == index){
                    node.next.prev = node.prev;
                    node.prev.next = node.next;
                    size--;
                }
                node = node.next;
            }
        }
        else if (index<size) {
            Node<T> node = last;
            for (int i = size - 1; i >= mid; i--) {
                if (i == index) {
                    node.next.prev = node.prev;
                    node.prev.next = node.next;
                    size--;
                }
                node = node.next;
            }
        }
    }

    //очищает коллекцию

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    //возвращает размер коллекции

    public int size() {
        return size;
    }

    //возвращает первый элемент в очереди (FIFO)

    public T peek(){
        return first.elem;
    }

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public String toString() {
        if(size == 0){
            return "[]";
        }
        String str = "[";
        Node<T> node = first;
        while (node != last){
            str = str + node.elem + ", ";
            node = node.next;
        }
        str = str + node.elem + "]";
        return str;
    }
}


class Node<T> {
    Node<T> prev;
    T elem;
    Node<T> next;

    public Node(Node<T> prev, T elem , Node<T> next){
        this.prev = prev;
        this.elem = elem;
        this.next = next;
    }

}
