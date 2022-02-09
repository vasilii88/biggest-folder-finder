import java.io.File;
import java.util.ArrayList;

public class Node {

    private File folder;
    private ArrayList<Node> children;
    private long size;
    private int levelNode;
    private int limit;


    public Node(File folder, int limit){
        this.folder = folder;
        children = new ArrayList<>();
        this.limit = limit;
    }

    public File getFolder() {
        return folder;
    }

    public void addChild (Node node) {
        node.setlevel(levelNode + 1);
        children.add(node);
    }

    public ArrayList getChildren() {
     return children;
    }
    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getLevelNode(){
        return levelNode;
    }

    public void setlevel(int level) {
        this.levelNode = level;
    }

    public int getLimit() {
        return limit;
    }
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(folder.getName() + " - level - " + getLevelNode() + " - " +  getSize() + "\n");
        for (Node child : children) {
            if (child.getSize()  < limit) {
                continue;
            }
            builder.append("\t".repeat(getLevelNode() + 1) + child.toString());
        }
        return builder.toString();
    }
}
