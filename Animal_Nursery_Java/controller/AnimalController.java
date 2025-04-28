package controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

import java.util.logging.Logger;

public class AnimalController {

    Scanner scanner = new Scanner(System.in);

    public int getOption(){

        try{

            int choice = scanner.nextInt();

            return choice;
        }catch{

        }

        
    }


}

//     public void run() {
//         Logger logger = Logger.getLogger(AnimalController.class.getName());

//         try {
//             FileHandler fileHandler = new FileHandler("log.txt", true);
//             logger.addHandler(fileHandler);
//             SimpleFormatter sFormat = new SimpleFormatter();// классический текстовый формат
//             fileHandler.setFormatter(sFormat);
//             try {
                
//                     }
//                 } else {
//                     System.out.println("");
//                     logger.log(Level.WARNING, "");
//                 }
//             } catch (InputMismatchException e) {
//                 logger.log(Level.WARNING, "");
//             } catch (Exception e) {
//                 logger.log(Level.WARNING, e.getMessage());
//             }
//         } catch (IOException e) {
//             logger.warning("Ошибка записи в файл ");
//         }
//     }

// }
