package p01_Database;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
   private Database database;
   private final static Integer[] NUMBERS = {-5,2,18,29,69,73,9,27};

    @Before
    public void setUp() throws OperationNotSupportedException {
        Integer[] numbers = NUMBERS;
         database = new Database(numbers);
    }

    @Test
    public void createDatabaseTest() throws OperationNotSupportedException {
        Integer[] dbElements = database.getElements();

        Assert.assertEquals(NUMBERS.length,dbElements.length);

        for (int i = 0; i < NUMBERS.length; i++) {
        Assert.assertEquals(NUMBERS[i],dbElements[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithLessThan1Argument() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithMoreThan17Elements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        Database database = new Database(numbers);
    }

    @Test
    public void addElementSuccess() throws OperationNotSupportedException {
        Integer element = 10;
        database.add(element);

        Integer[]numbers = database.getElements();
        int lastNum = numbers[numbers.length-1];

        Assert.assertEquals(10,lastNum);
    }

    @Test(expected =  OperationNotSupportedException.class)
    public void cantAddNullToElements() throws OperationNotSupportedException {
     database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeWithNullElement() throws OperationNotSupportedException {
        Database database = new Database();
        database.remove();
    }

    @Test
    public void removeElementSuccess() throws OperationNotSupportedException {
        database.remove();
        Integer[] elements = database.getElements();
        int lastElement = elements[elements.length-1];

        Assert.assertEquals(9,lastElement);
    }

}