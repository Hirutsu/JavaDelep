import java.util.Arrays;
import java.util.Iterator;

class DynamicArray<T> implements Iterable<T> {
    private Object[] array;
    public int length;
    public int capacity;

    public DynamicArray(int capacity)    {
        this.length = 0;
        this.capacity = capacity;
        this.array = new Object [capacity];
    }

    T get(int i) {
        @SuppressWarnings("unchecked")
        final T t = (T)array[i];
        return t;
    }

    public void set(T a)
    {
        if (length == capacity) {
            growSize();
        }
        array[length] = a;
        length++;
    }

    public void set(int i, T t) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        else {
            if (length + 1 >= capacity){
                growSize();
            }
            for(int index = length; index > i;--index){
                array[index] = array[index - 1];
            }
            array[i] = t;
            length++;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public void removeElementAt(int index)
    {
        if (length > 0)
        {
            for (int i = index; i < length - 1; i++)
            {
                array[i] = array[i + 1];
            }
            array[length - 1] = 0;
            length--;
        }
    }

    @Override
    public Iterator<T> iterator(){
        Iterator<T> it = new Iterator<T>() {

            private int curIndex = 0;
            @Override
            public boolean hasNext() {
                return curIndex <= length && array[curIndex] != null;
            }

            @Override
            public T next() {
                return (T) array[curIndex++];
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    public void growSize()
    {
        Object temp[] = null;
        if (length == capacity)
        {
            temp = new Object[capacity * 2];
            {
                for (int i = 0; i < length; i++)
                {
                    temp[i] = array[i];
                }
            }
        }
        array = temp;
        capacity= capacity * 2;
    }
}