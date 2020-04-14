import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.*;

@RunWith(Parameterized.class)
public class PriorityQueueTest {
    private Object[] RandomArray;
    private Object[] CorrectArray;
    public PriorityQueueTest(Object []_RandomArray,Object []_CorrectArray){
        this.RandomArray = _RandomArray;
        this.CorrectArray = _CorrectArray;
    }
    @Parameters
    public static Collection testcase(){
        return Arrays.asList(new Object[][] {
                {new Object[] {-5}, new Object[] {-5}},
                {new Object[] {-1, 0, -68794, 15616}, new Object[] {-68794, -1, 0, 15616}},
                {new Object[] {100, 20, 65654, 1}, new Object[] {1, 20, 100, 65654}},
                {new Object[] {"100", "20", "65654", "1"}, new Object[] {"1", "100", "20", "65654"}},
                {new Object[] {"dio", "Dio", "Jotaro", "ZaWarudo", "wryyyyy"}, new Object[] {"Dio", "Jotaro", "ZaWarudo", "dio", "wryyyyy"}},
                {new Object[] {'c', 'C', 'X', 'a'}, new Object[] {'C', 'X', 'a', 'c'}}
        });
    }

    @Test
    public void Equal(){
        // System.out.println("hihi");
        PriorityQueue<Object> queue = new PriorityQueue<>();
        for(Object item: RandomArray){
            queue.add(item);
        }

        ArrayList<Object> OrderArray = new ArrayList<Object>();
        while(!queue.isEmpty()){
            OrderArray.add(queue.poll());
        }
        assertArrayEquals(OrderArray.toArray(), CorrectArray, "wrong ");
    }

    @Test
    public void testException_ClassCastException(){
        PriorityQueue<Object> queue = new PriorityQueue<>();
        Object[] str = new Object[] {"dio", "Dio", "Jotaro", "ZaWarudo", "wryyyyy"};
        Object number = 123;
        Exception exception = assertThrows(ClassCastException.class, ()->{
            queue.add(number);
            queue.add(str);
        });
    }

    @Test
    public void testException_NullPointerException(){
        Object tmp = null;
        PriorityQueue<Object> queue = new PriorityQueue<>();
        Exception exception = assertThrows(NullPointerException.class, ()->{
            queue.add(tmp);
        });
    }

    @Test
    public void testException_ArrayStoreException(){
        Exception exception = assertThrows(ArrayStoreException.class, ()->{
            PriorityQueue<Object> queue = new PriorityQueue<>();
            queue.add(1);
            queue.add(3);
            Character[] char_set = queue.toArray(new Character[0]);
            //Object tmp = queue.element();
        });
    }
}