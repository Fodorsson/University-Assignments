package elevens;

public class ArrayBag<T> {
    private T[] bag;
    private int numberOfEntries;

    public ArrayBag(int capacity) {
        bag = (T[]) new Object[capacity];
        numberOfEntries = 0;
    }

    public int getSize(){
        return numberOfEntries;
    }

    public void add(T newEntry){
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
    }

    public boolean removeAt(int index){
        if (index < numberOfEntries) {
            System.arraycopy(bag, index + 1, bag, index, numberOfEntries - index  - 1);
            numberOfEntries--;
            return true;
        }
        else return false;
    }
    
    public T elementAt(int index){
        return bag[index];
    }
    
    public void setElementAt(int index, T value){
        if (index <= numberOfEntries) {
            bag[index] = value;
        }
    }
    
}