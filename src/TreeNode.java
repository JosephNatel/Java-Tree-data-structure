/**
 * Created by Joseph Natel 108470761 CSE 214 HW4
 */

public class TreeNode {

    private String label ="";
    private String message = "";
    private String prompt = "";
    private boolean hasLeaf = false;
    private String parentLabel = "";
    private TreeNode parent;
    private int numChildern;
    private TreeNode childern[];

    /**
     * empty constructor for a TreeNode
     */
    public TreeNode () {

    }

    /**
     * a non-empty full constructor for TreeNode
     * @param label
     * the label for the TreeNode
     * @param prompt
     * @param message
     */
    public TreeNode (String label, String prompt, String message) {
        this.prompt = prompt;
        this.label = label;
        this.message = message;


    }

    public String getLabel() {
        return label;
    }

    public String getMessage() {
        return message;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public boolean hasLeaf () {
        return hasLeaf;
    }
    public void setHasLeaf () {
        hasLeaf = true;
    }

    public void setParentLabel(String parentLabel) {
        this.parentLabel = parentLabel;
    }

    public String getParentLabel() {
        return parentLabel;
    }

    public void setNumChildern(int numChildern) {
        this.numChildern = numChildern;
        childern = new TreeNode[numChildern];
    }

    public int getNumChildern() {
        return numChildern;
    }
    public void addChild(TreeNode child, String childLabel) {
        if(this.label== "root"){
            int counter = Integer.parseInt(childLabel);
            childern[counter-1] = child;

        }else if(childLabel.length()==1){

      //      String temp = childLabel.substring(getLabel().length());

            int counter = Integer.parseInt(childLabel);
            childern[counter-1] = child;
        }else{
            String temp = childLabel.substring(getLabel().length()+1);

            int counter = Integer.parseInt(temp);

            childern[counter-1] = child;
        }


    }
    public TreeNode getChild(int index){
        return childern[index-1];
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getParent() {
        return parent;
    }
}
