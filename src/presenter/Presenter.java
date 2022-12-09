package presenter;

import view.*;

import java.util.LinkedList;

import model.*;

public class Presenter {
    View view = new View();
    CashRegister parking = new CashRegister();
    LinkedList<Car> carsRow = new LinkedList<Car>();

    // implementar objetos detipo cliente

    public void run() {
        int opt = view.showMenu("Porfavor escoge una opcion de este menu: \n1. Simular dia parqueadero \n2. Salir");
        view.print("---------------------");
        switch (opt) {
            case 1:
                carsRow = parking.carsArrival();
                int sizeCarsRow = carsRow.size();
                parking.carPermanence(carsRow);
                view.print("" + parking.simulate(sizeCarsRow));
                break;
            case 2:
                view.print("Saliendo...");
                System.exit(0);
                break;
            default:
                view.print("Opcion invalida");
                run();
                break;
        }
    }

    public static void main(String[] args) {
        new Presenter().run();
    }
}
