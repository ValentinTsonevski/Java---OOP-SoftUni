package football;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class FootballTeamTest{
    private FootballTeam footballTeam;
    private FootballTeam footballTeam2;

    @Before
    public void setUp(){
        footballTeam = new FootballTeam("Madrid",5);
        footballTeam2 = new FootballTeam("Barselona",5);
    }

    @Test
    public void getNameSuccess(){
        Assert.assertEquals(footballTeam.getName(),"Madrid");
    }

    @Test(expected = NullPointerException.class)
    public void setEmptyNameThrowException(){
        FootballTeam footballTeam3 = new FootballTeam(null,5);
    }

    @Test
    public void getVacantPosition(){
        Assert.assertEquals(footballTeam.getVacantPositions(),5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVacantPositionUnder0Throw(){
        FootballTeam footballTeam3 = new FootballTeam("Chelsea",-1);
    }

    @Test
    public void getCount(){
        Footballer footballer = new Footballer("Ronaldo");
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(footballTeam.getCount(),1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addFootballerNoSpaceThrow(){
        FootballTeam footballTeam3 = new FootballTeam("Chelsea",1);
        Footballer footballer = new Footballer("Ronaldo");
        Footballer footballer2 = new Footballer("Messi");

        footballTeam3.addFootballer(footballer);
        footballTeam3.addFootballer(footballer2);
    }

    @Test
    public void removeFootballerSuccess(){
        Footballer footballer = new Footballer("Ronaldo");
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer("Ronaldo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeFootballerWrongNameThrow(){
        Footballer footballer = new Footballer("Ronaldo");
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer("Zlatan");
    }

    @Test
    public void footballerForSaleSuccess(){
        Footballer footballer = new Footballer("Ronaldo");
        footballTeam.addFootballer(footballer);

        Assert.assertEquals(footballTeam.footballerForSale("Ronaldo"),footballer);
        Assert.assertFalse(footballer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void footballerForSaleMissingThrow(){
        Footballer footballer = new Footballer("Ronaldo");
        footballTeam.addFootballer(footballer);

        footballTeam.footballerForSale("Messi");
    }

    @Test
    public void getStatistics(){
        Footballer footballer = new Footballer("Ronaldo");
        footballTeam.addFootballer(footballer);

        Assert.assertEquals("The footballer Ronaldo is in the team Madrid.",footballTeam.getStatistics());
    }


}