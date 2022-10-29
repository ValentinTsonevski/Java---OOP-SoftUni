package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomLinkedListTest  {

    CustomLinkedList<String> customLinkedList;

    @Before
    public void setUp(){
        customLinkedList = new CustomLinkedList<>();
    }

    @Test
    public void addSuccess(){
        customLinkedList.add("Pesho");

        assertEquals("Pesho",customLinkedList.get(0));
    }

    @Test
    public void  addToNonEmptyListSuccess(){
        customLinkedList.add("Ivan");
        customLinkedList.add("Georgi");
        assertEquals("Georgi",customLinkedList.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMissingIndexShouldThrow(){
        customLinkedList.get(125);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getNegativeIndexShouldThrow(){
        customLinkedList.get(-125);
    }


    @Test(expected = IllegalArgumentException.class)
    public void setNegativeElementThrow(){
        customLinkedList.set(-10,"Pesho");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBigElementShouldThrow(){
        customLinkedList.set(100,"Pesho");
    }

    @Test
    public void SetSuccess(){
        customLinkedList.add("Teda");
        customLinkedList.add("Gosho");
        customLinkedList.add("Desa");

        customLinkedList.set(1,"Ivan");
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtNegativeIndexThrow(){
        customLinkedList.removeAt(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtBigIndexThrow(){
        customLinkedList.removeAt(150);
    }

    @Test
    public void removeAtSuccess(){
        customLinkedList.add("Gosho");
        customLinkedList.add("Tosho");
        customLinkedList.removeAt(1);
    }

    @Test
    public void removeSuccess(){
        customLinkedList.add("Gosho");
        customLinkedList.add("Tosho");

        customLinkedList.remove("Tosho");
    }

    @Test
    public void removeNonExistElement(){
        customLinkedList.remove("Ivan");
    }

    @Test
    public void IndexOfSuccess(){
        customLinkedList.add("Gosho");
        customLinkedList.add("Tosho");

        assertEquals(1,customLinkedList.indexOf("Tosho"));
    }

    @Test
    public void IndexOfFail(){
        customLinkedList.add("Gosho");
        customLinkedList.add("Tosho");

        assertEquals(-1,customLinkedList.indexOf("Ivan"));
    }

    @Test
    public void containSuccess(){
        customLinkedList.add("Gosho");
        assertTrue(customLinkedList.contains("Gosho"));
    }


}