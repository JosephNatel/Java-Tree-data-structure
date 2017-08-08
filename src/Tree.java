/**
 * Created by Joseph Natel 108470761 CSE 214 HW4
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class Tree {
    private ValidInput validInput = new ValidInput();
    TreeNode root = new TreeNode();
    private int numChildern;




    public Tree (String loadFile) throws FileNotFoundException{
        try {
            FileInputStream inputStream = new FileInputStream(loadFile);
            Scanner scan = new Scanner(inputStream);
            createTree(scan);
        }catch (FileNotFoundException e){
            System.out.println("\nfile not found");
        }




    }



    public boolean addNode (String label, String prompt, String message , String parentLabel) {
        TreeNode add = new TreeNode(label, prompt, message);
        add.setParentLabel(parentLabel);

        if(parentLabel == "root"){
            add.setParent(root);

        }else {
            add.setParent(getNodeReference(parentLabel));

        }
        add.getParent().addChild(add, label);
        /*
        System.out.println("label: " + label);
        System.out.println("prompt: " + prompt);
        System.out.println("message: " + message);
        System.out.println("parentLabel: " + parentLabel+"\n");
        */
        return true;
    }


    public TreeNode getNodeReference (String label) {
        TreeNode current = new TreeNode();
        current = root;

        if(label == "root"||label == ""){
            return root;
        }
        while(true) {
            for (int i = 1; current.getNumChildern() >= i; i++) {
                if (current.getChild(i).getLabel().equalsIgnoreCase(label)) {
                    return current.getChild(i);
                }

            }
            current = getNodeReference(label.substring(0, label.length() - 2));
        }
    }


    public void preOrder (TreeNode start) {
        TreeNode current = new TreeNode();
        if(start == null){
            start = root;
        }
        current = start;
        printData(start);

        if(current.getNumChildern() != 0){
            for(int i = 1; i<=start.getNumChildern(); i++) {
                preOrder(start.getChild(i));
            }

        }




    }
    private void printData (TreeNode node){
        System.out.println("label: " + node.getLabel());
        System.out.println("prompt: " + node.getPrompt());
        System.out.println("message: " + node.getMessage());
        System.out.println();
    }
    public void beginSession (TreeNode start) {
        TreeNode current;
        if(start == null){
            start = root;
        }

        current = start;
        System.out.println("\n"+current.getMessage());
        for(int i = 1; i<=current.getNumChildern(); i++){
            System.out.println(i + " " + current.getChild(i).getPrompt());
        }
        System.out.println("B Go back to the Previous Menu.");
        System.out.println("0 Exit Session.");
        System.out.print("Choice> ");
        Scanner scanConsole = new Scanner(System.in);
        String input = scanConsole.nextLine();

        switch (input.charAt(0)){

            case '1':
                if(current.getChild(1).getNumChildern() != 0){
                    beginSession(current.getChild(1));
                }else {
                    System.out.println("\n"+current.getChild(1).getMessage());
                }
                break;
            case '2':
                if(current.getChild(2).getNumChildern() != 0){
                    beginSession(current.getChild(2));
                }else {
                    System.out.println("\n"+current.getChild(2).getMessage());
                }
                break;
            case '3':
                if(current.getChild(3).getNumChildern() != 0){
                    beginSession(current.getChild(3));
                }else {
                    System.out.println("\n"+current.getChild(3).getMessage());
                }
                break;
            case 'B':
                if(current == root){
                    System.out.println("You are already at the first help screen.");
                    beginSession(current);
                } else {
                    beginSession(current.getParent());
                }
                break;
            case '0':
                System.out.println("Exiting....");
                break;
            default:
                System.out.println("That is not a valid option.");
                break;


        }


    }
    private void createTree(Scanner scan) {


            scan = whitespace(scan);
            String label = scan.nextLine().trim();
            scan = whitespace(scan);
            String prompt = scan.nextLine().trim();
            scan = whitespace(scan);
            String message = scan.nextLine().trim();

            root = new TreeNode(label, prompt, message);
            String parentLabel = "root";
            root.setParent(null);
            scan = whitespace(scan);
            String children = scan.nextLine().trim();

            numChildern = Integer.parseInt(children.substring(parentLabel.length() + 1, parentLabel.length() + 2));
            root.setNumChildern(numChildern);


            while (scan.hasNext()) {

                for (int i = 0; i < numChildern; i++) {
                    scan = whitespace(scan);
                    label = scan.nextLine().trim();
                    scan = whitespace(scan);
                    prompt = scan.nextLine().trim();
                    scan = whitespace(scan);
                    message = scan.nextLine().trim();
                    addNode(label, prompt, message, parentLabel);

                }
                if (scan.hasNext()) {
                    scan = whitespace(scan);
                    String temp = scan.nextLine().trim();
                    parentLabel = temp.substring(0, temp.length() - 2);
                    String temp2 = temp.substring(temp.length() - 1, temp.length());
                    numChildern = Integer.parseInt(temp2);
                    getNodeReference(parentLabel).setNumChildern(numChildern);
                } else {
                    System.out.println("\nTree created successfully!");
                }


            }





    }

    private Scanner whitespace (Scanner scan) {
        while (scan.findInLine("(?=\\S)") == null){
            scan.nextLine();
        }
        return scan;
    }






}
