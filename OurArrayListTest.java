package relran;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OurArrayListTest {
    OurArrayList<Integer> integer = new OurArrayList<>();
    Integer [] array = {2,4,6,-6,10};

    @Test
    public void testSize_newList(){
        assertEquals(0,integer.size());
    }

    @Test
    void testGet() {
        for(int a : array){
            integer.add(a);
        }
        int a = array[1];
        assertEquals(a,integer.get(1));

    }


    @Test
    void testAddAndGet_severalElements() {
        integer.add(-7);
        integer.add(-17);
        integer.add(-5);
        assertEquals(3, integer.size());
        assertEquals(-7,integer.get(0));
        assertEquals(-17,integer.get(1));
        assertEquals(5,integer.get(2));


    }
    @Test
    void testAdd_null(){
        for(int a : array){
            integer.add(a);
        }
        integer.add(null);
        assertTrue(integer.contains(null));

    }
    @Test
    void testAdd_mitEmptiness(){
        OurArrayList<String> string = new OurArrayList<>();
        String test = "";
        string.add(test);
        assertTrue(string.contains(test));
    }

    @Test
    public void test_throwsIOOBE_inRemoveGetSetMethod(){
        for(int a : array){
            integer.add(a);
        }
        assertThrows(IndexOutOfBoundsException.class,()->{integer.get(-3);});
        assertThrows(IndexOutOfBoundsException.class,()->{integer.get(integer.size()+2);});
        assertThrows(IndexOutOfBoundsException.class,()->{integer.set(integer.size()+2,9);});
        assertThrows(IndexOutOfBoundsException.class,()->{integer.set(-3,9);});
        assertThrows(IndexOutOfBoundsException.class,()->{integer.remove(-100);});
        assertThrows(IndexOutOfBoundsException.class,()->{integer.remove(integer.size()+2);});
        try{
          integer.get(-3);
          fail();
        }catch (IndexOutOfBoundsException e){
            assertTrue(true);
        }
    }

    @Test
    void testRemove_mitIndex() {
        for(int a : array){
            integer.add(a);
        }
        int elm = integer.get(0);
        assertEquals(elm,integer.remove(0));
        assertEquals(array.length-1,integer.size());
        assertFalse(integer.contains(elm));
    }

    @Test
    void testRemove_firstElementAndLastElement() {
        for(int a : array){
            integer.add(a);
        }
        Integer elm = integer.get(array.length-1);
        assertTrue(integer.remove(elm));
        assertEquals(array.length-1,integer.size());
        assertFalse(integer.contains(elm));

        Integer elm2 = integer.get(0);
        assertTrue(integer.remove(elm2));
        assertEquals(array.length-2,integer.size());
        assertFalse(integer.contains(elm2));

    }

    @Test
    void testSet() {
        for(int a : array){
            integer.add(a);
        }
        Integer oldElement = integer.get(0);
        Integer newElement = 100;
        assertEquals(oldElement,integer.set(0,newElement));
        assertFalse(integer.contains(oldElement));
    }
}