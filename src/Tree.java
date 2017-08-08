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


    /**
     * constructor for the tree class
     * @param loadFile
     * String of the tree file location
     * @throws FileNotFoundException
     * throws exception if the file is not found
     */
    public Tree (String loadFile) throws FileNotFoundException{
        try {
            FileInputStream inputStream = new FileInputStream(loadFile);
            Scanner scan = new Scanner(inputStream);
            createTree(scan);
        }catch (FileNotFoundException e){
            System.out.println("\nfile not found");
        }




    }

    /**
     * this method adds a node to the tree
     * @param label
     * label for the new node
     * @param prompt
     * the prompt for the new node
     * @param message
     * the message for the new node
     * @param parentLabel
     * the label of the new node's parent
     * @return
     * returns true if the new node was created
     */

    public boolean addNode (String label, String prompt, String message , String parentLabel) {
        TreeNode add = new TreeNode(label, prompt, message);
        add.setParentLabel(parentLabel);

        if(parentLabel == "root"){
            add.setParent(root);

        }else {
            add.setParent(getNodeReference(parentLabel));

        }
        add.getParent().addChild(add, label);
        /* statements used for debugging
        System.out.println("label: " + label);
        System.out.println("prompt: " + prompt);
        System.out.println("message: " + message);
        System.out.println("parentLabel: " + parentLabel+"\n");
        */
        return true;
    }

    /**
     * this method finds and returns a node with a given label
     * @param label
     * the label of the node you want to find
     * @return
     * returns the node once found
     */
    public TreeNode getNodeReference (String label) {
        TreeNode current;
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

    /**
     * prints the all the nodes in the tree in preorder
     * @param start
     * start node is the root node to start printing from
     */
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

    /**
     * prints the label, prompt and message of a given node
     * @param node
     * the node that you want to print the data from
     */
    private void printData (TreeNode node){
        System.out.println("label: " + node.getLabel());
        System.out.println("prompt: " + node.getPrompt());
        System.out.println("message: " + node.getMessage());
        System.out.println();
    }

    /**
     * this method handles input from the user and printing the statement assisated with the help session
     * @param start
     * the node that you want to start the help session from
     */
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

    /**
     * reads data from a file given by the user to create a tree, this method passes the data into addNode to create
     * a new Node
     * @param scan
     * the scanner that has been setup to read the file given by the user in the constructor
     */
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
             }
             else {
                System.out.println("\nTree created successfully!");
             }
        }

    }

    /**
     * checks if the next line is empty and skips that line if it is
     * @param scan
     * the scanner used to keep track where we are reading in the file
     * @return
     * returns the scanner ready to read the next line of empty input
     */
    private Scanner whitespace (Scanner scan) {
        while (scan.findInLine("(?=\\S)") == null){
            scan.nextLine();
        }
        return scan;
    }

}
