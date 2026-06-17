import java.util.Random;

public class SmartRainAlertSystem {

    public static void main(String[] args) {

    
        Random random = new Random();

        int humidity = random.nextInt(61) + 40;      // 40-100%
        int temperature = random.nextInt(21) + 20;   // 20-40°C

        int rainProbability;

    
        if (humidity >= 85) {
            rainProbability = 90;
        } else if (humidity >= 70) {
            rainProbability = 70;
        } else if (humidity >= 55) {
            rainProbability = 50;
        } else {
            rainProbability = 20;
        }

        String color;
        String message;

        
        if (rainProbability >= 80) {
            color = "PURPLE";
            message = "Heavy Rain! Stay Indoors";
        } else if (rainProbability >= 60) {
            color = "RED";
            message = "Heavy Rain Expected";
        } else if (rainProbability >= 30) {
            color = "ORANGE";
            message = "Carry an Umbrella";
        } else {
            color = "GREEN";
            message = "Weather is Clear";
        }

        
        System.out.println("=================================");
        System.out.println(" SMART RAIN ALERT WATCH SYSTEM");
        System.out.println("=================================");
        System.out.println("Humidity        : " + humidity + "%");
        System.out.println("Temperature     : " + temperature + " °C");
        System.out.println("Rain Probability: " + rainProbability + "%");
        System.out.println("Watch Color     : " + color);
        System.out.println("Alert Message   : " + message);

        
        if (rainProbability >= 80) {
            System.out.println("Watch Action    : Vibrate every 5 minutes");
        } else if (rainProbability >= 60) {
            System.out.println("Watch Action    : Vibrate every 10 minutes");
        } else {
            System.out.println("Watch Action    : No vibration needed");
        }

        System.out.println("=================================");
    }
}