package WildFarm;

public class Tiger extends Felime{

    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food){
        if(food instanceof Meat){
            super.eat(food);
        }else{
            System.out.println("Tigers are not eating that type of food!");
        }
    }

    @Override
    public void makeSound(){
        System.out.println("ROAAR!!!");
    }

}
