

public class  HashMap<K, V> {

      private  K key;
      private  V val;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getVal() {
            return val;
        }

        public void setVal(V val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass().getName() != o.getClass().getName()) {
                return false;
            }
            HashMap e = (HashMap) o;
            if (this.key == e.key) {
                return true;
            }
            return false;
        }
    }

    class HashMapImpl<K, V> {
        private float loadfactor = 0.75f;
        private int capacity = 100;
        private int size = 0;
        private  HashMap<K, V> table[] = new  HashMap[capacity];

        private int Hashing(int hashCode) {
            int location = hashCode % capacity;
            System.out.println("Location:"+location);
            return location;
        }

        public int size() {
            return this.size;
        }

        public boolean isEmpty() {
            if(this.size == 0) {
                return true;
            }
            return false;
        }

        public V get(K key) {
            V ret = null;
            if(key == null) {
                HashMap<K, V> e = null;
                try{
                    e = table[0];
                }catch(NullPointerException ex) {

                }
                if(e != null) {
                    return (V) e.getVal();
                }
            } else {
                int location = Hashing(key.hashCode());
                HashMap<K, V> e = null;
                try{
                    e = table[location];
                }catch(NullPointerException ex) {

                }
                if(e!= null && e.getKey() == key) {
                    return (V)e.getVal();
                }
            }
            return ret;
        }

        public V put(K key, V val) {
            V ret = null;
            if (key == null) {
                ret = putForNullKey(val);
                return ret;
            } else {
                int location = Hashing(key.hashCode());
                if(location >= capacity) {
                    System.out.println("Rehashing required");
                    return null;
                }
                HashMap<K, V> e = null;
                try{
                    e = table[location];
                }catch(NullPointerException ex) {

                }
                if (e!= null && e.getKey() == key) {
                    ret = (V) e.getVal();
                } else {
                    HashMap<K, V> eNew = new  HashMap<K,V>();
                    eNew.setKey(key);
                    eNew.setVal(val);
                    table[location] = eNew;
                    size++;
                }
            }
            return ret;
        }

        private V putForNullKey(V val) {
            HashMap<K, V> e = null;
            try {
                e = table[0];
            }catch(NullPointerException ex) {

            }
            V ret = null;
            if (e != null && e.getKey() == null) {
                ret = (V) e.getVal();
                e.setVal(val);
                return ret;
            } else {
                HashMap<K, V> eNew = new  HashMap<K,V>();
                eNew.setKey(null);
                eNew.setVal(val);
                table[0] = eNew;
                size++;
            }
            return ret;
        }

        public V remove(K key) {
            int location = Hashing(key.hashCode());
            V ret = null;
            if(table[location].getKey() == key) {
                for(int i=location; i<table.length;i++) {
                    table[i] = table[i+1];
                }
            }
            return ret;
        }

        public void clear(){
            for(int i = 0; i < table.length; i++){
                table[i] = null;
                size = 0;
            }

        }


        }


