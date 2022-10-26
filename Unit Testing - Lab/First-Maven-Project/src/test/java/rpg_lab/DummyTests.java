package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DummyTests {
    private Axe axe;
    private Dummy dummy;

    private final static int AXE_ATTACK = 20;
    private final static int AXE_ATTACK_DURABILITY = 10;
    private final static int DUMMY_HEALTH = 50;
    private final static int DUMMY_LOW_HEALTH = 1;
    private final static int DEAD_DUMMY_HEALTH = 0;
    private final static int DUMMY_EXPERIENCE = 50;
    private final static int DUMMY_HEALTH_AFTER_ATTACK = 30;


    @Before
    public void setUp(){
    axe = new Axe(AXE_ATTACK,AXE_ATTACK_DURABILITY);
    dummy = new Dummy(DUMMY_HEALTH,DUMMY_EXPERIENCE);
    }

    @Test
    public void looseHealthAfterAttackSuccess(){
        axe.attack(dummy);

        assertEquals("You hit the dummy",DUMMY_HEALTH_AFTER_ATTACK,dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void cantAttackDeadDummyThrowsException(){
        Dummy dummy = new Dummy(DEAD_DUMMY_HEALTH,DUMMY_EXPERIENCE);

        axe.attack(dummy);
    }

    @Test
    public void deadDummyGiveExpSuccess(){
        Dummy dummy = new Dummy(DUMMY_LOW_HEALTH,DUMMY_EXPERIENCE);

        axe.attack(dummy);

        assertEquals("You received exp!",DUMMY_EXPERIENCE,dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyDoesNotGiveXP(){
        axe.attack(dummy);

        dummy.giveExperience();
    }

}