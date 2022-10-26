package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {
    private final static int TARGET_EXP = 10;

    @Test
    public void gainExperienceSuccessDeadTarget(){

     Weapon mockWeapon = Mockito.mock(Weapon.class);
     Target mockTarget = Mockito.mock(Target.class);

     Mockito.when(mockTarget.isDead()).thenReturn(true);
     Mockito.when(mockTarget.giveExperience()).thenReturn(TARGET_EXP);

     Hero hero = new Hero("Warrior",mockWeapon);

     hero.attack(mockTarget);

        Assert.assertEquals(TARGET_EXP,hero.getExperience());
    }


}