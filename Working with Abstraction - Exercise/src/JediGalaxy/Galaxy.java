package JediGalaxy;

public class Galaxy {
    private Field field;
    private Jedi jedi;
    private Evil evil;

    public Galaxy(Field field) {
        this.field = field;
        this.jedi = new Jedi();
        this.evil = new Evil();
    }

    public void moveEvil(int evilRow, int evilCol) {
        evil.moveEvil(evilRow,evilCol,this.field);
    }

    public long moveJedi(int row, int col) {
        return jedi.moveJedi(row, col, this.field);
    }

}
