
public class MyArrayList<T> {
        private static final int DEFAULT_LENGTH = 10;
        private static final Object[] EMPTY_ARRAY = {};
        private int size;
        private Object[] myArrayList;

        public MyArrayList() {
            this.size = 0;
            myArrayList = new Object[DEFAULT_LENGTH];
        }
        public MyArrayList(Integer length) {
            this.size = 0;
            if (length == 0) {
                myArrayList = EMPTY_ARRAY;
            }
            if (length > 0) {
                myArrayList = new Object[length];
            }
        }


        public void add(T value) {
            if(size == myArrayList.length) {
                Object[] newArr = new Object [myArrayList.length * 3 / 2 + 1];
                System.arraycopy(myArrayList, 0, newArr, 0, myArrayList.length);
                myArrayList = newArr;
            }
            myArrayList[size] = value;
            size++;
        }


        public void remove(int index) {
            if (index >= size){
                return;
            }
            Object[] newArr = new Object [myArrayList.length];
            System.arraycopy(myArrayList, 0, newArr, 0, index);
            // остальное сдвинуть на 1 влево
            System.arraycopy(myArrayList, index+1, newArr, index, size-index-1);
            size--;
            myArrayList = newArr;
        }


        public void clear() {
            myArrayList = new Object[DEFAULT_LENGTH];;
            size = 0;
        }


        public int size() {
            return size;
        }


        public T get(int index) {
            if(index >= size) {
                return null;
            }
            return (T) myArrayList[index];
        }


        public String toString() {
            String arr = "[";
            for(int i = 0; i < size; i++) {
                if(!arr.equals("[")) { arr+=", ";}
                arr += myArrayList[i];
            }
            arr+="]";
            return arr;
        }
    }
