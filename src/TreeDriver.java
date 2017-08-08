/**
 * Created by Joseph Natel 108470761 CSE 214 HW4
 */

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreeDriver {


    static char input;
    static Scanner console = new Scanner(System.in);
    static String file;
    static ValidInput validInput = new ValidInput();
    static Tree load;

    public static void main (String[] arg) throws FileNotFoundException{

        boolean isRunning = true;
        run(isRunning);
        


    }


    private static void run (boolean isRunning) throws FileNotFoundException {

        do{
            input = printMainMenu();
            switch (input){
                case 'L':
                    System.out.print("\nEnter the file name> ");
                    file = console.nextLine();
                    load = new Tree(file);
                    break;
                case 'H':
                    System.out.println("\nHelp Session Starting....");
                    load.beginSession(null);

                    break;
                case 'B':
                    break;
                case 'T':
                    System.out.println("\nTraversing the tree in preorder: ");
                    if(load == null){
                        System.out.println("A Tree has not been loaded");
                    }else{
                        load.preOrder(null);
                    }
                    break;
                case 'Q':
                    System.out.println("Thank you for using our automated help services!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("That is not a valid option, please try again.");
                    break;
            }

        }while (isRunning);


    }

    private static char printMainMenu () {

        System.out.print("\n" +
                "    L - Load a Tree.\n" +
                "    H - Begin a Help Session.\n" +
                "    B - Go Back. \n" +
                "    T - Traverse the Tree in preorder. \n" +
                "    Q - Exit the program.\n");


        System.out.print("\nChoice> ");
        input = validInput.checkChar(console.nextLine());

        return input; //todo get input from user


    }





}
