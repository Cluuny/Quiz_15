package model;

import java.time.LocalTime;
import java.util.LinkedList;

public class CashRegister {
    LinkedList<Car> carsRow = new LinkedList<Car>();
    LinkedList<Car> carsExit = new LinkedList<Car>();
    private LocalTime timeArrival = LocalTime.of(5, 00);
    private int serviceTime = 1080;
    private int workTime = 0;

    public String simulate(int totalAttendance) {
        return "Cantidad de carros antendidos: " + totalAttendance + "\n" + "El tiempo promedio de permanencia en el parqueadero fue de: " + averageMinutes();
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
            cars.get(iCounter).setMinutesPermanence(cars.get(iCounter).getCheckOut(), cars.get(iCounter).getCheckIn());
            carsExit.add(cars.get(iCounter));
            cars.poll();
            iCounter++;
        }
        return carsRow;
    }

    public long averageMinutes() {
        long average = 0;
        for (Car car : carsExit) {
            average += car.getMinutesPermanence();
        }
        return average / carsExit.size();
    }
}
