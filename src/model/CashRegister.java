package model;

import java.time.LocalTime;
import java.util.LinkedList;

public class CashRegister {
    LinkedList<Car> carsRow = new LinkedList<Car>();
    private LocalTime timeArrival = LocalTime.of(5, 00);
    private int serviceTime = 1080;
    private int workTime = 0;

    public String simulate() {
        return "" + LocalTime.of(8, 00);
    }

    public int generateRandomMinutes(String condition) {
        // El tiempo es contado en minutos
        int time = 0;
        switch (condition) {
            case "llegadaCarros":
                time = (int) (Math.random() * (35 - 10)) + 10;
                break;
            case "permanenciaCarro":
                time = (int) (Math.random() * (360 - 60)) + 60;
                break;
            default:
                return 0;
        }
        return time;
    }

    public LinkedList<Car> carsArrival() {
        while (workTime < serviceTime) {
            int randomArrival = this.generateRandomMinutes("llegadaCarros");
            workTime += randomArrival;
            timeArrival = timeArrival.plusMinutes(randomArrival);
            Car car = new Car(((int) Math.random() * 150), timeArrival);
            carsRow.add(car);
        }
        return carsRow;
    }

    public LinkedList<Car> carPermanence(LinkedList<Car> cars) {
        int iCounter = 0;
        timeArrival = LocalTime.of(5, 00);
        workTime = 0;
        while (workTime < serviceTime) {
            int randomPermanence = this.generateRandomMinutes("permanenciaCarro");
            workTime += randomPermanence;
            timeArrival = timeArrival.plusMinutes(randomPermanence);
            cars.get(iCounter).setCheckOut(timeArrival);
            System.out.println(cars.get(iCounter).getCheckOut());
            // cars.get(iCounter).getCheckOut().minusMinutes(randomPermanence);
            iCounter++;
        }
        return carsRow;
    }
}
