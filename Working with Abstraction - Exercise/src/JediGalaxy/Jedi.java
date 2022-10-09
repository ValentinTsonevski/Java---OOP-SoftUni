package JediGalaxy;

public class Jedi {

    public   long moveJedi( int jediRow, int jediCol,Field field) {
        long starsCollected = 0;

        while (jediRow >= 0 && jediCol < field.getColLength()) {
            if (field.isInGalaxy(jediRow, jediCol)) {
                starsCollected += field.getValue(jediRow,jediCol);
            }

            jediCol++;
            jediRow--;
        }
        return starsCollected;
    }
}
