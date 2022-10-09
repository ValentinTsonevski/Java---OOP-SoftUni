package JediGalaxy;

public class Field {
    private int[][] starsField;

    public Field(int rows,int cols) {
        this.starsField = new int[rows][cols];
        this.fillField(rows,cols);
    }

    public   void fillField(int rows, int cols) {
        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.starsField[i][j] = value++;
            }
        }
    }

    public   boolean isInGalaxy(int row, int col) {
        return row >= 0 && col >= 0 && row < this.starsField.length && col < this.starsField[row].length;
    }

    public int getValue(int row,int col){
        return this.starsField[row][col];
    }

    public void setValue(int row  , int col,int newValue){
        this.starsField[row][col] = newValue;
    }

    public int getColLength(){
       return this.starsField.length;
    }
}
