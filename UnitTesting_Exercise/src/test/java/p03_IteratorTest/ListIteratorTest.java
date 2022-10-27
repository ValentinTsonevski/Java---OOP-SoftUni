package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class ListIteratorTest {

    private ListIterator listIterator;
    private String[] NAMES = {"Miro","Marin","Martin","Ivan"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test(expected =  OperationNotSupportedException.class)
    public void CreateConstructorShouldThrow() throws OperationNotSupportedException {
      new ListIterator(null);
    }

   @Test
    public void hasNextSuccess(){
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
       Assert.assertTrue(listIterator.hasNext());
       listIterator.move();
       Assert.assertTrue(listIterator.hasNext());
       listIterator.move();
       Assert.assertFalse(listIterator.hasNext());
       listIterator.move();
   }
   @Test
    public void moveSuccess(){
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
   }

   @Test(expected =  IllegalStateException.class)
    public void printEmptyListShouldThrow() throws OperationNotSupportedException {
    ListIterator listIterator = new ListIterator();
    listIterator.print();

   }

   @Test
    public void printSuccess(){
        int index = 0;
        while (listIterator.hasNext()){
            Assert.assertEquals(NAMES[index],listIterator.print());
            index++;
            listIterator.move();
        }
   }


}