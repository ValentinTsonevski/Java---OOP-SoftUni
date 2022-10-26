package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Person person = new Person(10,"ivan");
    private static final Person person2 = new Person(101,"gosho");
    private static final Person person3 = new Person(20,"tosho");
    private  Person[] ELEMENTS = new Person[5];

    @Before
     public void setUp() throws OperationNotSupportedException {
        Person[] elements = ELEMENTS;
        database = new Database(elements);
    }

    @Test
    public void createDatabase() {
        Person[] dbElements = database.getElements();

        Assert.assertEquals(ELEMENTS.length,dbElements.length);

        Assert.assertArrayEquals(ELEMENTS,dbElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithLessThan1Argument() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithMoreThan17Elements() throws OperationNotSupportedException {
        Person[] elements = new Person[17];
        Database database = new Database(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addUsersWithSameIdShouldThrow() throws OperationNotSupportedException {
        Person person2 = new Person(10,"georgi");

        Database database = new Database();
        database.add(person);
        database.add(person2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addUsersWithNegativeOrNullIdThrow() throws OperationNotSupportedException {
        Person person = new Person(-10,"georgi");
        Database database = new Database();
        database.add(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeFromEmptyDatabaseThrow() throws OperationNotSupportedException {
        Database database = new Database();
        database.remove();
    }

    @Test
    public void removeSuccess() throws OperationNotSupportedException {
        database.add(person);
        database.add(person2);
        database.remove();

        Person[] buffer = database.getElements();
        Person person4 = buffer[0];

        Assert.assertEquals(person,person4);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void incorrectUsernameThrow() throws OperationNotSupportedException {
        Database database = new Database();
        database.add(person);

        String incorrectUsername = "asd";
        String correctUsername = person.getUsername();

        Assert.assertEquals("Incorrect name",correctUsername,incorrectUsername);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findPersonWithNullNameThrow() throws OperationNotSupportedException {
        Person person = new Person(10,null);
        database.add(person);

        String incorrectName = person.getUsername();
        database.findByUsername(incorrectName);

    }
    @Test
    public void findPersonByNameSuccess() throws OperationNotSupportedException {
        database.add(person);
        String usernameLookingFor = "ivan";

        Assert.assertEquals(usernameLookingFor,person.getUsername());
    }

    @Test
    public void allNamesCaseSensitiveSuccess() throws OperationNotSupportedException {
        database.add(person);
        database.add(person2);
        database.add(person3);

        Assert.assertEquals("ivan",person.getUsername());
        Assert.assertEquals("gosho",person2.getUsername());
        Assert.assertEquals("tosho",person3.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void idIsNotPresentShouldThrow() throws OperationNotSupportedException {
        Database database = new Database();
        database.add(person);

        int idLookingFor = 9;

        Assert.assertEquals("Id is not present",person.getId(),idLookingFor);
    }

    @Test
    public void findByIdSuccess() throws OperationNotSupportedException {
        int idLookingFor = 10;

        Assert.assertEquals(person.getId(),idLookingFor);
        database.add(person);
    }

}