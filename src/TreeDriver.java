public class TreeDriver {

    private boolean isRunning = false;
    private char input;

    public static void main (String[] arg) {

        isRunning = true;
        run();

        


    }


    public void run () {

        do{
            input = printMainMenu();
            switch (input){
                case 'L':
                    break;
                case 'H':
                    break;
                case 'B':
                    break;
                case 'T':
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

    public char printMainMenu () {

        System.out.print("\n" +
                "    L - Load a Tree.\n" +
                "    H - Begin a Help Session.\n" +
                "    B - Go Back. \n" +
                "    T - Traverse the Tree in preorder. \n" +
                "    Q - Exit the program.\n");


        System.out.print("\nChoice> ");
        return input; //todo get input from user


    }





}
