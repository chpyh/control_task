/*
 * - Реализовать консольный пользовательский интерфейс с меню для 
 * навигации между вышеуказанными функциями.
 */
package view;

import java.util.Scanner;

public class choose_action {
    Scanner scanner = new Scanner(System.in);

    public char getOption(){
        System.out.println("Press number\n\tto add animal – 1, \n\t to count animals – 2 ");
        System.out.println("\tto add new command – 3, \n\tto print animals sorted by date of birth – 4");
        System.out.println("\tto show animal commands – 5");

        char action = scanner.next().charAt(0);
        scanner.close();
        return action;
    }


    public void getResult(){


    }


   
}
