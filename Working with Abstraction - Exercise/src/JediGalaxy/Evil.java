package JediGalaxy;

public class Evil {
    public void moveEvil(int evilRow, int evilCol, Field field) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (field.isInGalaxy(evilRow, evilCol)) {
                field.setValue(evilRow, evilCol, 0);
            }
            evilRow--;
            evilCol--;
        }
    }
}