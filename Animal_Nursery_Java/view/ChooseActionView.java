/*
 * - Реализовать консольный пользовательский интерфейс с меню для 
 * навигации между вышеуказанными функциями.
 */
package view;
import java.util.Scanner;
import controller.AnimalController;

public class ChooseActionView {

    Scanner scanner = new Scanner(System.in);
    AnimalController controller = new AnimalController();

    public void printOption() {
        System.out.println("Press number to choose option:");
        System.out.println("1 – add animal;");
        System.out.println("2 – show count of animals;");
        System.out.println("3 – add new command;");
        System.out.println("4 – show animal commands;");
        System.out.println("5 – print animals sorted by date of birth");
        System.out.println("0 – exit");
    }


    public void run(){
        boolean isEnougth = false;
        AnimalController controller = new AnimalController();
        
        while(!isEnougth){
            printOption();
            int choice = controller.getOption();

            if (choice > 5 && choice < 0){   
                System.out.println("Error: enter numbers from 0 ;");
                
            }else if (choice == 0){
                isEnougth = true;
                scanner.close();
            }else{
                switch (choice){
                    case 1:
                        System.out.println("Input type, animal, name, date of birth and commands:");


                
                        break;
            
                    case 2:
                
                        break;
                
                    case 3:
                
                        break;
            
                    case 4:
                
                        break;  
            
                    case 5:
                
                        break;       


            }


        }


    }

}
}
