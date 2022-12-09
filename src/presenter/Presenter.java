package presenter;

import view.*;
import model.*;

public class Presenter {
    View view = new View();
    CashRegister parking = new CashRegister();

    // implementar objetos detipo cliente

    public void run() {
        int opt = view.showMenu("Porfavor escoge una opcion de este menu: \n1. Simular dia parqueadero \n2. Salir");
        view.print("---------------------");
        switch (opt) {
            case 1:
                view.print("" + parking.carPermanence(parking.carsArrival()));
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
