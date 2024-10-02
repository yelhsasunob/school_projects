
class DynamicArray<T> {
    private T[] array;
    private int count;
    private static int CAPACITY = 100;

    @SuppressWarnings("unchecked")
    public DynamicArray() {
        array = (T[]) new Object[CAPACITY];
        count = 0;
    }

    public void add(T element) {
        if (count == CAPACITY) {
            growSize();
        }
        array[count++] = element;
    }

    public void add(int index, T element) {
        if (index >= CAPACITY) {
            while (index >= CAPACITY) {
                growSize();
            }
        }
        if (index >= 0 && index < CAPACITY) {
            if (array[index] == null && element != null) {
                count++;
            } else if (array[index] != null && element == null) {
                count--;
            }
            array[index] = element;
        }
    }

    public T remove(int index) {
        if (index >= 0 && index < CAPACITY) {
            T removed = array[index];
            if (removed != null) {
                array[index] = null;
                count--;
            }
            return removed;
        }
        return null;
    }

    public T get(int index) {
        if (index >= 0 && index < CAPACITY) {
            return array[index];
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public void growSize() {
        T[] temp = (T[]) new Object[CAPACITY + 10];
        System.arraycopy(array, 0, temp, 0, CAPACITY);
        array = temp;
        CAPACITY += 10;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public static int capacity() {
        return CAPACITY;
    }
}
