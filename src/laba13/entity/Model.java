package laba13.entity;

public class Model {
    public int x, y, res;
    public String op;

    public Model() {}

    public Model(Model other) {
        this.x = other.x;
        this.y = other.y;
        this.op = other.op;
        this.res = other.res;
    }
}
