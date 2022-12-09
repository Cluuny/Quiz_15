package view;

import java.util.Scanner;

public class View {
    private Scanner sc;

    public View() {
        sc = new Scanner(System.in);
    }

    public int showMenu(String message) {
        System.out.println(message);
        return sc.nextInt();
    }

    public void print(String message) {
        System.out.println(message);
    }
}
