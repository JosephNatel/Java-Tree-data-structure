import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class Tree {

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

        System.out.println("label: " + label);
        System.out.println("prompt: " + prompt);
        System.out.println("message: " + message);
        System.out.println("parentLabel: " + parentLabel+"\n");

        return true; // todo is created secussefully return true
    }


    public TreeNode getNodeReference (String label) {
        TreeNode current = new TreeNode();
        current = root;
        int counter = 1;
        boolean isFound = false;
        if(label == "root"){
            return root;
        }

        while (!isFound) {
            if (current.getLabel().equalsIgnoreCase(label)) {

                return current;
            }
            for (int i = 1; i <= current.getNumChildern(); i++) {
                if (current.getChild(i).getLabel().equalsIgnoreCase(label)) {
                    return current.getChild(i);
                }
            }

            if (current.getNumChildern() >= counter) {
                current = current.getChild(counter);
                counter++;
            } else {
                counter = 1;
                if (current.getChild(counter).getNumChildern() != 0) {
                    current = current.getChild(counter);
                } else {
                    counter++;
                }
            }
        }
        return null;
    }


    public void preOrder () {

    }
    public void beginSession () {

    }
    private void createTree(Scanner scan) {
        root = new TreeNode(scan.nextLine(), scan.nextLine(), scan.nextLine());
        String parentLabel = "root";
        root.setParent(null);


        numChildern = Integer.parseInt(scan.nextLine().substring(parentLabel.length()+1, parentLabel.length()+2));
        root.setNumChildern(numChildern);


        while(scan.hasNext()){

            for(int i = 0; i<numChildern; i++) {
                addNode(scan.nextLine(), scan.nextLine(), scan.nextLine(), parentLabel);

            }
            if(scan.hasNext()) {
                String temp = scan.nextLine();
                parentLabel = temp.substring(0, temp.length() - 2);
                String temp2 = temp.substring(temp.length() - 1, temp.length());
                numChildern = Integer.parseInt(temp2);
                getNodeReference(parentLabel).setNumChildern(numChildern);
            }else{
                System.out.println("\nFile has been read.");
            }




        }




    }




}
