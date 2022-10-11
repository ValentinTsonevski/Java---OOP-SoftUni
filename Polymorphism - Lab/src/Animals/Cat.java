package Animals;

public class Cat extends Animal{
    private String name;
    private String favouriteFood;

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s MEEOW",name,favouriteFood);
    }
}
