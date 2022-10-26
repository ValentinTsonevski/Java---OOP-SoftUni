package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AxeTests {
    private  Axe axe;
    private  Dummy dummy;

    private final static int AXE_ATTACK_POWER = 10;
    private final static int AXE_ATTACK_DURABILITY = 10;
    private final static int DUMMY_HEALTH = 100;
    private final static int DUMMY_GIVE_EXPERIENCE = 50;
    private final static int AXE_BROKEN_DURABILITY = 0;

    @Before
    public void setUp(){
        axe = new Axe(AXE_ATTACK_POWER,AXE_ATTACK_DURABILITY);
        dummy = new Dummy(DUMMY_HEALTH,DUMMY_GIVE_EXPERIENCE);
    }

    @Test
    public void weaponAttackLosesDurabilitySuccessfully(){
        axe.attack(dummy);

        assertEquals("Success Attack",AXE_ATTACK_DURABILITY - 1,axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWepCantAttack(){
         axe = new Axe(AXE_ATTACK_POWER,AXE_BROKEN_DURABILITY);

        axe.attack(dummy);
    }
}
