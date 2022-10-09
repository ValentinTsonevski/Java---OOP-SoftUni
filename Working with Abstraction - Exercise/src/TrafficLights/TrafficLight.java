package TrafficLights;

public class TrafficLight {
    private Colors currentColor;

    public TrafficLight(Colors currentColor) {
        this.currentColor = currentColor;
    }

    public Colors getCurrentColor() {
        return currentColor;
    }

    public void changeColor() {

        switch (currentColor){
            case YELLOW :
            this.currentColor = Colors.RED;
                break;

            case GREEN:
                this.currentColor = Colors.YELLOW;
                break;

            case RED:
                this.currentColor = Colors.GREEN;
                break;
        }

    }

}
