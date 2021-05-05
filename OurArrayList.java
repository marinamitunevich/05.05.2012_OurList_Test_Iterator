package relran;

import java.util.Arrays;
import java.util.Iterator;

public class OurArrayList <E> implements OurList<E>{

    private static final int INITIAL_CAPACITY = 16;

    private int size;
    private Object[] source;

    public OurArrayList() {
        source = new Object[INITIAL_CAPACITY];
    }
    @Override
    public E get(int index) {
        sizeCheck(index);
        return (E) source[index];
    }
    void increaseCapacity() {
        int newCapacity = source.length * 2;
        Object[] newSource = new Object[newCapacity];
        System.arraycopy(source, 0, newSource, 0, source.length);
        source = newSource;
        //source = Arrays.copyOf(source,source.length*2);
    }

    @Override
    public void add(E elt) {
        if (size == source.length)
            increaseCapacity();

        source[size] = elt;
        size++;

    }

    @Override
    public E remove(int index) {

        sizeCheck(index);
        E oldValue = (E) source[index];
        int numMoved = size - index -1;
        if(numMoved > 0)
            System.arraycopy(source,index+1,source,index,numMoved);
        source[--size]= null;

        return oldValue;
    }

    private void sizeCheck(int index)  {

        if(index >= size || index < 0){
            throw  new IndexOutOfBoundsException("the index is out the list size.....");
        }
    }

    @Override
    public boolean remove(E elt) {

//        for(int i = 0; i<source.length; i++){
//            if((E)source[i] == elt) {
//                remove(i);
//                return true;
//            }
//    }
        int index = findIndexOfElement(elt);
        if(index == -1)
            return false;
        remove(index);
        return true;
        // return false;
        }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E set(int index, E elt) {

        sizeCheck(index);
        E oldValue = (E) source[index];
        source[index] =  elt;
        return oldValue;

    }
    private  int findIndexOfElement(E elt){
        if(elt == null) {
            for (int i = 0; i < size; i++) {
                if(source[i] == null)
                    return i;

            }
            return -1;
        }else {
            for (int i = 0; i < size; i++) {
                if(elt.equals(source[i]))
                    return i;

            }
            return  -1;
        }

    }

    @Override
    public boolean contains(E elt) {

//        for(int i = 0; i < source.length; i++){
//            if((E)source[i] == elt)
//                return true;
//        }
//        return false;
        return findIndexOfElement(elt) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new ForwardIterator<>((E[])source,this.size);
        return iterator;
    }
    private static class ForwardIterator<T> implements Iterator<T>{
        private int position;
        private T[] source;
        private int size ;
        ForwardIterator(T[] source, int size){
            this.source = source;
            this.position = 0;
            this.size = size;

        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public T next() {
            T a = source[position];
            position++;
            return a;
        }
    }
}
