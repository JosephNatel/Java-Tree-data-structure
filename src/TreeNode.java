public class TreeNode {

    private String label ="";
    private String message = "";
    private String prompt = "";
    private boolean hasLeaf = false;

    public TreeNode () {

    }
    public TreeNode (String label, String message, String prompt) {
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

}
