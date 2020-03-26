import java.util.Random;

public class shape {
    private tetrominoes currShape;
    private int[][] coordinates;

    public shape() {
        coordinates = new int[4][2];
        setCurrShape(tetrominoes.NoShape);
    }

    public void setCurrShape(tetrominoes shape) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                coordinates[i][j] = shape.coordinate[i][j];
            }
        }

        currShape = shape;
    }

    public tetrominoes getCurrShape() {
        return currShape;
    }

    public void setRandomShape() {
        Random r = new Random();
        tetrominoes[] shapes = tetrominoes.values();
        setCurrShape(shapes[Math.abs(r.nextInt(7)) + 1]);
    }

    public int getX(int i) {
        return coordinates[i][0];
    }
    public int getY(int i) {
        return coordinates[i][1];
    }
    public void setX(int i, int value) {
        coordinates[i][0] = value;
    }
    public void setY(int i, int value) {
        coordinates[i][1] = value;
    }

    public shape rotateLeft() {
        if (currShape == tetrominoes.OShape) return this;
        shape newShape = new shape();
        newShape.currShape = currShape;

        for (int i = 0; i < 4; i++) {
            newShape.setX(i, getY(i));
            newShape.setY(i, -getX(i));
        }

        return newShape;
    }

    public shape rotateRight() {
        if (currShape == tetrominoes.OShape) return this;
        shape newShape = new shape();
        newShape.currShape = currShape;

        for (int i = 0; i < 4; i++) {
            newShape.setX(i, -getY(i));
            newShape.setY(i, getX(i));
        }

        return newShape;
    }
}
