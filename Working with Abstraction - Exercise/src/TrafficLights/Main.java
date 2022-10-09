package TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> signalsList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        List<TrafficLight> trafficLightList = new ArrayList<>();

        for (String signal : signalsList) {
            Colors currentSignal = Colors.valueOf(signal);

            TrafficLight trafficLight = new TrafficLight(currentSignal);
            trafficLightList.add(trafficLight);
        }

        int changeLightsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < changeLightsCount; i++) {

            for (TrafficLight trafficLight : trafficLightList) {
                trafficLight.changeColor();
                System.out.print(trafficLight.getCurrentColor() + " ");
            }
            System.out.println();
        }

    }
}
