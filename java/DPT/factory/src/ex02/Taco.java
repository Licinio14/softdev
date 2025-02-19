package ex02;

public abstract class Taco {
    protected String name;

    protected Taco(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void prepare();

    public abstract void bake();

    public abstract void box();
}
